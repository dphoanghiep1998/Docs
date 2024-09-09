package com.neko.hiepdph.mypiano.view.drumset

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.FastUtils
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.DrumSetStyleBg
import com.neko.hiepdph.mypiano.databinding.ActivityStyleDrumBinding
import com.neko.hiepdph.mypiano.view.drumset.viewpager.StyleDumViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint

class StyleDrumActivity : BaseActivity<ActivityStyleDrumBinding>() {
    private var styleAdapter: StyleDumViewPagerAdapter? = null
    private var listOfStyle = mutableListOf<DrumSetStyleBg>()

    override fun getViewBinding(): ActivityStyleDrumBinding {
        return ActivityStyleDrumBinding.inflate(layoutInflater)
    }

    override fun initView() {
        getListStyle()
        styleAdapter = StyleDumViewPagerAdapter(listOfStyle)
        binding.viewpager.adapter = styleAdapter
        binding.viewpager.clipChildren = false
        binding.viewpager.clipToPadding = false
        binding.viewpager.currentItem = 0
        binding.viewpager.offscreenPageLimit = 3
        binding.viewpager.setPadding(
            FastUtils.getWidthScreen(this) / 2, 0, FastUtils.getWidthScreen(this) / 2, 0
        )
        binding.viewpager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            page.scaleY = 0.85f + (1 - abs(position)) * 0.15f
        }
        binding.viewpager.setPageTransformer(transformer)


        binding.dot.attachTo(binding.viewpager)
        initButton()
        binding.viewpager.currentItem = config.indexThemeDrum
    }

    private fun initButton() {
        binding.btnBack.clickWithDebounce {
            finish()
        }

        binding.btnApply.clickWithDebounce {
            config.indexThemeDrum = binding.viewpager.currentItem
            startActivity(Intent(this, DrumSetActivity::class.java))
            finish()
        }
    }

    private fun getListStyle() {
        listOfStyle.addAll(
            mutableListOf(
                DrumSetStyleBg(0, R.drawable.ic_bg_theme_drum_1),
                DrumSetStyleBg(1, R.drawable.ic_bg_theme_drum_3),
                DrumSetStyleBg(2, R.drawable.ic_bg_theme_drum_4),
                DrumSetStyleBg(3, R.drawable.ic_bg_theme_drum_5),
                DrumSetStyleBg(4, R.drawable.ic_bg_theme_drum_2),

                )
        )
    }


}