package com.neko.hiepdph.mypiano.view.piano

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.FastUtils
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.PianoStyle
import com.neko.hiepdph.mypiano.databinding.ActivityStylePianoBinding
import com.neko.hiepdph.mypiano.view.piano.viewpager.StyleViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint

class StylePianoActivity : BaseActivity<ActivityStylePianoBinding>() {
    private var styleAdapter: StyleViewPagerAdapter? = null
    private var listOfStyle = mutableListOf<PianoStyle>()

    override fun getViewBinding(): ActivityStylePianoBinding {
        return ActivityStylePianoBinding.inflate(layoutInflater)
    }

    override fun initView() {
        getListStyle()
        styleAdapter = StyleViewPagerAdapter(listOfStyle)
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
        binding.viewpager.currentItem = config.indexTheme
    }

    private fun initButton() {
        binding.btnBack.clickWithDebounce {
            finish()
        }

        binding.btnApply.clickWithDebounce {
            config.indexTheme = binding.viewpager.currentItem
            finish()
        }
    }

    private fun getListStyle() {
        listOfStyle.addAll(
            mutableListOf(
                PianoStyle(0, R.drawable.ic_bg_s1),
                PianoStyle(1, R.drawable.ic_bg_s2),
                PianoStyle(2, R.drawable.ic_bg_s3),
                PianoStyle(3, R.drawable.ic_bg_s4),
                PianoStyle(4, R.drawable.ic_bg_s5),
                PianoStyle(5, R.drawable.ic_bg_s6),
                PianoStyle(6, R.drawable.ic_bg_s7),
                PianoStyle(7, R.drawable.ic_bg_s8),
                PianoStyle(8, R.drawable.ic_bg_s9),
                PianoStyle(9, R.drawable.ic_bg_s10),
                PianoStyle(10, R.drawable.ic_bg_s11),
                PianoStyle(11, R.drawable.ic_bg_s12),
                PianoStyle(12, R.drawable.ic_bg_s13),
                PianoStyle(13, R.drawable.ic_bg_s14),
                PianoStyle(14, R.drawable.ic_bg_s15),
                PianoStyle(15, R.drawable.ic_bg_s16),
                PianoStyle(16, R.drawable.ic_bg_s17),
                PianoStyle(17, R.drawable.ic_bg_s18),
                PianoStyle(18, R.drawable.ic_bg_s19),
                PianoStyle(36, R.drawable.ic_bg_s20),
                PianoStyle(19, R.drawable.ic_bg_s21),
                PianoStyle(20, R.drawable.ic_bg_s22),
                PianoStyle(21, R.drawable.ic_bg_s23),
                PianoStyle(22, R.drawable.ic_bg_s24),
                PianoStyle(23, R.drawable.ic_bg_s25),
                PianoStyle(24, R.drawable.ic_bg_s26),
                PianoStyle(25, R.drawable.ic_bg_s27),
                PianoStyle(26, R.drawable.ic_bg_s28),
                PianoStyle(27, R.drawable.ic_bg_s29),
                PianoStyle(28, R.drawable.ic_bg_s30),
                PianoStyle(29, R.drawable.ic_bg_s31),
                PianoStyle(30, R.drawable.ic_bg_s32),
                PianoStyle(31, R.drawable.ic_bg_s33),
                PianoStyle(32, R.drawable.ic_bg_s34),
                PianoStyle(33, R.drawable.ic_bg_s35),
                PianoStyle(34, R.drawable.ic_bg_s36),
                PianoStyle(35, R.drawable.ic_bg_s38),
            )
        )
    }


}