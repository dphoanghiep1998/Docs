package com.neko.hiepdph.mypiano.view.success

import android.content.Intent
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.ActivitySaveSuccessBinding
import com.neko.hiepdph.mypiano.view.piano.LearnActivity
import com.neko.hiepdph.mypiano.view.piano.PianoActivity

class SaveSuccessActivity : BaseActivity<ActivitySaveSuccessBinding>() {
    override fun getViewBinding(): ActivitySaveSuccessBinding {
        return ActivitySaveSuccessBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.btnClose.clickWithDebounce {
            finish()
        }

        binding.tvRecordList.clickWithDebounce {
            startActivity(Intent(this, LearnActivity::class.java))
        }

        binding.tvSuccess.clickWithDebounce {
            startActivity(Intent(this, PianoActivity::class.java).apply {
                putExtra(Constant.KEY_RECORD_AGAIN, true)
            })
            finish()
        }
    }

}