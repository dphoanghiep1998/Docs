package com.neko.hiepdph.mypiano.view.guitar.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.data.model.GuitarStyle
import com.neko.hiepdph.mypiano.data.model.PianoStyle
import com.neko.hiepdph.mypiano.databinding.LayoutItemPianoStyleBinding

class StyleGuitarViewPagerAdapter(val listStyle: MutableList<GuitarStyle>) :
    RecyclerView.Adapter<StyleGuitarViewPagerAdapter.GuitarStyleViewHolder>() {
    inner class GuitarStyleViewHolder(val binding: LayoutItemPianoStyleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: GuitarStyle) {
            binding.imgPianoStyle.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuitarStyleViewHolder {
        val binding =
            LayoutItemPianoStyleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuitarStyleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStyle.size
    }

    override fun onBindViewHolder(holder: GuitarStyleViewHolder, position: Int) {
        with(holder) {
            val item = listStyle[adapterPosition]
            onBind(item)
        }
    }

}