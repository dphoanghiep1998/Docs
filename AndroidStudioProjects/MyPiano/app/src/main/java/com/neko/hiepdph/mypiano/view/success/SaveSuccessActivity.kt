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
        val isKeyRecord = intent.getBooleanExtra(Constant.IS_KEY_RECORD,false)
        val isMicRecord = intent.getBooleanExtra(Constant.IS_MIC_RECORD,false)
        binding.btnClose.clickWithDebounce {
            finish()
        }

        binding.tvRecordList.clickWithDebounce {
            if(isKeyRecord){
                startActivity(Intent(this, LearnActivity::class.java).apply {
                    putExtra(Constant.KEY,true)
                })
            }
            if(isMicRecord){
                startActivity(Intent(this, LearnActivity::class.java).apply {
                    putExtra(Constant.MIC,true)
                })
            }
        }

        binding.btnNewRecord.clickWithDebounce {
//            startActivity(Intent(this, PianoActivity::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//                putExtra(Constant.KEY_RECORD_AGAIN, true)
//            })
            setResult(3000)
            finish()
        }
    }

}