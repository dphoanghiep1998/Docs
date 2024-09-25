package com.neko.hiepdph.mypiano.view.saxophone

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.media.AudioAttributes
import android.media.SoundPool
import android.view.View
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.databinding.ActivitySaxophoneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaxophoneActivity : BaseActivity<ActivitySaxophoneBinding>() {
    private var soundPool: SoundPool? = null

    private var sound1: Int? = null
    private var sound2: Int? = null
    private var sound3: Int? = null
    private var sound4: Int? = null
    private var sound5: Int? = null
    private var sound6: Int? = null
    private var sound7: Int? = null
    private var sound8: Int? = null
    private var sound9: Int? = null
    private var sound10: Int? = null
    private var sound11: Int? = null

    override fun getViewBinding(): ActivitySaxophoneBinding {
        return ActivitySaxophoneBinding.inflate(layoutInflater)
    }

    private fun initSoundPool() {
        val audioAttributes: AudioAttributes =
            AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()

        soundPool =
            SoundPool.Builder().setMaxStreams(10).setAudioAttributes(audioAttributes).build()

        sound1 = soundPool?.load(this, R.raw.sound_1, 0)
        sound2 = soundPool?.load(this, R.raw.sound_2, 0)
        sound3 = soundPool?.load(this, R.raw.sound_3, 0)
        sound4 = soundPool?.load(this, R.raw.sound_4, 0)
        sound5 = soundPool?.load(this, R.raw.sound_6, 0)
        sound6 = soundPool?.load(this, R.raw.sound_7, 0)
        sound7 = soundPool?.load(this, R.raw.sound_8, 0)
        sound8 = soundPool?.load(this, R.raw.sound_9, 0)
        sound9 = soundPool?.load(this, R.raw.sound_10, 0)
        sound10 = soundPool?.load(this, R.raw.sound_11, 0)
        sound11 = soundPool?.load(this, R.raw.sound_12, 0)
    }

    override fun initView() {
        changeBackPressCallBack {
            if (!config.isUserRated) {
                setResult(3001)
            }
            finish()
        }
        initSoundPool()


        initButton()
    }

    private fun initButton() {
        binding.btnHome.clickWithDebounce {
            if (!config.isUserRated) {
                setResult(3001)
            }
            finish()
        }

        binding.note1.clickWithDebounce {
            startStringAnimation(binding.note1)
            soundPool?.play(sound1!!, 1f, 1f, 1, 0, 1f)
        }
        binding.note2.clickWithDebounce {
            startStringAnimation(binding.note2)
            soundPool?.play(sound2!!, 1f, 1f, 1, 0, 1f)
        }
        binding.note3.clickWithDebounce {
            startStringAnimation(binding.note3)
            soundPool?.play(sound3!!, 1f, 1f, 1, 0, 1f)
        }
        binding.note4.clickWithDebounce {
            startStringAnimation(binding.note4)
            soundPool?.play(sound4!!, 1f, 1f, 1, 0, 1f)
        }
        binding.note5.clickWithDebounce {
            startStringAnimation(binding.note5)
            soundPool?.play(sound5!!,1f,1f,1,0,1f)
        }
        binding.note6.clickWithDebounce {
            startStringAnimation(binding.note6)
            soundPool?.play(sound6!!,1f,1f,1,0,1f)
        }
        binding.note7.clickWithDebounce {
            startStringAnimation(binding.note7)
            soundPool?.play(sound7!!,1f,1f,1,0,1f)
        }
        binding.note8.clickWithDebounce {
            startStringAnimation(binding.note8)
            soundPool?.play(sound8!!,1f,1f,1,0,1f)
        }
        binding.note9.clickWithDebounce {
            startStringAnimation(binding.note9)
            soundPool?.play(sound9!!,1f,1f,1,0,1f)
        }
        binding.note10.clickWithDebounce {
            startStringAnimation(binding.note10)
            soundPool?.play(sound10!!,1f,1f,1,0,1f)
        }
        binding.note11.clickWithDebounce {
            startStringAnimation(binding.note11)
            soundPool?.play(sound11!!,1f,1f,1,0,1f)
        }
    }
    private fun startStringAnimation(view: View) {
        val upAnimator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.1f)
        upAnimator.duration = 100
        val downAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.1f)
        downAnimator.duration = 100
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(upAnimator, downAnimator)

        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
            }

            override fun onAnimationEnd(p0: Animator) {
                view.scaleX = 1f;
                view.scaleY = 1f;
            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationRepeat(p0: Animator) {
            }

        })
        animatorSet.start()
    }


}