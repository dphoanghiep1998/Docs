package com.neko.hiepdph.mypiano.view.main

import android.content.Intent
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.ThemeMainModel
import com.neko.hiepdph.mypiano.databinding.ActivityMainBinding
import com.neko.hiepdph.mypiano.view.drumset.DrumSetActivity
import com.neko.hiepdph.mypiano.view.guitar.GuitarActivity
import com.neko.hiepdph.mypiano.view.piano.PianoActivity
import com.neko.hiepdph.mypiano.view.saxophone.SaxophoneActivity
import com.neko.hiepdph.mypiano.view.theme.ThemeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    companion object {
        var isRunning = false
    }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        isRunning = true
        initButton()
    }

    override fun onResume() {
        super.onResume()
        val listData = mutableListOf(
            ThemeMainModel(0, R.drawable.ic_theme_main_1),
            ThemeMainModel(1, R.drawable.ic_theme_main_2),
            ThemeMainModel(2, R.drawable.ic_theme_main_3),
            ThemeMainModel(3, R.drawable.ic_theme_main_4),
            ThemeMainModel(4, R.drawable.ic_theme_main_5),
            ThemeMainModel(5, R.drawable.ic_theme_main_6),
            ThemeMainModel(6, R.drawable.ic_theme_main_7),
            ThemeMainModel(7, R.drawable.ic_theme_main_8),
            ThemeMainModel(8, R.drawable.ic_theme_main_9),
            ThemeMainModel(9, R.drawable.ic_theme_main_10),
            ThemeMainModel(10, R.drawable.ic_theme_main_11),
            ThemeMainModel(11, R.drawable.ic_theme_main_12),
            ThemeMainModel(12, R.drawable.ic_theme_main_13),
            ThemeMainModel(13, R.drawable.ic_theme_main_14),
            ThemeMainModel(14, R.drawable.ic_theme_main_15),
            ThemeMainModel(15, R.drawable.ic_theme_main_16),
            ThemeMainModel(16, R.drawable.ic_theme_main_17),
            ThemeMainModel(17, R.drawable.ic_theme_main_18),
            ThemeMainModel(18, R.drawable.ic_theme_main_19),
            ThemeMainModel(19, R.drawable.ic_theme_main_20),
        )
        binding.root.setBackgroundResource(listData[config.indexThumbMain].resId)
    }

    private fun initButton() {
        binding.btnSetting.clickWithDebounce {

        }
        binding.btnPiano.clickWithDebounce {
            startActivity(Intent(this, PianoActivity::class.java))
        }

        binding.btnGuitar.clickWithDebounce {
            startActivity(Intent(this, GuitarActivity::class.java))
        }

        binding.btnDrumSet.clickWithDebounce {
            startActivity(Intent(this, DrumSetActivity::class.java))
        }

        binding.btnSaxophone.clickWithDebounce {
            startActivity(Intent(this, SaxophoneActivity::class.java))
        }

        binding.btnTheme.clickWithDebounce {
            startActivity(Intent(this, ThemeActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

}