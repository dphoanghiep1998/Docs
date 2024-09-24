package com.neko.hiepdph.mypiano.view.theme

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.ThemeMainModel
import com.neko.hiepdph.mypiano.databinding.ActivityThemeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThemeActivity : BaseActivity<ActivityThemeBinding>() {
    private var adapter: AdapterTheme? = null
    private var currentIndex = 0
    override fun getViewBinding(): ActivityThemeBinding {
        return ActivityThemeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.btnApply.isEnabled = true
        binding.btnApply.setTextColor(getColor(R.color.white))
        binding.btnApply.setBackgroundResource(R.drawable.bg_gradient_learn)
        currentIndex = config.indexThumbMain
        binding.btnBack.clickWithDebounce {
            finish()
        }

        binding.btnApply.clickWithDebounce {
            config.indexThumbMain = currentIndex
            finish()
        }
        adapter = AdapterTheme {
            currentIndex = it.id
            binding.btnApply.isEnabled = true
            binding.btnApply.setTextColor(getColor(R.color.white))
            binding.btnApply.setBackgroundResource(R.drawable.bg_gradient_learn)
        }
        val gridLayoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        binding.rcvTheme.layoutManager = gridLayoutManager

        binding.rcvTheme.adapter = adapter

        val listData = mutableListOf(
            ThemeMainModel(0, R.drawable.ic_theme_main_27),
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
            ThemeMainModel(20, R.drawable.ic_theme_main_21),
            ThemeMainModel(21, R.drawable.ic_theme_main_22),
            ThemeMainModel(22, R.drawable.ic_theme_main_23),
            ThemeMainModel(23, R.drawable.ic_theme_main_24),
            ThemeMainModel(24, R.drawable.ic_theme_main_25),
            ThemeMainModel(25, R.drawable.ic_theme_main_26),
            ThemeMainModel(26, R.drawable.ic_theme_main_1),
        )
        adapter?.setData(listData)
        adapter?.setSelected(currentIndex)

    }

}