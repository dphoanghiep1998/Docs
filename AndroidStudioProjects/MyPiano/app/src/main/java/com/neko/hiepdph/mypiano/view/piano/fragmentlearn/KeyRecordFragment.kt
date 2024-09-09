package com.neko.hiepdph.mypiano.view.piano.fragmentlearn

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.base_component.BaseFragment
import com.neko.hiepdph.mypiano.common.hide
import com.neko.hiepdph.mypiano.common.show
import com.neko.hiepdph.mypiano.data.model.KeysRecord
import com.neko.hiepdph.mypiano.databinding.FragmentKeyRecordBinding
import com.neko.hiepdph.mypiano.view.piano.PianoActivity
import com.neko.hiepdph.mypiano.view.piano.fragmentlearn.adapter.KeyRecordAdapter
import com.neko.hiepdph.mypiano.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KeyRecordFragment : BaseFragment<FragmentKeyRecordBinding>() {
    private var adapter: KeyRecordAdapter? = null
    private val viewModel by viewModels<AppViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentKeyRecordBinding {
        return FragmentKeyRecordBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        observeData()
        initRecyclerView()
    }

    private fun observeData() {
        viewModel.getListKeyRecord().observe(this) {
            if(it.isEmpty()){
                binding.icEmpty.show()
            }else{
                binding.icEmpty.hide()
            }
            adapter?.setData(it.toMutableList())
        }
    }

    private fun initRecyclerView() {
        adapter = KeyRecordAdapter(onClickItem = {
            setSongAutoPlay(it)
        }, onRename = {}, onDelete = {})

        binding.rcvKey.adapter = adapter
    }

    private fun setSongAutoPlay(item: KeysRecord) {
        val intent = Intent(requireContext(), PianoActivity::class.java)
        intent.putExtra(Constant.KEY_RECORD_KEY, item)
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT)
        startActivity(intent)
        requireActivity().finish()
    }


}