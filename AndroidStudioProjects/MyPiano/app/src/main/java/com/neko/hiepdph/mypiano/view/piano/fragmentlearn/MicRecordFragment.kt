package com.neko.hiepdph.mypiano.view.piano.fragmentlearn

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.fragment.app.viewModels
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseFragment
import com.neko.hiepdph.mypiano.common.hide
import com.neko.hiepdph.mypiano.common.show
import com.neko.hiepdph.mypiano.data.model.MicRecord
import com.neko.hiepdph.mypiano.databinding.FragmentMicRecordBinding
import com.neko.hiepdph.mypiano.view.dialog.DialogDeleteFile
import com.neko.hiepdph.mypiano.view.dialog.DialogSaveFile
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
            if (it.isEmpty()) {
                binding.icEmpty.show()
                binding.tvEmpty.show()
            } else {
                binding.icEmpty.hide()
                binding.tvEmpty.hide()
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
        }, onSuspendItem = {
            if (exoPlayer?.isPlaying == true) {
                exoPlayer?.stop()
            }
        }, onClearItem = {
            if (exoPlayer?.isPlaying == true) {
                exoPlayer?.stop()
            }
        }, onDelete = {
            val dialogDeleteFile = DialogDeleteFile(requireContext(), onDelete = {
                viewModel.deleteMicRecord(it.id)
                Toast.makeText(requireContext(),requireActivity().getString(R.string.delete_success),Toast.LENGTH_SHORT).show()
            })
            dialogDeleteFile.show()
        }, onRename = { item ->
            val dialogSaveFile = DialogSaveFile(requireContext(), onSaveFile = {
                item.apply {
                    name = it
                }
                viewModel.insertMicRecord(item)
                Toast.makeText(requireContext(),requireActivity().getString(R.string.rename_successfully),Toast.LENGTH_SHORT).show()
            }, onCancelFile = {

            }, item.name)
            dialogSaveFile.show()
        }, onShare = {
            shareFile(it)
        })
        binding.rcvMic.adapter = adapter

    }
    private fun shareFile(item:MicRecord) {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "*/*"
            shareIntent.putExtra(Intent.EXTRA_STREAM, item.path)
            shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(shareIntent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}