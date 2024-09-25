package com.neko.hiepdph.mypiano.view.piano

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.net.Uri
import android.os.Handler
import android.provider.Settings
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.PopupWindow
import android.widget.SeekBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.AutoPlaySong
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.DateUtils
import com.neko.hiepdph.mypiano.common.FastUtils
import com.neko.hiepdph.mypiano.common.Recorder
import com.neko.hiepdph.mypiano.common.base_component.BaseActivity
import com.neko.hiepdph.mypiano.common.buildMinVersion33
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.common.customview.ChangeXInterface
import com.neko.hiepdph.mypiano.common.customview.CustomGuideView
import com.neko.hiepdph.mypiano.common.customview.tickseekbar.OnSeekChangeListener
import com.neko.hiepdph.mypiano.common.customview.tickseekbar.SeekParams
import com.neko.hiepdph.mypiano.common.customview.tickseekbar.TickSeekBar
import com.neko.hiepdph.mypiano.common.hide
import com.neko.hiepdph.mypiano.common.listener.OnLoadAudioListener
import com.neko.hiepdph.mypiano.common.listener.OnPianoAutoPlayListener
import com.neko.hiepdph.mypiano.common.listener.OnPianoListener
import com.neko.hiepdph.mypiano.common.show
import com.neko.hiepdph.mypiano.data.model.AudioFile
import com.neko.hiepdph.mypiano.data.model.AutoPlayEntity
import com.neko.hiepdph.mypiano.data.model.KeysRecord
import com.neko.hiepdph.mypiano.data.model.MicRecord
import com.neko.hiepdph.mypiano.data.model.Piano
import com.neko.hiepdph.mypiano.data.model.SongModel
import com.neko.hiepdph.mypiano.databinding.ActivityPianoBinding
import com.neko.hiepdph.mypiano.databinding.LayoutMenuPopupwindowBinding
import com.neko.hiepdph.mypiano.databinding.LayoutSpeedPopupwindowBinding
import com.neko.hiepdph.mypiano.databinding.LayoutVolumePopupwindowBinding
import com.neko.hiepdph.mypiano.view.dialog.DialogKeyMode
import com.neko.hiepdph.mypiano.view.dialog.DialogRecord
import com.neko.hiepdph.mypiano.view.dialog.DialogRequestPermission
import com.neko.hiepdph.mypiano.view.dialog.DialogSaveFile
import com.neko.hiepdph.mypiano.view.guitar.GuitarActivity
import com.neko.hiepdph.mypiano.view.main.MainActivity
import com.neko.hiepdph.mypiano.view.success.SaveSuccessActivity
import com.neko.hiepdph.mypiano.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import java.io.File
import java.util.Timer
import java.util.TimerTask
import kotlin.math.ceil


@AndroidEntryPoint
class PianoActivity : BaseActivity<ActivityPianoBinding>() {
    private var scrollProgress = 0
    private val SEEKBAR_OFFSET_SIZE = 0

    private var popupWindowMenu: PopupWindow? = null
    private var popupWindowSpeed: PopupWindow? = null
    private var popupWindowVolume: PopupWindow? = null
    private var menuBinding: LayoutMenuPopupwindowBinding? = null
    private var speedBinding: LayoutSpeedPopupwindowBinding? = null
    private var audioBinding: LayoutVolumePopupwindowBinding? = null
    private var timer: Timer? = null
    private var recorder: Recorder? = null
    private val viewModel by viewModels<AppViewModel>()
    private var isKeyRecord = false
    private var second = 0
    private var isAutoPlaying = false
    private var firstTimeRecord = 0L
    private var listAutoPlayEntity = mutableListOf<AutoPlayEntity>()
    private var keyRecord: KeysRecord? = null
    private var itemAudioFile: AudioFile? = null
    override fun getViewBinding(): ActivityPianoBinding {
        return ActivityPianoBinding.inflate(layoutInflater)
    }

    private var exoPlayer: ExoPlayer? = null
    private val handle = Handler()
    private var runnableAudio = object : Runnable {
        override fun run() {
            exoPlayer?.currentPosition?.toFloat()?.let {

                if (exoPlayer?.duration != null && exoPlayer!!.duration > -1) {
                    val progress = (it + 1000) / exoPlayer?.duration!! * 100
                    binding.seekAudioProgress.setProgress(progress)
                }
                binding.tvAudioProgress.text =
                    DateUtils.convertSecondToString((ceil(it / 1000f)).toInt())
            }
            handle.postDelayed(this, 1000)

        }
    }


