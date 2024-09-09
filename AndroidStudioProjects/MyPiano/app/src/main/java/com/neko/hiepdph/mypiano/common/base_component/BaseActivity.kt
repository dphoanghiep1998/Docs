package com.neko.hiepdph.mypiano.common.base_component

//import com.example.baseproject.BuildConfig
//import com.example.baseproject.common.InterAdsEnum
//import com.example.baseproject.common.isInternetAvailable
//import com.example.baseproject.view.dialog.DialogFragmentLoadingInterAds
//import com.gianghv.admob.InterstitialSingleReqAdManager
//import com.gianghv.libads.max.MaxInterstitialSingleReqAdManager
//import com.example.baseproject.common.ads.utils.AdsConfigUtils
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.media.AudioManager
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.common.createContext
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import javax.inject.Inject
abstract class BaseActivity<VB : ViewBinding>() : AppCompatActivity() {
    lateinit var binding: VB
    private var receiver: BroadcastReceiver? = null
    private var audioManager: AudioManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        if(true){
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        hideNavigationBar()
        initView()
//        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
//        receiver = object : BroadcastReceiver() {
//            override fun onReceive(p0: Context?, mItent: Intent?) {
//                config.isVolumeUserChanged = true
//            }
//        }
//        val intentFilter = IntentFilter()
//        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION")
//        registerReceiver(receiver, intentFilter)
    }

//    protected fun showInterAds(
//        action: () -> Unit, actionFailed: () -> Unit, type: InterAdsEnum, mustWait: Boolean = true
//    ) {
//        if (!MainApplication.app.checkCanShowAds() && mustWait) {
//            actionFailed.invoke()
//            return
//        }
//        val statusAds = when (type) {
//            InterAdsEnum.FUNCTION -> AdsConfigUtils(this).getInterFunction()
//            InterAdsEnum.INTRO -> AdsConfigUtils(this).getInterIntro()
//            InterAdsEnum.SOUND_BACK -> AdsConfigUtils(this).getInterSoundBack()
//            InterAdsEnum.LANG -> AdsConfigUtils(this).getInterLang()
//            InterAdsEnum.RESCAN -> AdsConfigUtils(this).getInterRescan()
//            InterAdsEnum.TYPE -> AdsConfigUtils(this).getInterTypeScan()
//            InterAdsEnum.VIDEO -> AdsConfigUtils(this).getInterVideo()
//            InterAdsEnum.SHARE -> AdsConfigUtils(this).getInterShare()
//        }
//        when (statusAds) {
//            AdsConfigUtils.OFF -> {
//                actionFailed.invoke()
//            }
//
//            AdsConfigUtils.ADMOB -> {
//                showAdmobInterAds(action, actionFailed, type)
//            }
//
//            AdsConfigUtils.MAX -> {
//                showInterMax(action, actionFailed)
//            }
//        }
//    }
//
//
//    private fun showAdmobInterAds(
//        action: () -> Unit, actionFailed: () -> Unit, type: InterAdsEnum
//    ) {
//        launchWhenResumed {
//            if (!isInternetAvailable(this@BaseActivity)) {
//                actionFailed.invoke()
//                return@launchWhenResumed
//            }
//
//            val interstitialSingleReqAdManager: InterstitialSingleReqAdManager = when (type) {
//
//                InterAdsEnum.FUNCTION -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_home_id,
//                    )
//                }
//
//                InterAdsEnum.SOUND_BACK -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_sound_back_id,
//                    )
//                }
//                InterAdsEnum.SHARE -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_photo_id,
//                    )
//                }
//                InterAdsEnum.RESCAN -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_rescan_id,
//                    )
//                }
//                InterAdsEnum.TYPE -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_type_scan_id,
//                    )
//                }
//                InterAdsEnum.LANG -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_language_id,
//                    )
//                }
//                InterAdsEnum.INTRO -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_intro_id,
//                    )
//                }
//                InterAdsEnum.VIDEO -> {
//                    InterstitialSingleReqAdManager(
//                        this@BaseActivity,
//                        BuildConfig.inter_n_video_id,
//                    )
//                }
//
//
//            }
//            InterstitialSingleReqAdManager.isShowingAds = true
//            val dialogLoadingInterAds =
//                DialogFragmentLoadingInterAds().onCreateDialog(this@BaseActivity)
//            dialogLoadingInterAds.show()
//            interstitialSingleReqAdManager.requestAds(onLoadAdSuccess = {
//                dialogLoadingInterAds.dismiss()
//                launchWhenResumed {
//                    interstitialSingleReqAdManager.show(this@BaseActivity, onShowAdsFinish = {
//                        MainApplication.app.mLastShowAds = System.currentTimeMillis()
//                        InterstitialSingleReqAdManager.isShowingAds = false
//                        action()
//                    })
//                }
//            }, onAdLoadFail = {
//                InterstitialSingleReqAdManager.isShowingAds = false
//                actionFailed()
//                dialogLoadingInterAds.dismiss()
//            })
//        }
//    }
//
//    private fun showInterMax(action: () -> Unit, actionFailed: () -> Unit) {
//        val maxInterstitialSingleReqAdManager = MaxInterstitialSingleReqAdManager(
//            this, BuildConfig.max_inter
//        )
//        InterstitialSingleReqAdManager.isShowingAds = true
//        val dialogLoadingInterAds = DialogFragmentLoadingInterAds().onCreateDialog(this)
//        dialogLoadingInterAds.show()
//        maxInterstitialSingleReqAdManager.requestAds(onLoadAdSuccess = {
//            dialogLoadingInterAds.dismiss()
//
//            launchWhenResumed {
//                maxInterstitialSingleReqAdManager.show(this@BaseActivity, onShowAdsFinish = {
//                    MainApplication.app.mLastShowAds = System.currentTimeMillis()
//                    MaxInterstitialSingleReqAdManager.isShowingAds = false
//                    action()
//                })
//            }
//        }, onAdLoadFail = {
//            MaxInterstitialSingleReqAdManager.isShowingAds = false
//            actionFailed()
//            dialogLoadingInterAds.dismiss()
//        })
//
//    }


    protected fun changeBackPressCallBack(action: () -> Unit) {
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                action.invoke()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration?) {
        if (overrideConfiguration != null) {
            val uiMode = overrideConfiguration.uiMode
            overrideConfiguration.setTo(baseContext.resources.configuration)
            overrideConfiguration.uiMode = uiMode
        }
        super.applyOverrideConfiguration(overrideConfiguration)
    }

    override fun attachBaseContext(newBase: Context) = super.attachBaseContext(
        newBase.createContext(
            Locale(config.savedLanguage)
        )
    )

    private fun hideNavigationBar() {
        val decorView: View = window.decorView

        val uiOptions: Int =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        decorView.systemUiVisibility = uiOptions
    }

    abstract fun getViewBinding(): VB

    abstract fun initView()
    override fun onDestroy() {
        super.onDestroy()
        receiver?.let {
            unregisterReceiver(it)
        }
    }

}