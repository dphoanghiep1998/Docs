package com.neko.hiepdph.mypiano.view.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseFragment
import com.neko.hiepdph.mypiano.data.model.OnboardModel
import com.neko.hiepdph.mypiano.databinding.FragmentOnboardBinding

class FragmentOnboard : BaseFragment<FragmentOnboardBinding>() {

    companion object {
        private const val POSITION_ONBOARD = "position_onboard"
        fun newInstance(position: Int) = FragmentOnboard().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ONBOARD, position)
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentOnboardBinding {
        return FragmentOnboardBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        val listData = mutableListOf(
            OnboardModel(
                getString(R.string.title_onboard_1), R.drawable.ic_onboard_1
            ),
            OnboardModel(
                getString(R.string.title_onboard_2), R.drawable.ic_onboard_2
            ),
            OnboardModel(
                getString(R.string.title_onboard_3), R.drawable.ic_onboard_3
            ),
        )
        val pos = arguments?.getInt(POSITION_ONBOARD)


        when (pos) {
            0 -> {
                binding.imvIcon.setImageResource(listData[pos].image)
                binding.tvTitle.text = listData[pos].title

            }

            1 -> {
                binding.imvIcon.setImageResource(listData[pos].image)
                binding.tvTitle.text = listData[pos].title
            }

            2 -> {
                binding.imvIcon.setImageResource(listData[pos].image)
                binding.tvTitle.text = listData[pos].title

            }
        }
    }
}