    private fun setAutoPlay() {
        when (config.indexSong) {
            -1 -> {
                binding.pianoView.autoPlay(listAutoPlayEntity)
            }

            0 -> {
                binding.pianoView.autoPlay(AutoPlaySong.getHPBDSong(this))
            }

            1 -> {
                binding.pianoView.autoPlay(AutoPlaySong.getJingleBellSong(this))
            }

            2 -> {
                binding.pianoView.autoPlay(AutoPlaySong.getLitterStarNote(this))

            }

            3 -> {
                binding.pianoView.autoPlay(AutoPlaySong.getLastChristmasSong(this))

            }

            4 -> {
                binding.pianoView.autoPlay(AutoPlaySong.getAllOfMeNote(this))
            }

            5 -> {}
            6 -> {}
        }
    }


    override fun initView() {

        listAutoPlayEntity.addAll(AutoPlaySong.getHPBDSong(this))

        initExoplayer()

        if (intent.getBooleanExtra(Constant.KEY_PLAY_AUDIO, false)) {

            val item = intent.getParcelableExtra<AudioFile>(Constant.KEY_AUDIO_FILE)
            if (item != null) {
                itemAudioFile = item
                binding.layoutTopSecond.show()
                binding.layoutTop.hide()
                startAudio(item)
            }
            intent.removeExtra(Constant.KEY_PLAY_AUDIO)
        } else {
            binding.layoutTopSecond.hide()
            binding.layoutTop.show()
        }
        binding.tvSong.isSelected = true
        binding.tvAudioName.isSelected = true
        initPopupWindow()
        initPopupSpeed()
        initVolumeWindow()
        initPiano()
        initButton()
        val changeXInterface = ChangeXInterface { progress ->
            binding.sb.progress = progress
        }
        binding.pianoView.setChangeXListener(changeXInterface)
        binding.pianoView.post {
            binding.pianoView.scrollToC3()
        }

        if (config.isFirstOpenPiano) {
            CustomGuideView.Builder(this).setContentText(getString(R.string.guide_1))
                .setContentTypeFace(
                    ResourcesCompat.getFont(this, R.font.font_400)
                ).setTargetView(binding.tvSong).setContentTextSize(20)
                .setDismissType(DismissType.outside)
                .setGravity(smartdevelop.ir.eram.showcaseviewlib.config.Gravity.center)
                .setGuideListener {
                    CustomGuideView.Builder(this).setContentText(getString(R.string.guide_2))
                        .setContentTypeFace(
                            ResourcesCompat.getFont(this, R.font.font_400)
                        ).setTargetView(binding.tvSpeed).setContentTextSize(20)
                        .setDismissType(DismissType.outside)
                        .setGravity(smartdevelop.ir.eram.showcaseviewlib.config.Gravity.center)
                        .setGuideListener {
                            CustomGuideView.Builder(this)
                                .setContentText(getString(R.string.guide_3)).setContentTypeFace(
                                    ResourcesCompat.getFont(this, R.font.font_400)
                                ).setTargetView(binding.btnStyle).setContentTextSize(20)
                                .setDismissType(DismissType.outside)
                                .setGravity(smartdevelop.ir.eram.showcaseviewlib.config.Gravity.center)
                                .build().show()
                        }.build().show()
                }.build().show()
            config.isFirstOpenPiano = false
        }
    }

