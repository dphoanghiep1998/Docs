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
import com.neko.hiepdph.mypiano.data.model.KeysRecord
import com.neko.hiepdph.mypiano.databinding.LayoutItemKeyRecordBinding
import com.neko.hiepdph.mypiano.databinding.LayoutMenuKeyRecordBinding

class KeyRecordAdapter(
    val onClickItem: (KeysRecord) -> Unit,
    val onDelete: (item: KeysRecord) -> Unit,
    val onRename: (item: KeysRecord) -> Unit
) : RecyclerView.Adapter<KeyRecordAdapter.KeyViewHolder>() {
    private var currentIndex = 0
    private var listRecord = mutableListOf<KeysRecord>()
    private var popupWindowAdapter: PopupWindow? = null


    fun setData(mListRecord: MutableList<KeysRecord>) {
        listRecord.clear()
        listRecord.addAll(mListRecord)
        notifyDataSetChanged()
    }

    inner class KeyViewHolder(val binding: LayoutItemKeyRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyViewHolder {
        val binding =
            LayoutItemKeyRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KeyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRecord.size
    }

    override fun onBindViewHolder(holder: KeyViewHolder, position: Int) {
        with(holder) {
            val item = listRecord[adapterPosition]
            binding.tvTitle.text = item.name
            if (adapterPosition == currentIndex) {
                binding.tvTitle.setTextColor(itemView.context.getColor(R.color.accent))
            } else {
                binding.tvTitle.setTextColor(itemView.context.getColor(R.color.white))
            }
            binding.tvDuration.text = DateUtils.convertSecondToString(item.duration)
            binding.tvTime.text = DateUtils.convertTimeInMillisecondToTimeString(item.time)

            binding.root.clickWithDebounce {
                onClickItem.invoke(item)
            }
            binding.btnOption.clickWithDebounce {
                showWindowPopup(itemView.context,item,binding.btnOption)
            }

        }
    }

    private fun showWindowPopup(context: Context, item: KeysRecord, view: View) {
        val inflater: LayoutInflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?)!!
        val bindingLayout = LayoutMenuKeyRecordBinding.inflate(inflater, null, false)
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