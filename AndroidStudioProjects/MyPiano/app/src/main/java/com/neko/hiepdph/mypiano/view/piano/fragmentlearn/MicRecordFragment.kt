package com.neko.hiepdph.mypiano.view.piano.fragmentlearn

import android.media.session.PlaybackState
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.fragment.app.viewModels
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.neko.hiepdph.mypiano.common.base_component.BaseFragment
import com.neko.hiepdph.mypiano.common.hide
import com.neko.hiepdph.mypiano.common.show
import com.neko.hiepdph.mypiano.databinding.FragmentMicRecordBinding
import com.neko.hiepdph.mypiano.view.piano.fragmentlearn.adapter.MicRecordAdapter
import com.neko.hiepdph.mypiano.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MicRecordFragment : BaseFragment<FragmentMicRecordBinding>() {
    private var adapter: MicRecordAdapter? = null
    private val viewModel by viewModels<AppViewModel>()
    private var exoPlayer: ExoPlayer? = null
    override fun getViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentMicRecordBinding {
        return FragmentMicRecordBinding.inflate(layoutInflater)
    }

    override fun initView() {
        exoPlayer = ExoPlayer.Builder(requireContext()).build().apply {
            playWhenReady = true
            repeatMode = ExoPlayer.REPEAT_MODE_OFF
        }
        exoPlayer?.addListener(object : Player.Listener {


            @OptIn(UnstableApi::class)
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                super.onPlayerStateChanged(playWhenReady, playbackState)
                Log.d("TAG", "onPlayerStateChanged: "+playbackState)

                if (playbackState == Player.STATE_ENDED) {
                    adapter?.resetStatus()
                }
            }

        })
        initRecyclerView()
        observe()
    }

    private fun observe() {
        viewModel.getListMicRecord().observe(this) {
            if(it.isEmpty()){
                binding.icEmpty.show()
            }else{
                binding.icEmpty.hide()
            }
            adapter?.setData(it.toMutableList())
        }
    }

    private fun initRecyclerView() {
        adapter = MicRecordAdapter(onClickItem = {
//            exoPlayer?.clearMediaItems()
//            if (exoPlayer?.isPlaying == true) {
//                exoPlayer?.pause()
//            }
            exoPlayer?.setMediaItem(MediaItem.fromUri(it.path))
            exoPlayer?.prepare()
        }, onClearItem = {
            if (exoPlayer?.isPlaying == true) {
                exoPlayer?.stop()
            }
        }, onDelete = {}, onRename = {}, onShare = {})
        binding.rcvMic.adapter = adapter

    }

}