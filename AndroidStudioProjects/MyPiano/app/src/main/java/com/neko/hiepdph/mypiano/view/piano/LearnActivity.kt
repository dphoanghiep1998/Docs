package com.neko.hiepdph.mypiano.view.piano

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.ActivityLearnBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LearnActivity : BaseActivity<ActivityLearnBinding>() {
    override fun getViewBinding(): ActivityLearnBinding {
        return ActivityLearnBinding.inflate(layoutInflater)
    }

    override fun initView() {

        firstInit()
        initButton()
    }

    private fun initButton() {
        binding.btnBack.clickWithDebounce {
            startActivity(Intent(this,PianoActivity::class.java))
        }

        binding.containerLesson.clickWithDebounce {
            if (findNavController(binding.fragmentView.id).currentDestination?.id != R.id.lessonFragment) {
                setupViewContainer(0)
                findNavController(binding.fragmentView.id).navigateUp()
                findNavController(binding.fragmentView.id).navigate(R.id.lessonFragment)
            }

        }

        binding.containerKeyRecord.clickWithDebounce {
            if (findNavController(binding.fragmentView.id).currentDestination?.id != R.id.keyRecordFragment) {
                setupViewContainer(1)
                findNavController(binding.fragmentView.id).navigateUp()
                findNavController(binding.fragmentView.id).navigate(R.id.keyRecordFragment)
            }

        }

        binding.containerMicRecord.clickWithDebounce {
            if (findNavController(binding.fragmentView.id).currentDestination?.id != R.id.micRecordFragment) {
                setupViewContainer(2)
                findNavController(binding.fragmentView.id).navigateUp()
                findNavController(binding.fragmentView.id).navigate(R.id.micRecordFragment)
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