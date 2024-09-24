package com.neko.hiepdph.mypiano.view.piano

import android.widget.SeekBar
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.databinding.ActivityDoubleKeyPianoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoubleKeyPianoActivity: BaseActivity<ActivityDoubleKeyPianoBinding>() {
    private var scrollProgress = 0
    private var scrollProgress1 = 0

    override fun getViewBinding(): ActivityDoubleKeyPianoBinding {
        return ActivityDoubleKeyPianoBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.pianoView.setIndexTheme(config.indexTheme)
        binding.pianoView1.setIndexTheme(config.indexTheme)

        binding.pianoView.setIndexTheme(config.indexTheme)
        binding.btnBackScroll.clickWithDebounce {
            val progress = binding.sb.progress
            if (progress - 10 <= 0) {
                binding.sb.progress = 0
            } else {
                binding.sb.progress = progress - 10
            }
        }

        binding.btnUpScroll.clickWithDebounce {
            val progress = binding.sb.progress
            if (progress + 10 > 100) {
                binding.sb.progress = 100
            } else {
                binding.sb.progress = progress + 10
            }
        }
        binding.btnBackward.clickWithDebounce {
            var progress = 0
            if (scrollProgress == 0) {
                progress = 0
            } else {
                progress = binding.sb.progress - scrollProgress;
                if (progress < 0) {
                    progress = 0;
                }
            }
            binding.sb.progress = progress
        }

        binding.btnForward.clickWithDebounce {
            var progress = 0

            if (scrollProgress == 0) {
                progress = 100
            } else {
                progress = binding.sb.progress + scrollProgress;
                if (progress > 100) {
                    progress = 100;
                }
            }
            binding.sb.progress = progress
        }

        binding.btnBackScroll1.clickWithDebounce {
            val progress = binding.sb1.progress
            if (progress - 10 <= 0) {
                binding.sb1.progress = 0
            } else {
                binding.sb1.progress = progress - 10
            }
        }

        binding.btnUpScroll1.clickWithDebounce {
            val progress = binding.sb1.progress
            if (progress + 10 > 100) {
                binding.sb1.progress = 100
            } else {
                binding.sb1.progress = progress + 10
            }
        }
        binding.btnBackward1.clickWithDebounce {
            var progress = 0
            if (scrollProgress1 == 0) {
                progress = 0
            } else {
                progress = binding.sb1.progress - scrollProgress1;
                if (progress < 0) {
                    progress = 0;
                }
            }
            binding.sb1.progress = progress
        }

        binding.btnForward1.clickWithDebounce {
            var progress = 0

            if (scrollProgress1 == 0) {
                progress = 100
            } else {
                progress = binding.sb1.progress + scrollProgress1;
                if (progress > 100) {
                    progress = 100;
                }
            }
            binding.sb1.progress = progress
        }

        binding.sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.pianoView.scroll(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })
        binding.sb1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.pianoView1.scroll(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })

        binding.pianoView.setSizeKey()
        binding.pianoView1.setSizeKey()
    }
}