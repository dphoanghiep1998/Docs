package com.neko.hiepdph.mypiano.view.guitar

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.FastUtils
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.GuitarStyle
import com.neko.hiepdph.mypiano.data.model.PianoStyle
import com.neko.hiepdph.mypiano.databinding.ActivityStyleGuitarBinding
import com.neko.hiepdph.mypiano.view.guitar.viewpager.StyleGuitarViewPagerAdapter
import com.neko.hiepdph.mypiano.view.piano.viewpager.StyleViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint

class StyleGuitarActivity : BaseActivity<ActivityStyleGuitarBinding>() {
    private var styleAdapter: StyleGuitarViewPagerAdapter? = null
    private var listOfStyle = mutableListOf<GuitarStyle>()

    override fun getViewBinding(): ActivityStyleGuitarBinding {
        return ActivityStyleGuitarBinding.inflate(layoutInflater)
    }

    override fun initView() {
        getListStyle()
        styleAdapter = StyleGuitarViewPagerAdapter(listOfStyle)
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
        binding.viewpager.currentItem = config.indexThemeGuitar
    }

    private fun initButton() {
        binding.btnBack.clickWithDebounce {
            finish()
        }

        binding.btnApply.clickWithDebounce {
            config.indexThemeGuitar = binding.viewpager.currentItem
            startActivity(Intent(this, GuitarActivity::class.java))
            finish()
        }
    }

    private fun getListStyle() {
        listOfStyle.addAll(
            mutableListOf(
                GuitarStyle(0, R.drawable.ic_bg_theme_guitar_1),
                GuitarStyle(1, R.drawable.ic_bg_theme_guitar_2),
                GuitarStyle(2, R.drawable.ic_bg_theme_guitar_3),
                GuitarStyle(3, R.drawable.ic_bg_theme_guitar_4),
                GuitarStyle(4, R.drawable.ic_bg_theme_guitar_5),

            )
        )
    }


}