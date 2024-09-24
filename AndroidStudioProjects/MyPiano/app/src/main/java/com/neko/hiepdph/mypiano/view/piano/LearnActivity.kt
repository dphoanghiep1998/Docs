package com.neko.hiepdph.mypiano.view.piano

import android.content.res.ColorStateList
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.ActivityLearnBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LearnActivity : BaseActivity<ActivityLearnBinding>() {
    private var navHostFragment: NavHostFragment? = null
    private var navController: NavController? = null

    override fun getViewBinding(): ActivityLearnBinding {
        return ActivityLearnBinding.inflate(layoutInflater)
    }

    override fun initView() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentView) as NavHostFragment
        navController = navHostFragment?.navController
        firstInit()
        initButton()
        if (intent.getBooleanExtra(Constant.MIC, false)) {
            setupViewContainer(2)
            navController?.navigateUp()
            navController?.navigate(R.id.micRecordFragment)
        }
        if (intent.getBooleanExtra(Constant.KEY, false)) {
            setupViewContainer(1)
            navController?.navigateUp()
            navController?.navigate(R.id.keyRecordFragment)
        }
        intent.removeExtra(Constant.MIC)
        intent.removeExtra(Constant.KEY)
    }

    private fun initButton() {

        binding.btnBack.clickWithDebounce {
            finish()
        }

        binding.containerLesson.clickWithDebounce {
            if (navController?.currentDestination?.id != R.id.lessonFragment) {
                setupViewContainer(0)
                navController?.navigateUp()
                navController?.navigate(R.id.lessonFragment)
            }

        }

        binding.containerKeyRecord.clickWithDebounce {
            if (navController?.currentDestination?.id != R.id.keyRecordFragment) {
                setupViewContainer(1)
                navController?.navigateUp()
                navController?.navigate(R.id.keyRecordFragment)
            }

        }

        binding.containerMicRecord.clickWithDebounce {
            if (navController?.currentDestination?.id != R.id.micRecordFragment) {
                setupViewContainer(2)
                navController?.navigateUp()
                navController?.navigate(R.id.micRecordFragment)
            }

        }
    }

    private fun setupViewContainer(index: Int) {
        val listView = mutableListOf(
            Triple(binding.containerLesson, binding.tvLesson, binding.imageLesson),
            Triple(binding.containerKeyRecord, binding.tvKeyRecord, binding.imageKeyRecord),
            Triple(binding.containerMicRecord, binding.tvMicRecord, binding.imageMicRecord),
        )
        for (i in 0..2) {
            if (i == index) {
                listView[i].first.setBackgroundColor(getColor(R.color.secondary_01))
                listView[i].second.setTextColor(getColor(R.color.white))
                listView[i].third.imageTintList = ColorStateList.valueOf(getColor(R.color.white))
            } else {
                listView[i].first.setBackgroundColor(getColor(R.color.n3))
                listView[i].second.setTextColor(getColor(R.color.n4))
                listView[i].third.imageTintList = ColorStateList.valueOf(getColor(R.color.n4))
            }
        }
    }

    private fun firstInit() {
        binding.containerLesson.setBackgroundColor(getColor(R.color.secondary_01))
        binding.containerKeyRecord.setBackgroundColor(getColor(R.color.n3))
        binding.containerMicRecord.setBackgroundColor(getColor(R.color.n3))

        binding.imageLesson.imageTintList = ColorStateList.valueOf(getColor(R.color.white))
        binding.imageKeyRecord.imageTintList = ColorStateList.valueOf(getColor(R.color.n4))
        binding.imageMicRecord.imageTintList = ColorStateList.valueOf(getColor(R.color.n4))

        binding.tvLesson.setTextColor(getColor(R.color.white))
        binding.tvKeyRecord.setTextColor(getColor(R.color.n4))
        binding.tvMicRecord.setTextColor(getColor(R.color.n4))
    }


}