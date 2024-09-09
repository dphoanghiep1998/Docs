package com.neko.hiepdph.mypiano.view.dialog

import android.content.Context
import android.graphics.drawable.ColorDrawable
import com.neko.hiepdph.mypiano.common.base_component.BaseDialog
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.DialogRecordBinding

class DialogRecord(context: Context, val onClickMic: () -> Unit, val onClickKey: () -> Unit) :
    BaseDialog<DialogRecordBinding>(context) {
    override fun getViewBinding(): DialogRecordBinding {
        return DialogRecordBinding.inflate(layoutInflater)
    }

    override fun setBackGroundDrawable() {
        window?.setBackgroundDrawable(ColorDrawable(context.getColor(android.R.color.transparent)))
    }

    override fun initView() {
        binding.root.clickWithDebounce {
            dismiss()
        }
        binding.containerMic.clickWithDebounce {
            dismiss()
            onClickMic.invoke()
        }

        binding.containerKeyboard.clickWithDebounce {
            dismiss()
            onClickKey.invoke()
        }
    }
}