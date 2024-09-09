package com.neko.hiepdph.mypiano.common.base_component

//import com.example.baseproject.BuildConfig
//import com.example.baseproject.common.InterAdsEnum
//import com.example.baseproject.common.isInternetAvailable
//import com.example.baseproject.view.home.MainActivity
//import com.example.baseproject.view.dialog.DialogFragmentLoadingInterAds
//import com.gianghv.admob.InterstitialSingleReqAdManager
//import com.gianghv.libads.max.MaxInterstitialSingleReqAdManager
//import com.example.baseproject.common.ads.utils.AdsConfigUtils
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.withStarted
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.neko.hiepdph.mypiano.common.AppSharePreference
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container)
        return binding.root
    }

    protected fun changeBackPressCallBack(action: () -> Unit) {
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                action.invoke()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        callbackSharePreference()?.let { callback ->
            AppSharePreference.INSTANCE.registerOnSharedPreferenceChangeListener(callback)
        }
    }

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun initView()

    open fun callbackSharePreference(): SharedPreferences.OnSharedPreferenceChangeListener? {
        return null
    }


//    protected fun navigateUsingActivityController(resId: Int,bundle: Bundle?= null) {
//        try {
//            lifecycleScope.launch {
//                withStarted {
//                    if (activity is MainActivity) {
//                        (activity as MainActivity).getNavController()?.navigate(resId,bundle)
//                    }
//                }
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }


    protected fun navigateToFragment(fragmentId: Int, actionId: Int, bundle: Bundle? = null) {
        if (fragmentId == findNavController().currentDestination?.id) {
            lifecycleScope.launch {
                withStarted {
                    findNavController().navigate(actionId, bundle)
                }
            }
        }
    }

    protected fun navigateToFragment(id: Int, action: NavDirections) {
        if (findNavController().currentDestination?.id == id) {
            lifecycleScope.launch {
                withStarted {
                    findNavController().navigate(action)
                }
            }
        }
    }

    protected fun navigateBack(id: Int) {
        if (findNavController().currentDestination?.id == id) {
            lifecycleScope.launch {
                withStarted {
                    findNavController().popBackStack()
                }
            }
        }
    }

//    protected fun navigateBackUsingActivityController() {
//        lifecycleScope.launch {
//            withStarted {
//                if (activity is MainActivity) {
//                    (activity as MainActivity).getNavController()?.popBackStack()
//                }
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        callbackSharePreference()?.let { AppSharePreference.INSTANCE.unregisterListener(it) }
    }

//    protected fun showInterAds(
//        action: () -> Unit, actionFailed: () -> Unit, type: InterAdsEnum, mustWait: Boolean = true
//    ) {
//        if (!MainApplication.app.checkCanShowAds() && mustWait) {
//            actionFailed.invoke()
//            return
//        }
//        val statusAds = when (type) {
//            InterAdsEnum.FUNCTION -> AdsConfigUtils(requireContext()).getInterFunction()
//            InterAdsEnum.INTRO -> AdsConfigUtils(requireContext()).getInterIntro()
//            InterAdsEnum.SOUND_BACK -> AdsConfigUtils(requireContext()).getInterSoundBack()
//            InterAdsEnum.LANG -> AdsConfigUtils(requireContext()).getInterLang()
//            InterAdsEnum.RESCAN -> AdsConfigUtils(requireContext()).getInterRescan()
//            InterAdsEnum.TYPE -> AdsConfigUtils(requireContext()).getInterTypeScan()
//            InterAdsEnum.VIDEO -> AdsConfigUtils(requireContext()).getInterVideo()
//            InterAdsEnum.SHARE -> AdsConfigUtils(requireContext()).getInterShare()
//
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
//            if (!isInternetAvailable(requireActivity())) {
//                actionFailed.invoke()
//                return@launchWhenResumed
//            }
//
//            val interstitialSingleReqAdManager: InterstitialSingleReqAdManager = when (type) {
//                InterAdsEnum.FUNCTION -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_home_id,
//                    )
//                }
//
//                InterAdsEnum.SOUND_BACK -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_sound_back_id,
//                    )
//                }
//                InterAdsEnum.SHARE -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_photo_id,
//                    )
//                }
//                InterAdsEnum.RESCAN -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_rescan_id,
//                    )
//                }
//                InterAdsEnum.TYPE -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_type_scan_id,
//                    )
//                }
//                InterAdsEnum.LANG -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_language_id,
//                    )
//                }
//                InterAdsEnum.INTRO -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_intro_id,
//                    )
//                }
//                InterAdsEnum.VIDEO -> {
//                    InterstitialSingleReqAdManager(
//                        requireContext(),
//                        BuildConfig.inter_n_video_id,
//                    )
//                }
//
//            }
//
//            InterstitialSingleReqAdManager.isShowingAds = true
//            val dialogLoadingInterAds =
//                DialogFragmentLoadingInterAds().onCreateDialog(requireActivity())
//            dialogLoadingInterAds.show()
//            interstitialSingleReqAdManager.requestAds(onLoadAdSuccess = {
//                dialogLoadingInterAds.dismiss()
//                launchWhenResumed {
//                    interstitialSingleReqAdManager.show(requireActivity(), onShowAdsFinish = {
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
//            requireActivity(), BuildConfig.max_inter
//        )
//        InterstitialSingleReqAdManager.isShowingAds = true
//
//        val dialogLoadingInterAds = DialogFragmentLoadingInterAds().onCreateDialog(requireContext())
//        dialogLoadingInterAds.show()
//        maxInterstitialSingleReqAdManager.requestAds(onLoadAdSuccess = {
//            dialogLoadingInterAds.dismiss()
//            launchWhenResumed {
//                maxInterstitialSingleReqAdManager.show(requireActivity(), onShowAdsFinish = {
//
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


}