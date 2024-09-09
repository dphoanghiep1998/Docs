package com.neko.hiepdph.mypiano.view.piano.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.data.model.PianoStyle
import com.neko.hiepdph.mypiano.databinding.LayoutItemPianoStyleBinding

class StyleViewPagerAdapter(val listStyle: MutableList<PianoStyle>) :
    RecyclerView.Adapter<StyleViewPagerAdapter.PianoStyleViewHolder>() {
    inner class PianoStyleViewHolder(val binding: LayoutItemPianoStyleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item:PianoStyle){
            binding.imgPianoStyle.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PianoStyleViewHolder {
        val binding =
            LayoutItemPianoStyleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PianoStyleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStyle.size
    }

    override fun onBindViewHolder(holder: PianoStyleViewHolder, position: Int) {
        with(holder){
            val item = listStyle[adapterPosition]
            onBind(item)
        }
    }

}