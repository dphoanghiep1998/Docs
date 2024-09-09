package com.neko.hiepdph.mypiano.view.getstarted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.ActivityGetstartedBinding
import com.neko.hiepdph.mypiano.view.main.MainActivity
import com.neko.hiepdph.mypiano.view.piano.PianoActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartedActivity : BaseActivity<ActivityGetstartedBinding>() {
    override fun getViewBinding(): ActivityGetstartedBinding {
        return ActivityGetstartedBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.home.clickWithDebounce {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.playPiano.clickWithDebounce {
            startActivity(Intent(this,PianoActivity::class.java))
            finish()
        }
    }

}