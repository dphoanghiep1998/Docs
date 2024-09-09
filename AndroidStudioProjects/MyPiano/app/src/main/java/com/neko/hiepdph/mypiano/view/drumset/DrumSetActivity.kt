package com.neko.hiepdph.mypiano.view.drumset

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import android.view.View
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.DrumSetStyle
import com.neko.hiepdph.mypiano.databinding.ActivityDrumsetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrumSetActivity : BaseActivity<ActivityDrumsetBinding>() {
    private val listStyleDrumSet = mutableListOf<DrumSetStyle>()
    private var soundPool: SoundPool? = null
    override fun getViewBinding(): ActivityDrumsetBinding {
        return ActivityDrumsetBinding.inflate(layoutInflater)
    }

    private var crash1: Int? = null
    private var crash2: Int? = null
    private var crash3: Int? = null
    private var hihatOpen: Int? = null
    private var hihatPedal: Int? = null
    private var kick: Int? = null
    private var snare: Int? = null
    private var pedal: Int? = null
    private var tamborine: Int? = null
    private var tom1: Int? = null
    private var tom2: Int? = null
    private var tom3: Int? = null
    private var bell: Int? = null
    private var ride: Int? = null
    override fun initView() {
        val audioAttributes: AudioAttributes =
            AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()
        soundPool =
            SoundPool.Builder().setMaxStreams(30).setAudioAttributes(audioAttributes).build()

        crash1 = soundPool?.load(this, R.raw.jazz_crash1, 0)
        crash2 = soundPool?.load(this, R.raw.jazz_crash2, 0)
        crash3 = soundPool?.load(this, R.raw.jazz_crash3, 0)
        hihatOpen = soundPool?.load(this, R.raw.hihat_open, 0)
        hihatPedal = soundPool?.load(this, R.raw.hihat_pedal, 0)
        bell = soundPool?.load(this, R.raw.bell, 0)
        snare = soundPool?.load(this, R.raw.snare, 0)
        tamborine = soundPool?.load(this, R.raw.tambourine, 0)
        kick = soundPool?.load(this, R.raw.bass, 0)
        tom1 = soundPool?.load(this, R.raw.tom1, 0)
        tom2 = soundPool?.load(this, R.raw.tom2, 0)
        tom3 = soundPool?.load(this, R.raw.tom3, 0)
        pedal = soundPool?.load(this, R.raw.block, 0)
        ride = soundPool?.load(this, R.raw.ride, 0)



        listStyleDrumSet.add(
            DrumSetStyle(
                0,
                imageCrash = R.drawable.ic_bg_crash_1,
                imageBellLeft = R.drawable.ic_bell_left_1,
                imageBellRight = R.drawable.ic_bell_right_1,
                imageBlock = R.drawable.ic_block_1,
                imageCrashCenter = R.drawable.ic_bg_crash_middle_1,
                imageKick = R.drawable.ic_kick_1,
                imageRide = R.drawable.ic_bg_ride_1,
                imageSnare = R.drawable.ic_snare_1,
                imageFloorTom = R.drawable.ic_floor_tom_1,
                imageTom = R.drawable.ic_tom_1,
                imageTambourine = R.drawable.ic_ramboutine_1,
                background = R.drawable.ic_bg_drumset_1

            ),

        )
        listStyleDrumSet.add(
            DrumSetStyle(
                1,
                imageCrash = R.drawable.ic_bg_crash_2,
                imageBellLeft = R.drawable.ic_bell_left_1,
                imageBellRight = R.drawable.ic_bell_right_1,
                imageBlock = R.drawable.ic_block_1,
                imageCrashCenter = R.drawable.ic_bg_crash_middle_2,
                imageKick = R.drawable.ic_kick_2,
                imageRide = R.drawable.ic_bg_ride_2,
                imageSnare = R.drawable.ic_snare_2,
                imageFloorTom = R.drawable.ic_floor_tom_2,
                imageTom = R.drawable.ic_tom_2,
                imageTambourine = R.drawable.ic_ramboutine_2,
                background = R.drawable.ic_bg_drumset_2

            ),
            )
        listStyleDrumSet.add(
            DrumSetStyle(
                2,
                imageCrash = R.drawable.ic_bg_crash_3,
                imageBellLeft = R.drawable.ic_bell_left_1,
                imageBellRight = R.drawable.ic_bell_right_1,
                imageBlock = R.drawable.ic_block_1,
                imageCrashCenter = R.drawable.ic_bg_crash_middle_3,
                imageKick = R.drawable.ic_floor_tom_3,
                imageRide = R.drawable.ic_ride_3,
                imageSnare = R.drawable.ic_snare_3,
                imageFloorTom = R.drawable.ic_kick_3,
                imageTom = R.drawable.ic_tom_3,
                imageTambourine = R.drawable.ic_ramboutine_3,
                background = R.drawable.ic_bg_drumset_3

            ),
        )
        listStyleDrumSet.add(
            DrumSetStyle(
                3,
                imageCrash = R.drawable.ic_bg_crash_4,
                imageBellLeft = R.drawable.ic_bell_left_1,
                imageBellRight = R.drawable.ic_bell_right_1,
                imageBlock = R.drawable.ic_block_1,
                imageCrashCenter = R.drawable.ic_bg_crash_middle_4,
                imageKick = R.drawable.ic_kick_4,
                imageRide = R.drawable.ic_ride_4,
                imageSnare = R.drawable.ic_snare_4,
                imageFloorTom = R.drawable.ic_floor_tome_4,
                imageTom = R.drawable.ic_tom_4,
                imageTambourine = R.drawable.ic_ramboutine_4,
                background = R.drawable.ic_bg_drumset_4

            ),
        )
        listStyleDrumSet.add(
            DrumSetStyle(
                4,
                imageCrash = R.drawable.ic_bg_crash_5,
                imageBellLeft = R.drawable.ic_bell_left_1,
                imageBellRight = R.drawable.ic_bell_right_1,
                imageBlock = R.drawable.ic_block_1,
                imageCrashCenter = R.drawable.ic_bg_crash_middle_5,
                imageKick = R.drawable.ic_kick_5,
                imageRide = R.drawable.ic_ride_5,
                imageSnare = R.drawable.ic_snare_5,
                imageFloorTom = R.drawable.ic_floor_tom_5,
                imageTom = R.drawable.ic_tom_5,
                imageTambourine = R.drawable.ic_ramboutine_5,
                background = R.drawable.ic_bg_drumset_5

            ),
        )

        initViewDrum(config.indexThemeDrum)
        initButton()

    }

    private fun initButton() {
        binding.btnHome.clickWithDebounce {
            finish()
        }

        binding.btnStyle.clickWithDebounce {
            startActivity(Intent(this,StyleDrumActivity::class.java))
            finish()
        }

        binding.crashLeft.setOnClickListener {
            startStringAnimation(binding.crashLeft)
            soundPool?.play(crash1!!,1f,1f,1,0,1f)
        }

        binding.crashMiddle.setOnClickListener {
            startStringAnimation(binding.crashMiddle)
            soundPool?.play(crash2!!,1f,1f,1,0,1f)

        }
        binding.crashRight.setOnClickListener {
            startStringAnimation(binding.crashRight)
            soundPool?.play(crash3!!,1f,1f,1,0,1f)

        }
        binding.rideLeft.setOnClickListener {
            startStringAnimation(binding.rideLeft)
            soundPool?.play(ride!!,1f,1f,1,0,1f)

        }
        binding.bellLeft.setOnClickListener {
            startStringAnimation(binding.bellLeft)
            soundPool?.play(bell!!,1f,1f,1,0,1f)

        }
        binding.floorTomLeft.setOnClickListener {
            startStringAnimation(binding.floorTomLeft)
            soundPool?.play(tom1!!,1f,1f,1,0,1f)

        }
        binding.tom.setOnClickListener {
            startStringAnimation(binding.tom)
            soundPool?.play(tom2!!,1f,1f,1,0,1f)

        }
        binding.floorTomRight.setOnClickListener {
            startStringAnimation(binding.floorTomRight)
            soundPool?.play(tom3!!,1f,1f,1,0,1f)

        }
        binding.bellRight.setOnClickListener {
            startStringAnimation(binding.bellRight)
            soundPool?.play(bell!!,1f,1f,1,0,1f)

        }

        binding.rideRight.setOnClickListener {
            startStringAnimation(binding.rideRight)
            soundPool?.play(ride!!,1f,1f,1,0,1f)

        }

        binding.block.setOnClickListener {
            startStringAnimation(binding.block)
            soundPool?.play(pedal!!,1f,1f,1,0,1f)

        }
        binding.kickLeft.setOnClickListener {
            startStringAnimation(binding.kickLeft)
            soundPool?.play(kick!!,1f,1f,1,0,1f)

        }
        binding.snare.setOnClickListener {
            startStringAnimation(binding.snare)
            soundPool?.play(snare!!,1f,1f,1,0,1f)

        }
        binding.kickRight.setOnClickListener {
            startStringAnimation(binding.kickRight)
            soundPool?.play(kick!!,1f,1f,1,0,1f)

        }
        binding.tambourine.setOnClickListener {
            startStringAnimation(binding.tambourine)
            soundPool?.play(tamborine!!,1f,1f,1,0,1f)

        }
    }

    private fun initViewDrum(index: Int) {
        binding.crashLeft.setImageResource(listStyleDrumSet[index].imageCrash)
        binding.crashMiddle.setImageResource(listStyleDrumSet[index].imageCrashCenter)
        binding.crashRight.setImageResource(listStyleDrumSet[index].imageCrash)
        binding.rideLeft.setImageResource(listStyleDrumSet[index].imageRide)
        binding.bellLeft.setImageResource(listStyleDrumSet[index].imageBellLeft)
        binding.floorTomLeft.setImageResource(listStyleDrumSet[index].imageFloorTom)
        binding.tom.setImageResource(listStyleDrumSet[index].imageTom)
        binding.floorTomRight.setImageResource(listStyleDrumSet[index].imageFloorTom)
        binding.bellRight.setImageResource(listStyleDrumSet[index].imageBellRight)
        binding.rideRight.setImageResource(listStyleDrumSet[index].imageRide)
        binding.block.setImageResource(listStyleDrumSet[index].imageBlock)
        binding.kickLeft.setImageResource(listStyleDrumSet[index].imageKick)
        binding.snare.setImageResource(listStyleDrumSet[index].imageSnare)
        binding.kickRight.setImageResource(listStyleDrumSet[index].imageKick)
        binding.tambourine.setImageResource(listStyleDrumSet[index].imageTambourine)
        binding.background.setImageResource(listStyleDrumSet[index].background)

    }

    private fun startStringAnimation(view: View) {
        val upAnimator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.1f)
        upAnimator.duration = 30
        val downAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.1f)
        downAnimator.duration = 30
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