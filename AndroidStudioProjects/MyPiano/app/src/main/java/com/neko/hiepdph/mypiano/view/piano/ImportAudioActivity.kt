package com.neko.hiepdph.mypiano.view.piano

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.FileUtils
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.ActivityImportAudioBinding
import com.neko.hiepdph.mypiano.view.piano.adapter.ImportAudioAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImportAudioActivity : BaseActivity<ActivityImportAudioBinding>() {
    private var adapter: ImportAudioAdapter? = null
    override fun getViewBinding(): ActivityImportAudioBinding {
        return ActivityImportAudioBinding.inflate(layoutInflater)
    }

    override fun initView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = ImportAudioAdapter {
            val intent = Intent(this, PianoActivity::class.java)
            intent.putExtra(Constant.KEY_PLAY_AUDIO, true)
            intent.putExtra(Constant.KEY_AUDIO_FILE, it)
            intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT)
            startActivity(intent)
            finish()
        }

        binding.btnBack.clickWithDebounce {
            finish()
        }
        binding.rcvAudio.adapter = adapter
        getData()
    }

    private fun getData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val listFile = FileUtils.getFileAudio(this@ImportAudioActivity)
            launch(Dispatchers.Main) {
                adapter?.setData(listFile)
            }
        }
    }

}