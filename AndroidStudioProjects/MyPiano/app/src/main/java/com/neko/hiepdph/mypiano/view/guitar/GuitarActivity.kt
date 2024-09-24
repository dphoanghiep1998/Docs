package com.neko.hiepdph.mypiano.view.guitar

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.databinding.ActivityGuitarBinding


class GuitarActivity : BaseActivity<ActivityGuitarBinding>() {
    private var soundF1: Int? = null
    private var soundG1: Int? = null
    private var soundE11: Int? = null
    private var soundA12: Int? = null
    private var soundF2: Int? = null
    private var soundE2: Int? = null
    private var soundC2: Int? = null
    private var soundA3: Int? = null
    private var soundF3: Int? = null
    private var soundBm3: Int? = null
    private var soundD23: Int? = null
    private var soundEM3: Int? = null
    private var soundA4: Int? = null
    private var soundG24: Int? = null
    private var soundBm4: Int? = null
    private var soundE4: Int? = null
    private var soundDm4: Int? = null
    private var soundF4: Int? = null
    private var soundA5: Int? = null
    private var soundB5: Int? = null
    private var soundB25: Int? = null
    private var soundDm5: Int? = null
    private var soundF5: Int? = null
    private var soundE36: Int? = null
    private var soundBm6: Int? = null
    private var soundDm6: Int? = null
    private var soundF6: Int? = null
    private var soundG6: Int? = null
    private var flag: Int = -1
    private val isAnimating = BooleanArray(6)
    private lateinit var listViewLine: MutableList<View>
    private var currentViewID: Int = 0

    private var soundPool: SoundPool? = null
    override fun getViewBinding(): ActivityGuitarBinding {
        return ActivityGuitarBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val listGuitarStyle = mutableListOf(
            R.drawable.ic_bg_guitar_1,
            R.drawable.ic_bg_guitar_2,
            R.drawable.ic_bg_guitar_3,
            R.drawable.ic_bg_guitar_4,
            R.drawable.ic_bg_guitar_5,
        )
        binding.background.setImageResource(listGuitarStyle[config.indexThemeGuitar])
        listViewLine = mutableListOf()
        listViewLine.add(binding.string1)
        listViewLine.add(binding.string2)
        listViewLine.add(binding.string3)
        listViewLine.add(binding.string4)
        listViewLine.add(binding.string5)
        listViewLine.add(binding.string6)
        initSoundPool()
        initNote()
        initButton()
    }

    private fun initButton() {

        changeBackPressCallBack {
            if (!config.isUserRated) {
                setResult(3001)
            }
            finish()
        }
        binding.btnHome.clickWithDebounce {
            if (!config.isUserRated) {
                setResult(3001)
            }
            finish()
        }

        binding.btnStyle.clickWithDebounce {
            startActivity(Intent(this, StyleGuitarActivity::class.java))
            finish()
        }
        val listItem = mutableListOf(
            binding.btnAm,
            binding.btnBm,
            binding.btnC,
            binding.btnE,
            binding.btnEm,
            binding.btnDm,
            binding.btnF,
            binding.btnG
        )

        val listNote = mutableListOf(
            AM, BM, C, E, EM, DM, F, G
        )
        listItem.forEachIndexed { index, item ->
            item.clickWithDebounce {
                if (flag == index) {
                    item.setBackgroundResource(R.drawable.ic_bg_guitar_note)
                    flag = -1
                    return@clickWithDebounce
                }
                item.setBackgroundResource(R.drawable.ic_bg_guitar_note_active)
                flag = listNote[index]
                listItem.filter { item != it }.forEach {
                    it.setBackgroundResource(R.drawable.ic_bg_guitar_note)
                }
            }
        }
    }

    private fun initSoundPool() {
        val audioAttributes: AudioAttributes =
            AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()

        soundPool =
            SoundPool.Builder().setMaxStreams(10).setAudioAttributes(audioAttributes).build()
    }

