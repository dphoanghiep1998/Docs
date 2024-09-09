package com.neko.hiepdph.mypiano.view.dialog

import android.content.Context
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseDialog
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.DialogKeyModeBinding

class DialogKeyMode(
    context: Context, val onClickDoubleKey: () -> Unit, val onClickTwoPlayer: () -> Unit
) : BaseDialog<DialogKeyModeBinding>(context, 0.5f) {
    override fun getViewBinding(): DialogKeyModeBinding {
        return DialogKeyModeBinding.inflate(layoutInflater)
    }

    override fun setBackGroundDrawable() {
        window?.setBackgroundDrawableResource(R.drawable.bg_n2_corner_40)
    }

    override fun initView() {
        binding.btnDoubleKey.clickWithDebounce {
            onClickDoubleKey.invoke()
            dismiss()
        }

        binding.btnTwoPlayer.clickWithDebounce {
            onClickTwoPlayer.invoke()
            dismiss()
        }
    }
}