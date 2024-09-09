package com.neko.hiepdph.mypiano.view.piano.fragmentlearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.data.model.SongModel
import com.neko.hiepdph.mypiano.databinding.LayoutItemSongBinding

class SongAdapter(val onClickSong: (index: Int) -> Unit) :
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    private var currentIndex = 0
    private var listSong = mutableListOf<SongModel>()

    fun setData(mListSong: MutableList<SongModel>) {
        listSong.clear()
        listSong.addAll(mListSong)
        notifyDataSetChanged()
    }

    inner class SongViewHolder(val binding: LayoutItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding =
            LayoutItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        with(holder) {
            val item = listSong[adapterPosition]
            binding.tvSong.text = item.name
            binding.imageSong.setImageResource(item.image)
            if (adapterPosition == currentIndex) {
                binding.tvSong.setTextColor(itemView.context.getColor(R.color.accent))
            } else {
                binding.tvSong.setTextColor(itemView.context.getColor(R.color.white))
            }

            binding.root.clickWithDebounce {
                onClickSong.invoke(adapterPosition)
            }

        }
    }
}