package com.neko.hiepdph.mypiano.view.piano.fragmentlearn.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.DateUtils
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.data.model.MicRecord
import com.neko.hiepdph.mypiano.databinding.LayoutItemMicRecordBinding
import com.neko.hiepdph.mypiano.databinding.LayoutMenuMicRecordBinding

class MicRecordAdapter(
    val onClickItem: (MicRecord) -> Unit,
    val onClearItem: () -> Unit,
    val onSuspendItem:()->Unit,
    val onDelete: (MicRecord) -> Unit,
    val onShare: (MicRecord) -> Unit,
    val onRename: (MicRecord) -> Unit
) : RecyclerView.Adapter<MicRecordAdapter.MicViewHolder>() {
    private var popupWindowAdapter: PopupWindow? = null
    private var currentIndex = -1
    private var listRecord = mutableListOf<MicRecord>()

    fun setData(mListRecord: MutableList<MicRecord>) {
        listRecord.clear()
        listRecord.addAll(mListRecord)
        notifyDataSetChanged()
    }

    inner class MicViewHolder(val binding: LayoutItemMicRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MicViewHolder {
        val binding =
            LayoutItemMicRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MicViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRecord.size
    }

    fun resetStatus() {
        currentIndex = -1
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MicViewHolder, position: Int) {
        with(holder) {
            val item = listRecord[adapterPosition]
            binding.tvTitle.text = item.name
            if (adapterPosition == currentIndex) {
                binding.tvTitle.setTextColor(itemView.context.getColor(R.color.accent))
                binding.tvPlay.setImageResource(R.drawable.ic_pause)
            } else {
                binding.tvTitle.setTextColor(itemView.context.getColor(R.color.white))
                binding.tvPlay.setImageResource(R.drawable.ic_play)
            }
            binding.tvDuration.text = DateUtils.convertSecondToString(item.duration)
            binding.tvTime.text = DateUtils.convertTimeInMillisecondToTimeString(item.time)
            binding.btnOption.clickWithDebounce {
                onSuspendItem?.invoke()
                showWindowPopup(itemView.context,item,binding.btnOption)
            }
            binding.root.clickWithDebounce {
                if (currentIndex == adapterPosition) {
                    currentIndex = -1
                    onClearItem.invoke()
                    notifyDataSetChanged()
                } else {
                    onClickItem.invoke(item)
                    currentIndex = adapterPosition
                    notifyDataSetChanged()
                }
                onClickItem.invoke(item)
            }

        }
    }

    private fun showWindowPopup(context: Context, item: MicRecord, view: View) {
        val inflater: LayoutInflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?)!!
        val bindingLayout = LayoutMenuMicRecordBinding.inflate(inflater, null, false)
        popupWindowAdapter = PopupWindow(
            bindingLayout.root,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        popupWindowAdapter?.isOutsideTouchable = true
        popupWindowAdapter?.setBackgroundDrawable(
            ColorDrawable(
                context.getColor(
                    android.R.color.transparent
                )
            )
        )


        bindingLayout.containerDelete.clickWithDebounce {
            onDelete.invoke(item)
            popupWindowAdapter?.dismiss()
        }
        bindingLayout.containerRename.clickWithDebounce {
            onRename.invoke(item)
            popupWindowAdapter?.dismiss()
        }
        bindingLayout.containerShare.clickWithDebounce {
            onShare.invoke(item)
            popupWindowAdapter?.dismiss()

        }
        val values = IntArray(2)
        view.getLocationInWindow(values)
        val positionOfIcon = values[1]
        val displayMetrics: DisplayMetrics = view.context.resources.displayMetrics
        val height = displayMetrics.heightPixels * 2 / 3

        if (positionOfIcon < height) {
            popupWindowAdapter?.showAsDropDown(
                view, 0, -view.height + popupWindowAdapter!!.height
            )
        } else {
            popupWindowAdapter?.showAsDropDown(
                view, 0, -400
            )
        }
    }
}