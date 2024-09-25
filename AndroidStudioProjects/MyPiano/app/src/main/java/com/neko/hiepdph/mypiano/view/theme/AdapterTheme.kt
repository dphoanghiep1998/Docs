package com.neko.hiepdph.mypiano.view.theme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.data.model.ThemeMainModel
import com.neko.hiepdph.mypiano.databinding.ItemThemeMainBinding

class AdapterTheme(val onclick: (ThemeMainModel) -> Unit) :
    RecyclerView.Adapter<AdapterTheme.ThemeViewHolder>() {
    private var listData = mutableListOf<ThemeMainModel>()
    private var selectedIndex = -1

    inner class ThemeViewHolder(val binding: ItemThemeMainBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setData(listTheme: List<ThemeMainModel>) {
        listData.clear()
        listData.addAll(listTheme)
        notifyDataSetChanged()
    }

    fun setSelected(id: Int) {
        selectedIndex = id
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        val binding =
            ItemThemeMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ThemeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        with(holder) {
            val item = listData[absoluteAdapterPosition]
//            binding.imageFull.setImageResource(item.resId)
            Glide.with(binding.imageFull).load(item.resId).into(binding.imageFull)
            if (absoluteAdapterPosition == selectedIndex) {
                binding.tick.setImageResource(R.drawable.ic_tick_on)
            } else {
                binding.tick.setImageResource(R.drawable.ic_tick_off)
            }

            binding.root.clickWithDebounce {
                notifyItemChanged(selectedIndex,Unit)
                selectedIndex = adapterPosition
                notifyItemChanged(selectedIndex)
                onclick(item)
            }
        }
    }
}