package com.neko.hiepdph.mypiano.view.setting

import android.content.Intent
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.openLink
import com.neko.hiepdph.mypiano.databinding.ActivitySettingBinding
import com.neko.hiepdph.mypiano.view.dialog.DialogRateUs
import com.neko.hiepdph.mypiano.view.language.LanguageActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingActivity : BaseActivity<ActivitySettingBinding>() {
    override fun getViewBinding(): ActivitySettingBinding {
        return ActivitySettingBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.containerLanguage.clickWithDebounce {
            startActivity(Intent(this, LanguageActivity::class.java).apply {
                putExtra(Constant.KEY_FROM_MAIN, true)
            })
        }
        binding.containerPrivacy.clickWithDebounce {
            openLink(Constant.URL_PRIVACY)
        }
        binding.containerRate.clickWithDebounce {
            val dialogRateUs = DialogRateUs().onCreateDialog(this)
            dialogRateUs.show()
        }
        binding.containerShare.clickWithDebounce { shareApp() }

        binding.btnBack.clickWithDebounce {
            finish()
        }
    }

    private fun shareApp() {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, Constant.URL_APP)
            startActivity(Intent.createChooser(shareIntent, "Choose one"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}