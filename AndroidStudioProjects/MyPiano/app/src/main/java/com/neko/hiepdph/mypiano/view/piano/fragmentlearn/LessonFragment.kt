package com.neko.hiepdph.mypiano.view.piano.fragmentlearn

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseFragment
import com.neko.hiepdph.mypiano.common.config
import com.neko.hiepdph.mypiano.data.model.SongModel
import com.neko.hiepdph.mypiano.databinding.FragmentLessonBinding
import com.neko.hiepdph.mypiano.view.piano.PianoActivity
import com.neko.hiepdph.mypiano.view.piano.fragmentlearn.adapter.SongAdapter


class LessonFragment : BaseFragment<FragmentLessonBinding>() {

    private var songAdapter: SongAdapter? = null
    override fun getViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentLessonBinding {
        return FragmentLessonBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        initRecyclerView()
    }


    private fun initRecyclerView() {
        val listSong = mutableListOf(
            SongModel(R.drawable.ic_song_1,requireContext().getString(R.string.happy_birthday)),
            SongModel(R.drawable.ic_song_2,requireContext().getString(R.string.jingbell)),
            SongModel(R.drawable.ic_song_3,requireContext().getString(R.string.little_star)),
            SongModel(R.drawable.ic_song_4,requireContext().getString(R.string.last_christmas)),
            SongModel(R.drawable.ic_song_5,requireContext().getString(R.string.all_of_me)),
        )
        songAdapter = SongAdapter(onClickSong = {
            setSongAutoPlay(it)
        })
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rcvSong.layoutManager = linearLayoutManager

        binding.rcvSong.adapter = songAdapter

        songAdapter?.setData(listSong)


    }

    private fun setSongAutoPlay(index: Int) {
        requireActivity().config.indexSong = index
        requireActivity().setResult(101)
//        requireActivity().finish()
        val intent = Intent(requireContext(), PianoActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra(Constant.KEY_LESSON,true)
        startActivity(intent)
        requireActivity().finish()
    }

}