    private fun initNote() {
        soundF1 = soundPool?.load(this, R.raw.f_1, 0)
        soundG1 = soundPool?.load(this, R.raw.g_1, 0)
        soundE11 = soundPool?.load(this, R.raw.e1_1, 0)

        soundA12 = soundPool?.load(this, R.raw.a1_2, 0)
        soundF2 = soundPool?.load(this, R.raw.f_2, 0)
        soundE2 = soundPool?.load(this, R.raw.e_2, 0)
        soundC2 = soundPool?.load(this, R.raw.c_2, 0)

        soundA3 = soundPool?.load(this, R.raw.am_3, 0)
        soundF3 = soundPool?.load(this, R.raw.f_3, 0)
        soundBm3 = soundPool?.load(this, R.raw.bm_3, 0)
        soundD23 = soundPool?.load(this, R.raw.d2_3, 0)
        soundEM3 = soundPool?.load(this, R.raw.em_3, 0)

        soundA4 = soundPool?.load(this, R.raw.am_4, 0)
        soundBm4 = soundPool?.load(this, R.raw.bm_4, 0)
        soundG24 = soundPool?.load(this, R.raw.g2_4, 0)
        soundE4 = soundPool?.load(this, R.raw.e_4, 0)
        soundDm4 = soundPool?.load(this, R.raw.dm_4, 0)
        soundF4 = soundPool?.load(this, R.raw.f_4, 0)

        soundA5 = soundPool?.load(this, R.raw.am_5, 0)
        soundB5 = soundPool?.load(this, R.raw.bm_5, 0)
        soundB25 = soundPool?.load(this, R.raw.b2_5, 0)
        soundDm5 = soundPool?.load(this, R.raw.dm_5, 0)
        soundF5 = soundPool?.load(this, R.raw.f_5, 0)

        soundE36 = soundPool?.load(this, R.raw.e3_6, 0)
        soundBm6 = soundPool?.load(this, R.raw.bm_6, 0)
        soundDm6 = soundPool?.load(this, R.raw.dm_6, 0)
        soundF6 = soundPool?.load(this, R.raw.f_6, 0)
        soundG6 = soundPool?.load(this, R.raw.g_6, 0)

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val x = ev!!.x
        val y = ev.y
        listViewLine.forEachIndexed { index, view ->
            if (isViewUnder(view, x, y)) {
                if (ev.action == MotionEvent.ACTION_DOWN) {
                    currentViewID = view.id
                    startStringAnimation(index, view)
                    when (index) {
                        0 -> {
                            when (flag) {
                                AM -> {
                                }

                                B -> {
                                }

                                C -> {
                                }

                                DM -> {
                                }

                                F -> {
                                    soundPool?.play(soundF1!!, 1f, 1f, 0, 0, 1f)
                                }

                                G -> {
                                    soundPool?.play(soundG1!!, 1f, 1f, 0, 0, 1f)
                                }

                                else -> {
                                    soundPool?.play(soundE11!!, 1f, 1f, 0, 0, 1f)
                                }
                            }
                            true
                        }

                        1 -> {
                            when (flag) {
                                AM -> {
                                    soundPool?.play(soundA12!!, 1f, 1f, 0, 0, 1f)
                                }

                                C -> {
                                    soundPool?.play(soundF2!!, 1f, 1f, 0, 0, 1f)
                                }

                                B -> {
                                    soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                }

                                E -> {
                                    soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                }

                                DM -> {
                                }

                                F -> {
                                    soundPool?.play(soundC2!!, 1f, 1f, 0, 0, 1f)
                                }

                                EM -> {
                                    soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                }

                                G -> {
                                    soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                }

                                else -> {
                                    soundPool?.play(soundA12!!, 1f, 1f, 0, 0, 1f)
                                }
                            }
                            true

                        }

                        2 -> {
                            when (flag) {
                                AM -> {
                                    soundPool?.play(soundA3!!, 1f, 1f, 0, 0, 1f)
                                }

                                C -> {
                                    soundPool?.play(soundF3!!, 1f, 1f, 0, 0, 1f)
                                }

                                B -> {
                                    soundPool?.play(soundBm3!!, 1f, 1f, 0, 0, 1f)
                                }

                                E -> {
                                    soundPool?.play(soundF3!!, 1f, 1f, 0, 0, 1f)
                                }

                                DM -> {
                                    soundPool?.play(soundD23!!, 1f, 1f, 0, 0, 1f)
                                }

                                F -> {
                                    soundPool?.play(soundF3!!, 1f, 1f, 0, 0, 1f)
                                }

                                EM -> {
                                    soundPool?.play(soundEM3!!, 1f, 1f, 0, 0, 1f)
                                }

                                G -> {
                                    soundPool?.play(soundD23!!, 1f, 1f, 0, 0, 1f)
                                }

                                else -> {
                                    soundPool?.play(soundD23!!, 1f, 1f, 0, 0, 1f)
                                }
                            }
                            true
                        }

                        3 -> {
                            when (flag) {
                                AM -> {
                                    soundPool?.play(soundA4!!, 1f, 1f, 0, 0, 1f)
                                }

                                C -> {
                                    soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                }

                                B -> {
                                    soundPool?.play(soundBm4!!, 1f, 1f, 0, 0, 1f)
                                }

                                E -> {
                                    soundPool?.play(soundE4!!, 1f, 1f, 0, 0, 1f)
                                }

                                DM -> {
                                    soundPool?.play(soundDm4!!, 1f, 1f, 0, 0, 1f)
                                }

                                F -> {
                                    soundPool?.play(soundF4!!, 1f, 1f, 0, 0, 1f)
                                }

                                EM -> {
                                    soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                }

                                G -> {
                                    soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                }

                                else -> {
                                    soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                }
                            }
                            true
                        }

                        4 -> {
                            when (flag) {
                                AM -> {
                                    soundPool?.play(soundA5!!, 1f, 1f, 0, 0, 1f)
                                }

                                C -> {
                                    soundPool?.play(soundA5!!, 1f, 1f, 0, 0, 1f)
                                }

                                B -> {
                                    soundPool?.play(soundB5!!, 1f, 1f, 0, 0, 1f)
                                }

                                E -> {
                                    soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                }

                                DM -> {
                                    soundPool?.play(soundDm5!!, 1f, 1f, 0, 0, 1f)
                                }

                                F -> {
                                    soundPool?.play(soundF5!!, 1f, 1f, 0, 0, 1f)
                                }

                                EM -> {
                                    soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                }

                                G -> {
                                    soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                }

                                else -> {
                                    soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                }
                            }
                            true
                        }

                        5 -> {
                            when (flag) {
                                AM -> {
                                    soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                }

                                C -> {
                                    soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                }

                                B -> {
                                    soundPool?.play(soundDm6!!, 1f, 1f, 0, 0, 1f)
                                }

                                E -> {
                                    soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                }

                                DM -> {
                                    soundPool?.play(soundDm6!!, 1f, 1f, 0, 0, 1f)
                                }

                                F -> {
                                    soundPool?.play(soundF6!!, 1f, 1f, 0, 0, 1f)
                                }

                                EM -> {
                                    soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                }

                                G -> {
                                    soundPool?.play(soundG6!!, 1f, 1f, 0, 0, 1f)
                                }

                                else -> {
                                    soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                }
                            }
                            true
                        }
                    }
                }
                if (ev.action == MotionEvent.ACTION_MOVE) {
                    if (!isAnimating[index] && currentViewID != view.id) {
                        currentViewID = view.id
                        startStringAnimation(index, view)
                        when (index) {
                            0 -> {
                                when (flag) {
                                    AM -> {
                                    }

                                    B -> {
                                    }

                                    C -> {
                                    }

                                    DM -> {
                                    }

                                    F -> {
                                        soundPool?.play(soundF1!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    G -> {
                                        soundPool?.play(soundG1!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    else -> {
                                        soundPool?.play(soundE11!!, 1f, 1f, 0, 0, 1f)
                                    }
                                }
                                true
                            }

                            1 -> {
                                when (flag) {
                                    AM -> {
                                        soundPool?.play(soundA12!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    C -> {
                                        soundPool?.play(soundF2!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    B -> {
                                        soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    E -> {
                                        soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    DM -> {
                                    }

                                    F -> {
                                        soundPool?.play(soundC2!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    EM -> {
                                        soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    G -> {
                                        soundPool?.play(soundE2!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    else -> {
                                        soundPool?.play(soundA12!!, 1f, 1f, 0, 0, 1f)
                                    }
                                }
                                true

                            }

                            2 -> {
                                when (flag) {
                                    AM -> {
                                        soundPool?.play(soundA3!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    C -> {
                                        soundPool?.play(soundF3!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    B -> {
                                        soundPool?.play(soundBm3!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    E -> {
                                        soundPool?.play(soundF3!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    DM -> {
                                        soundPool?.play(soundD23!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    F -> {
                                        soundPool?.play(soundF3!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    EM -> {
                                        soundPool?.play(soundEM3!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    G -> {
                                        soundPool?.play(soundD23!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    else -> {
                                        soundPool?.play(soundD23!!, 1f, 1f, 0, 0, 1f)
                                    }
                                }
                                true
                            }

                            3 -> {
                                when (flag) {
                                    AM -> {
                                        soundPool?.play(soundA4!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    C -> {
                                        soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    B -> {
                                        soundPool?.play(soundBm4!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    E -> {
                                        soundPool?.play(soundE4!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    DM -> {
                                        soundPool?.play(soundDm4!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    F -> {
                                        soundPool?.play(soundF4!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    EM -> {
                                        soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    G -> {
                                        soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    else -> {
                                        soundPool?.play(soundG24!!, 1f, 1f, 0, 0, 1f)
                                    }
                                }
                                true
                            }

                            4 -> {
                                when (flag) {
                                    AM -> {
                                        soundPool?.play(soundA5!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    C -> {
                                        soundPool?.play(soundA5!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    B -> {
                                        soundPool?.play(soundB5!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    E -> {
                                        soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    DM -> {
                                        soundPool?.play(soundDm5!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    F -> {
                                        soundPool?.play(soundF5!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    EM -> {
                                        soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    G -> {
                                        soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    else -> {
                                        soundPool?.play(soundB25!!, 1f, 1f, 0, 0, 1f)
                                    }
                                }
                                true
                            }

                            5 -> {
                                when (flag) {
                                    AM -> {
                                        soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    C -> {
                                        soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    B -> {
                                        soundPool?.play(soundDm6!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    E -> {
                                        soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    DM -> {
                                        soundPool?.play(soundDm6!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    F -> {
                                        soundPool?.play(soundF6!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    EM -> {
                                        soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    G -> {
                                        soundPool?.play(soundG6!!, 1f, 1f, 0, 0, 1f)
                                    }

                                    else -> {
                                        soundPool?.play(soundE36!!, 1f, 1f, 0, 0, 1f)
                                    }
                                }
                                true
                            }
                        }
                    }

                }

            }

        }
        return super.dispatchTouchEvent(ev)
    }


    private fun isViewUnder(view: View, x: Float, y: Float): Boolean {
        val location = IntArray(2)
        view.getLocationOnScreen(location)
        val viewX = location[0]
        val viewY = location[1]
        val viewWidth = view.width
        val viewHeight = view.height
        return x >= viewX && x <= viewX + viewWidth && y >= viewY && y <= viewY + viewHeight
    }


    private fun startStringAnimation(index: Int, view: View) {
        val upAnimator = ObjectAnimator.ofFloat(view, "translationY", 0f, -15f)
        upAnimator.duration = 25
        upAnimator.interpolator = AccelerateDecelerateInterpolator()
        val downAnimator = ObjectAnimator.ofFloat(view, "translationY", -15f, 0f)
        downAnimator.duration = 25
        downAnimator.interpolator = AccelerateDecelerateInterpolator()
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(upAnimator, downAnimator)
        animatorSet.duration = 50
        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
            }

            override fun onAnimationEnd(p0: Animator) {
                isAnimating[index] = false
            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationRepeat(p0: Animator) {
            }

        })
        animatorSet.start()
    }

    companion object {
        const val AM = 0
        const val C = 1
        const val B = 2
        const val BM = 8
        const val E = 3
        const val DM = 4
        const val F = 5
        const val EM = 6
        const val G = 7
    }

}