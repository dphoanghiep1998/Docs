package com.neko.hiepdph.mypiano.view.onboard

import android.content.Intent
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback

import com.example.baseproject.view.onboard.adapter.ViewPagerAdapter
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.hide
import com.neko.hiepdph.mypiano.common.show
import com.neko.hiepdph.mypiano.databinding.ActivityOnboardBinding
import com.neko.hiepdph.mypiano.view.getstarted.GetStartedActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardActivity : BaseActivity<ActivityOnboardBinding>() {
    private lateinit var viewpagerAdapter: ViewPagerAdapter
    private var isAdsLoaded = true
//    private var isAdsLoaded = false
    private var isAdsLoadSuccess = true

    override fun getViewBinding(): ActivityOnboardBinding {
        return ActivityOnboardBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.btnNext.hide()
        initViewPager()
        initButton()
        changeBackPressCallBack {

        }
        loadAds()
    }

    private fun initButton() {
        binding.loadingAds.hide()
        binding.btnNext.show()
        binding.btnNext.setOnClickListener {
            val currentItem = binding.vpOnboard.currentItem
            if (binding.vpOnboard.currentItem == 2) {
                binding.btnNext.hide()
                if (isAdsLoaded) {
                    binding.btnStart.show()
                    binding.loadingAds.hide()
                } else {
                    binding.btnStart.hide()
                    binding.loadingAds.show()
                }
            } else {
                binding.vpOnboard.currentItem = currentItem + 1
            }
        }

        binding.btnStart.clickWithDebounce {
            startActivity(Intent(this,GetStartedActivity::class.java))
            finish()
        }

    }

    private fun initViewPager() {
        viewpagerAdapter = ViewPagerAdapter(
            supportFragmentManager, lifecycle
        )
        binding.vpOnboard.adapter = viewpagerAdapter
        binding.dotsIndicator.attachTo(binding.vpOnboard)

        binding.vpOnboard.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (binding.vpOnboard.currentItem) {
                    0, 1 -> {
                        binding.containerAds.hide()

                        if (!isAdsLoaded) {
                            binding.btnNext.hide()
                            binding.btnStart.hide()
                            binding.loadingAds.show()
                        } else {
                            binding.btnNext.show()
                            binding.btnStart.hide()
                            binding.loadingAds.hide()
                        }
                    }

                    2 -> {
                        if (!isAdsLoaded) {
                            binding.btnNext.hide()
                            binding.btnStart.hide()
                            binding.loadingAds.show()
                        } else {
                            binding.btnStart.show()
                            binding.btnNext.hide()
                            binding.loadingAds.hide()
                            if (isAdsLoadSuccess) {
                                binding.containerAds.show()
                            } else {
                                binding.containerAds.hide()
                            }
                        }
                    }
                }
            }
        })
    }

    private fun loadAds() {
//        AdsCore.showNativeAds(this, binding.nativeAdmob, binding.nativeMax, {
//            isAdsLoadSuccess = true
//            handleWhenLoadAdsDone()
//        }, { handleWhenLoadAdsDone() }, NativeTypeEnum.INTRO)


    }

    private fun handleWhenLoadAdsDone() {
        isAdsLoaded = true
        when (binding.vpOnboard.currentItem) {
            0, 1 -> {
                binding.containerAds.hide()

                if (!isAdsLoaded) {
                    binding.btnNext.hide()
                    binding.btnStart.hide()
                    binding.loadingAds.show()
                } else {
                    binding.btnNext.show()
                    binding.btnStart.hide()
                    binding.loadingAds.hide()
                }
            }

            2 -> {
                if (!isAdsLoaded) {
                    binding.btnNext.hide()
                    binding.btnStart.hide()
                    binding.loadingAds.show()
                } else {
                    binding.btnStart.show()
                    binding.btnNext.hide()
                    binding.loadingAds.hide()
                    if (isAdsLoadSuccess) {
                        binding.containerAds.show()
                    } else {
                        binding.containerAds.hide()
                    }
                }
            }
        }
    }


}