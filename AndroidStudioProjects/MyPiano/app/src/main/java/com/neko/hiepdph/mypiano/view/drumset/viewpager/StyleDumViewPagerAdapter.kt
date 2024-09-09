package com.neko.hiepdph.mypiano.view.drumset.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.data.model.DrumSetStyleBg
import com.neko.hiepdph.mypiano.data.model.GuitarStyle
import com.neko.hiepdph.mypiano.data.model.PianoStyle
import com.neko.hiepdph.mypiano.databinding.LayoutItemPianoStyleBinding

class StyleDumViewPagerAdapter(val listStyle: MutableList<DrumSetStyleBg>) :
    RecyclerView.Adapter<StyleDumViewPagerAdapter.DrumStyleViewHolder>() {


    inner class DrumStyleViewHolder(val binding: LayoutItemPianoStyleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DrumSetStyleBg) {
            binding.imgPianoStyle.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrumStyleViewHolder {
        val binding =
            LayoutItemPianoStyleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrumStyleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStyle.size
    }

    override fun onBindViewHolder(holder: DrumStyleViewHolder, position: Int) {
        with(holder) {
            val item = listStyle[adapterPosition]
            onBind(item)
        }
    }

}