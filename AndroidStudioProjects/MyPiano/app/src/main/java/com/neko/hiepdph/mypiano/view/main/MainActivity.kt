package com.neko.hiepdph.mypiano.view.main

import android.app.Dialog
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.ThemeMainModel
import com.neko.hiepdph.mypiano.databinding.ActivityMainBinding
import com.neko.hiepdph.mypiano.view.dialog.DialogRateUs
import com.neko.hiepdph.mypiano.view.dialog.DialogShowExitConfirm
import com.neko.hiepdph.mypiano.view.drumset.DrumSetActivity
import com.neko.hiepdph.mypiano.view.guitar.GuitarActivity
import com.neko.hiepdph.mypiano.view.piano.PianoActivity
import com.neko.hiepdph.mypiano.view.saxophone.SaxophoneActivity
import com.neko.hiepdph.mypiano.view.setting.SettingActivity
import com.neko.hiepdph.mypiano.view.theme.ThemeActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var dialogShowExitConfirm: Dialog? = null

    companion object {
        var isRunning = false
        var count = 0
    }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        dialogShowExitConfirm = DialogShowExitConfirm(onPositive = {
            finishAffinity()
            exitProcess(-1)
        }, onNegative = {}).onCreateDialog(this)
        changeBackPressCallBack {
            if (dialogShowExitConfirm?.isShowing == false) {
                dialogShowExitConfirm?.show()
            } else {
                dialogShowExitConfirm?.dismiss()
            }

        }
        if(intent.getBooleanExtra(Constant.KEY_USER_RATED,false)){
            if ((!config.isUserRated && config.timeShowRate <= System.currentTimeMillis() - TimeUnit.DAYS.toMillis(
                    3
                )) || (!config.isUserRated && config.timeShowRate == 0L)
            ) {
                val dialogRateUs = DialogRateUs().onCreateDialog(this)
                dialogRateUs.show()
            }
            intent.removeExtra(Constant.KEY_USER_RATED)
        }
        isRunning = true
        initButton()
    }

    override fun onResume() {
        super.onResume()
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
        binding.root.setBackgroundResource(listData[config.indexThumbMain].resId)
    }

    private fun initButton() {
        binding.btnSetting.clickWithDebounce {
            startActivity(Intent(this, SettingActivity::class.java))
        }
        binding.btnPiano.clickWithDebounce {
            activityLauncher.launch((Intent(this, PianoActivity::class.java)))
        }

        binding.btnGuitar.clickWithDebounce {
            activityLauncher.launch((Intent(this, GuitarActivity::class.java)))
        }

        binding.btnDrumSet.clickWithDebounce {
            activityLauncher.launch(Intent(this, DrumSetActivity::class.java))
        }

        binding.btnSaxophone.clickWithDebounce {
            activityLauncher.launch(Intent(this, SaxophoneActivity::class.java))
        }

        binding.btnTheme.clickWithDebounce {
            startActivity(Intent(this, ThemeActivity::class.java))
        }

        binding.btnSetting.clickWithDebounce {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == 3001) {
                Log.d("TAG", "config.isUserRated" + config.isUserRated)
                Log.d("TAG", "config.isUserRated" + config.timeShowRate)


                if ((!config.isUserRated && config.timeShowRate <= System.currentTimeMillis() - TimeUnit.DAYS.toMillis(
                        3
                    )) || (!config.isUserRated && config.timeShowRate == 0L)
                ) {
                    val dialogRateUs = DialogRateUs().onCreateDialog(this)
                    dialogRateUs.show()
                }

            }
        }

}