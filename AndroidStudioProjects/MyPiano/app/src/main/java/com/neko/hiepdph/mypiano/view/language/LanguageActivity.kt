package com.neko.hiepdph.mypiano.view.language

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.common.hide
import com.neko.hiepdph.mypiano.common.locale.supportDisplayLang
import com.neko.hiepdph.mypiano.common.show
import com.neko.hiepdph.mypiano.databinding.ActivityLanguageBinding
import com.neko.hiepdph.mypiano.view.getstarted.GetStartedActivity
import com.neko.hiepdph.mypiano.view.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class LanguageActivity : BaseActivity<ActivityLanguageBinding>() {
    private var currentLanguage = "en"
    private var adapter: AdapterLanguage? = null
    override fun getViewBinding(): ActivityLanguageBinding {
        return ActivityLanguageBinding.inflate(layoutInflater)
    }

    override fun initView() {
        currentLanguage = config.savedLanguage
        changeBackPressCallBack {
            if (intent.getBooleanExtra(Constant.KEY_FROM_MAIN, false)) {
                finish()
            } else {

            }
        }
        initRecyclerView()
        initButton()
        insertAds()
    }


    private fun initButton() {
        binding.btnCheck.hide()
        binding.loading.show()
        binding.btnCheck.clickWithDebounce {
            clickApplyBtn()
        }

        binding.containerCurrentLanguage.clickWithDebounce {
            binding.tick.setImageResource(R.drawable.ic_tick_on)
            binding.tvCountry.setTextColor(getColor(R.color.white))
            binding.containerCurrentLanguage.setBackgroundResource(R.drawable.bg_lang_selected)
            adapter?.removeSelectedId()
            currentLanguage = config.savedLanguage
        }
    }

    private fun clickApplyBtn() {
        val isFromMain = intent.getBooleanExtra(Constant.KEY_FROM_MAIN, false)
//        showInterAds(action = {
        if (!isFromMain) {
//            pushEvent( "click_language_save")
            config.savedLanguage = currentLanguage
            startActivity(Intent(this, GetStartedActivity::class.java))
            finish()
        } else {
            config.savedLanguage = currentLanguage
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
//        }, actionFailed = {
//            if (!isFromMain) {
//                pushEvent(this, "click_language_save")
//                config.isPassLang = true
//                config.savedLanguage = currentLanguage
//                startActivity(Intent(this, GetStartedActivity::class.java))
//                finish()
//            } else {
//                config.savedLanguage = currentLanguage
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }
//        }, InterAdsEnum.LANG)


    }

    private fun initRecyclerView() {
        val mDisplayLangList: MutableList<Triple<Int, Int, Locale>> =
            supportDisplayLang().toMutableList()
        adapter = AdapterLanguage(this, onCLickItem = {
            currentLanguage = it.third.language
            binding.tick.setImageResource(R.drawable.ic_tick_on)
            binding.tvCountry.setTextColor(getColor(R.color.white))
            binding.containerCurrentLanguage.setBackgroundResource(R.drawable.bg_n3_stroke_corner_8)
//            binding.imvFlag.setImageResource(it.second)
//            binding.tvCountry.text = getText(it.first)
//            val newDisplayLangList =
//                mDisplayLangList.filter { l -> l.third.language != it.third.language }
//                    .toMutableList()
//            adapter?.setData(newDisplayLangList)
        })

//        adapter?.setData(mDisplayLangList)
        handleUnSupportLang(mDisplayLangList)

        binding.rcvLanguage.adapter = adapter
        binding.rcvLanguage.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }


    private fun handleUnSupportLang(mLanguageList: MutableList<Triple<Int, Int, Locale>>) {
        var support = false
        mLanguageList.forEachIndexed { index, item ->
            if (item.third.language == currentLanguage) {
                support = true
                binding.tick.setImageResource(R.drawable.ic_tick_lang_on)
                binding.imvFlag.setImageResource(item.second)
                binding.tvCountry.text = getText(item.first)
                val newDisplayLangList =
                    mLanguageList.filter { l -> l.third.language != item.third.language }
                        .toMutableList()
                adapter?.setData(newDisplayLangList)
            }
        }
        if (!support) {
            currentLanguage = mLanguageList[0].third.language
            binding.tick.setImageResource(R.drawable.ic_tick_lang_on)
            binding.imvFlag.setImageResource(mLanguageList[0].second)
            binding.tvCountry.text = getText(mLanguageList[0].first)
            val newDisplayLangList =
                mLanguageList.filter { l -> l.third.language != mLanguageList[0].third.language }
                    .toMutableList()
            adapter?.setData(newDisplayLangList)
        }
    }


    private fun insertAds() {
//        AdsCore.showNativeAds(this, binding.nativeAdmob, binding.nativeMax, {
//            binding.btnCheck.show()
//            binding.loading.hide()
//        }, {
//            binding.btnCheck.show()
//            binding.loading.hide()
//        }, NativeTypeEnum.LANGUAGE
//        )
    }
}