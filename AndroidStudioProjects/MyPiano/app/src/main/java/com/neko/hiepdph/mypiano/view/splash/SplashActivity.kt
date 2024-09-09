package com.neko.hiepdph.mypiano.view.splash

import android.content.Intent
import android.os.Handler
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.databinding.ActivitySplashBinding
import com.neko.hiepdph.mypiano.view.getstarted.GetStartedActivity
import com.neko.hiepdph.mypiano.view.language.LanguageActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initView() {
        Handler().postDelayed({
            startActivity(Intent(this, GetStartedActivity::class.java))
            finish()
        }, 2000)
    }

}