    private fun initPiano() {
        binding.pianoView.setIndexTheme(config.indexTheme)
        binding.pianoView.setSoundPollMaxStream(10)
        binding.sb.thumbOffset = SEEKBAR_OFFSET_SIZE
        binding.pianoView.setPianoListener(object : OnPianoListener {
            override fun onPianoInitFinish() {
                if (intent.getBooleanExtra(Constant.KEY_LESSON, false)) {
                    setupPlayer()
                    intent.removeExtra(Constant.KEY_LESSON)
                }
                val item = intent.getParcelableExtra<KeysRecord>(Constant.KEY_RECORD_KEY)
                if (item != null) {
                    config.indexSong = -1
                    binding.tvSong.text = item.name
                    listAutoPlayEntity.clear()
                    listAutoPlayEntity.addAll(item.listKey)
                    binding.pianoView.autoPlay(listAutoPlayEntity)
                    intent.removeExtra(Constant.KEY_RECORD_KEY)
                }
            }

            override fun onPianoClick(
                type: Piano.PianoKeyType?,
                voice: Piano.PianoVoice?,
                group: Int,
                positionOfGroup: Int

            ) {
                if (isKeyRecord) {
                    val currentTime = System.currentTimeMillis()
                    val delayTime = currentTime - firstTimeRecord
                    firstTimeRecord = currentTime
                    val autoPlayEntity = AutoPlayEntity(type, group, positionOfGroup, delayTime)
                    Log.d("TAG", "onPianoClick: " + autoPlayEntity)
                    listAutoPlayEntity.add(autoPlayEntity)
                }
            }

        })

        binding.pianoView.setAutoPlayListener(object : OnPianoAutoPlayListener {
            override fun onPianoAutoPlayStart() {
                binding.btnPlay.setImageResource(R.drawable.ic_pause)
                isAutoPlaying = true
            }

            override fun onPianoAutoPlayEnd() {
                binding.btnPlay.setImageResource(R.drawable.ic_play)
                isAutoPlaying = false

            }

        })

        binding.pianoView.setLoadAudioListener(object : OnLoadAudioListener {
            override fun loadPianoAudioStart() {
            }

            override fun loadPianoAudioFinish() {
            }

            override fun loadPianoAudioError(e: Exception?) {
            }

            override fun loadPianoAudioProgress(progress: Int) {
            }

        })

        binding.sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.pianoView.scroll(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })
    }

    private fun initExoplayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        exoPlayer?.apply {
            playWhenReady = true
        }
    }

    private fun initVolumeWindow() {
        audioBinding = LayoutVolumePopupwindowBinding.inflate(layoutInflater)
        popupWindowVolume = PopupWindow(
            speedBinding!!.root,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        popupWindowVolume?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        popupWindowVolume?.isOutsideTouchable = true;
        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager
        val max = audioManager.getStreamMaxVolume(AudioManager.FLAG_PLAY_SOUND)

        audioBinding?.let {
            it.speedBar.max = max.toFloat()

            it.btnBackground.clickWithDebounce {
                popupWindowSpeed?.dismiss()
            }
            it.containerMain.clickWithDebounce {

            }

            it.speedBar.onSeekChangeListener = object : OnSeekChangeListener {
                override fun onSeeking(seekParams: SeekParams?) {
                    audioManager.setStreamVolume(
                        AudioManager.FLAG_PLAY_SOUND, it.speedBar.progress, 0
                    )
                }

                override fun onStartTrackingTouch(seekBar: TickSeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: TickSeekBar?) {
                }

            }


        }
    }

    private fun initTimer() {
        second = 0
        binding.tvTime.text = "00:00"
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                second += 1
                binding.tvTime.text = FastUtils.formatTime(second)
            }

        }, 0, 1000)
    }

    private fun initButton() {
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

        binding.btnImportAudio.clickWithDebounce {
            if (buildMinVersion33()) {
                if (checkSelfPermission(Manifest.permission.READ_MEDIA_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(Intent(this, ImportAudioActivity::class.java))
                    //do smt
                } else {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.READ_MEDIA_AUDIO)) {
                        val dialogRequestPermission = DialogRequestPermission(this, onClickGrant = {
                            activityLauncherForPermission.launch(
                                Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.fromParts("package", packageName, null)
                                )
                            )
                        }, 2)
                        dialogRequestPermission.show()


                    } else {
                        permissionLauncher.launch(Manifest.permission.READ_MEDIA_AUDIO)
                    }
                }
            } else {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(Intent(this, ImportAudioActivity::class.java))

                    //do smt
                } else {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        val dialogRequestPermission = DialogRequestPermission(this, onClickGrant = {
                            activityLauncherForPermission.launch(
                                Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.fromParts("package", packageName, null)
                                )
                            )
                        }, 1)
                        dialogRequestPermission.show()
                    } else {
                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                    }
                }
            }
        }

        changeBackPressCallBack {
            if (!config.isUserRated) {
                setResult(3001)
            }
            if (!MainActivity.isRunning) {
                startActivity(Intent(this, MainActivity::class.java).apply {

                })
            }
            finish()
        }

        binding.btnHome.clickWithDebounce {
            if (!config.isUserRated) {
                setResult(3001)
            }
            if (!MainActivity.isRunning) {
                startActivity(Intent(this, MainActivity::class.java).apply {
                    putExtra(Constant.KEY_USER_RATED, true)
                })
            }
            finish()
        }

        binding.btnGuitar.clickWithDebounce {
            startActivity(Intent(this, GuitarActivity::class.java))
        }

        binding.btnKeyMode.clickWithDebounce {
            val dialogKeyMode = DialogKeyMode(this, onClickDoubleKey = {
                startActivity(Intent(this, DoubleKeyPianoActivity::class.java))
            }, onClickTwoPlayer = {
                startActivity(Intent(this, TwoPlayerPianoActivity::class.java))

            })
            dialogKeyMode.show()
        }

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

        binding.btnIncreaseSize.clickWithDebounce {
            binding.pianoView.increaseSizeKey()
        }

        binding.btnDecreaseSize.clickWithDebounce {
            binding.pianoView.decreaseSizeKey()

        }

        binding.tvSpeed.clickWithDebounce {
            binding.pianoView.releaseAutoPlay()
            popupWindowSpeed?.showAsDropDown(binding.tvSpeed, -100, 100, Gravity.CENTER)
        }

        binding.btnPlay.clickWithDebounce {
            if (!isAutoPlaying) {
                setAutoPlay()
            } else {
                binding.pianoView.releaseAutoPlay()
            }
        }

        binding.tvSong.clickWithDebounce {
            activityLauncher.launch(Intent(this, LearnActivity::class.java))
        }

        binding.btnMenu.clickWithDebounce {
            popupWindowMenu?.showAsDropDown(binding.btnMenu, 0, -100, Gravity.TOP)
        }

        binding.btnStyle.clickWithDebounce {
            activityLauncherForStyle.launch(Intent(this, StylePianoActivity::class.java))
        }

        binding.containerRecord.clickWithDebounce {
            val dialogRecord = DialogRecord(this, onClickKey = {
                isKeyRecord = true
                firstTimeRecord = System.currentTimeMillis()
                keyRecord = KeysRecord(-1, "", firstTimeRecord, 0, mutableListOf())
                initTimer()
                binding.tvTime.show()
                binding.containerRec.hide()
                binding.tvTime.clickWithDebounce {
                    afterRecordKey()
                }
                listAutoPlayEntity.clear()
            }, onClickMic = {
                isKeyRecord = false

                if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                    //do smt
                    doRecordAudio()
                } else {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.RECORD_AUDIO)) {
                        val dialogRequestPermission = DialogRequestPermission(this, onClickGrant = {
                            activityLauncherForPermissionRecord.launch(
                                Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.fromParts("package", packageName, null)
                                )
                            )
                        })
                        dialogRequestPermission.show()

                    } else {
                        permissionRecordLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    }
                }
            })
            dialogRecord.show()
        }

        binding.tvAudioName.clickWithDebounce {
            startActivity(Intent(this, ImportAudioActivity::class.java))
        }

        binding.btnPlayAudio.clickWithDebounce {
            if (exoPlayer?.isPlaying == true) {
                exoPlayer?.pause()
                binding.btnPlayAudio.setImageResource(R.drawable.ic_play_audio)
            } else {
                handle.removeCallbacks(runnableAudio)
                handle.post(runnableAudio)
                if (exoPlayer?.playbackState == Player.STATE_ENDED) {
                    itemAudioFile?.let { startAudio(it) }
                } else {
                    exoPlayer?.play()
                }
                binding.btnPlayAudio.setImageResource(R.drawable.ic_pause_import)


//                itemAudioFile?.let { startAudio(it) }

            }
        }
        binding.btnVolume.clickWithDebounce {
            popupWindowVolume?.showAsDropDown(binding.btnVolume, -100, 100, Gravity.CENTER)

        }

        binding.btnCloseAudio.clickWithDebounce {
            binding.layoutTop.show()
            binding.layoutTopSecond.hide()
            if(exoPlayer?.isPlaying == true){
                exoPlayer?.stop()
            }
        }

        binding.seekAudioProgress.onSeekChangeListener = object : OnSeekChangeListener {
            override fun onSeeking(seekParams: SeekParams?) {

            }

            override fun onStartTrackingTouch(seekBar: TickSeekBar?) {
                handle.removeCallbacks(runnableAudio)
                if (exoPlayer?.isPlaying == true) {
                    exoPlayer?.pause()
                }
                binding.btnPlayAudio.setImageResource(R.drawable.ic_play_audio)

            }

            override fun onStopTrackingTouch(seekBar: TickSeekBar?) {
                exoPlayer?.seekTo((binding.seekAudioProgress.progress.toFloat() / 100f * exoPlayer?.duration!!).toLong())
                exoPlayer?.play()
                binding.btnPlayAudio.setImageResource(R.drawable.ic_pause_import)
                handle.post(runnableAudio)

            }

        }

        binding.btnResize.clickWithDebounce {
            if (binding.layoutTop.visibility == View.VISIBLE) {
                binding.layoutTop.visibility = View.GONE
                binding.pianoView.resetKey()
            } else {
                binding.layoutTop.visibility = View.VISIBLE
                binding.pianoView.resetKey()
            }
        }
    }

    private fun stopAudio() {

    }

    private fun resumeAudio() {

    }

    private fun startAudio(item: AudioFile) {
        handle.post(runnableAudio)

        binding.tvaudioDuration.text =
            DateUtils.convertSecondToString((item.duration.toFloat() / 1000).toInt())

        binding.tvAudioName.text = item.name
        exoPlayer?.clearMediaItems()
        exoPlayer?.setMediaItem(MediaItem.fromUri(Uri.parse(item.audioPath)))
        exoPlayer?.removeListener(listener)
        exoPlayer?.addListener(listener)
        exoPlayer?.prepare()


    }

    private val listener = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            super.onPlaybackStateChanged(playbackState)
            if (playbackState == Player.STATE_ENDED) {
                binding.seekAudioProgress.setProgress(0f)
                binding.tvAudioProgress.text = "00:00"
                handle.removeCallbacks(runnableAudio)
                binding.btnPlayAudio.setImageResource(R.drawable.ic_play_audio)
            }
        }
    }

    private fun afterRecordKey() {
        var newName = "record_key_${System.currentTimeMillis()}"
        val dialogSaveFile = DialogSaveFile(this@PianoActivity, onSaveFile = {

            keyRecord?.apply {
                duration = second
                listKey = listAutoPlayEntity
                name = it
            }
            Log.d("TAG", "afterRecordKey: " + keyRecord?.listKey)

            viewModel.insertKeyRecord(keyRecord!!)
            second = 0
            activityLauncher.launch(Intent(this, SaveSuccessActivity::class.java).apply {
                putExtra(Constant.IS_KEY_RECORD, true)
            })

        }, onCancelFile = {
            second = 0

        }, newName)
        dialogSaveFile.show()
        resetRecord()
    }

    private fun doRecordAudio() {
        initTimer()
        recorder = Recorder()
        recorder?.apply {
            init(this@PianoActivity)
            startRecording()
        }
        binding.tvTime.show()
        binding.containerRec.hide()
        binding.tvTime.clickWithDebounce {
            afterRecordMic()
        }

    }

    private fun afterRecordMic() {

        val name = recorder?.stopRecording()
        name?.let { mName ->
            val dialogSaveFile = DialogSaveFile(this@PianoActivity, onSaveFile = {
                File(filesDir, mName).renameTo(File(filesDir, it))
                val micRecord =
                    MicRecord(-1, it, System.currentTimeMillis(), second, "$filesDir/$it")
                viewModel.insertMicRecord(micRecord)
                second = 0
                activityLauncher.launch(Intent(this, SaveSuccessActivity::class.java).apply {
                    putExtra(Constant.IS_MIC_RECORD, true)
                })
            }, onCancelFile = {
                File(filesDir, mName).delete()
                second = 0

            }, mName)
            dialogSaveFile.show()
            resetRecord()

        }
    }


    private fun resetRecord() {
        timer?.cancel()
        binding.tvTime.hide()
        binding.containerRec.show()
        binding.tvTime.text = "00:00"
        isKeyRecord = false

    }

    private fun initPopupWindow() {
        menuBinding = LayoutMenuPopupwindowBinding.inflate(layoutInflater)
        popupWindowMenu = PopupWindow(
            menuBinding!!.root,
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )


        menuBinding?.let {
            it.btnClose.clickWithDebounce {
                popupWindowMenu?.dismiss()
            }
            it.btnBackground.clickWithDebounce {
                popupWindowMenu?.dismiss()
            }
            it.containerMain.clickWithDebounce {

            }

            lifecycleScope.launchWhenResumed {
                it.switchNote.isChecked = config.showNote
                it.switchPitch.isChecked = config.pitch
                it.switchReverb.isChecked = config.reverb
            }

            it.switchNote.clickWithDebounce {
                config.showNote = it.switchNote.isChecked
                setShowNote()
            }

            it.switchReverb.clickWithDebounce {
                config.reverb = it.switchReverb.isChecked
                binding.pianoView.resetKey()


            }

            it.switchPitch.clickWithDebounce {
                config.pitch = it.switchPitch.isChecked
            }
        }


    }

    private fun initPopupSpeed() {
        speedBinding = LayoutSpeedPopupwindowBinding.inflate(layoutInflater)
        popupWindowSpeed = PopupWindow(
            speedBinding!!.root,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        popupWindowSpeed?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        popupWindowSpeed?.isOutsideTouchable = true;

        speedBinding?.let {
            it.speedBar.setProgress(config.speed)
            it.btnBackground.clickWithDebounce {
                popupWindowSpeed?.dismiss()
            }
            it.containerMain.clickWithDebounce {

            }



            it.speedBar.onSeekChangeListener = object : OnSeekChangeListener {
                override fun onSeeking(seekParams: SeekParams?) {
                }

                override fun onStartTrackingTouch(seekBar: TickSeekBar?) {
                    binding.pianoView.releaseAutoPlay()
                }

                override fun onStopTrackingTouch(seekBar: TickSeekBar?) {
                    config.speed = it.speedBar.progress.toFloat()
                }

            }


        }


    }


    private fun setShowNote() {
        binding.pianoView.setIndexTheme(config.indexTheme)
        binding.pianoView.setShowNote(config.showNote)
    }

    override fun onPause() {
        super.onPause()
        binding.pianoView.releaseAutoPlay()
        if (exoPlayer?.isPlaying == true) {
            exoPlayer?.pause()
            binding.btnPlayAudio.setImageResource(R.drawable.ic_play_audio)
        }
    }

    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == 101) {
                setupPlayer()
            }
            if (it.resultCode == 3000) {
                val dialogRecord = DialogRecord(this, onClickKey = {
                    isKeyRecord = true
                    firstTimeRecord = System.currentTimeMillis()
                    keyRecord = KeysRecord(-1, "", firstTimeRecord, 0, mutableListOf())
                    initTimer()
                    binding.tvTime.show()
                    binding.containerRec.hide()
                    binding.tvTime.clickWithDebounce {
                        afterRecordKey()
                    }
                    listAutoPlayEntity.clear()

                }, onClickMic = {
                    isKeyRecord = false

                    if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                        //do smt
                        doRecordAudio()
                    } else {
                        if (shouldShowRequestPermissionRationale(Manifest.permission.RECORD_AUDIO)) {
                            activityLauncherForPermissionRecord.launch(
                                Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.fromParts("package", packageName, null)
                                )
                            )
                        } else {
                            permissionRecordLauncher.launch(Manifest.permission.RECORD_AUDIO)
                        }
                    }
                })
                dialogRecord.show()
            }
        }

    private fun setupPlayer() {
        val listSong = mutableListOf(
            SongModel(R.drawable.ic_song_1, getString(R.string.happy_birthday)),
            SongModel(R.drawable.ic_song_2, getString(R.string.jingbell)),
            SongModel(R.drawable.ic_song_3, getString(R.string.little_star)),
            SongModel(R.drawable.ic_song_4, getString(R.string.last_christmas)),
            SongModel(R.drawable.ic_song_5, getString(R.string.all_of_me)),
        )
        Log.d("TAG", "setupPlayer: " + binding.tvSong.text)
        binding.tvSong.text = listSong[config.indexSong].name
        setAutoPlay()

    }

    private var permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (buildMinVersion33()) {
                if (checkSelfPermission(Manifest.permission.READ_MEDIA_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                    // do smt
                    startActivity(Intent(this, ImportAudioActivity::class.java))

                }
            } else {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    //do smt
                    startActivity(Intent(this, ImportAudioActivity::class.java))

                }
            }
        }

    private var activityLauncherForPermission =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (buildMinVersion33()) {
                if (checkSelfPermission(Manifest.permission.READ_MEDIA_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                    // do smt
                    startActivity(Intent(this, ImportAudioActivity::class.java))

                }
            } else {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    //do smt
                    startActivity(Intent(this, ImportAudioActivity::class.java))
                }
            }
        }

    private var activityLauncherForStyle =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            binding.pianoView.setIndexTheme(config.indexTheme)
            binding.pianoView.resetKey()
        }


    private var permissionRecordLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
            //do smt
            doRecordAudio()
        }
    }

    private var activityLauncherForPermissionRecord = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (checkSelfPermission(
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            //do smt
            doRecordAudio()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (exoPlayer?.isPlaying == true) {
            exoPlayer?.stop()

        }
        exoPlayer?.release()
    }

}