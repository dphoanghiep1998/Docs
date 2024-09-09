package com.neko.hiepdph.mypiano.view.piano.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.common.DateUtils
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.data.model.AudioFile
import com.neko.hiepdph.mypiano.databinding.LayoutItemImportBinding

class ImportAudioAdapter(
    val onClickItem: (AudioFile) -> Unit,
) : RecyclerView.Adapter<ImportAudioAdapter.AudioViewHolder>() {
    private var listRecord = mutableListOf<AudioFile>()


    fun setData(mListRecord: MutableList<AudioFile>) {
        listRecord.clear()
        listRecord.addAll(mListRecord)
        notifyDataSetChanged()
    }

    inner class AudioViewHolder(val binding: LayoutItemImportBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val binding =
            LayoutItemImportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AudioViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRecord.size
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        with(holder) {
            val item = listRecord[adapterPosition]
            binding.tvName.text = item.name
            binding.tvDuration.text = DateUtils.convertSecondToString((item.duration.toFloat() / 1000).toInt())

            binding.root.clickWithDebounce {
                onClickItem.invoke(item)
            }


        }
    }


}