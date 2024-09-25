package com.neko.hiepdph.mypiano.view.dialog

import android.content.Context
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseDialog
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.DialogRequestPerBinding

class DialogRequestPermission(context: Context, val onClickGrant: () -> Unit, val index: Int = 0) :
    BaseDialog<DialogRequestPerBinding>(context, 0.5f) {
    override fun getViewBinding(): DialogRequestPerBinding {
        return DialogRequestPerBinding.inflate(layoutInflater)
    }

    override fun setBackGroundDrawable() {
        window?.setBackgroundDrawableResource(R.drawable.bg_n2_corner_12)
    }

    override fun initView() {
        if (index == 0) {
            binding.containerName.text = context.getText(R.string.rq_per)
        }
        if (index == 1) {
            binding.containerName.text = context.getText(R.string.rq_per_read_ex)
        }
        if (index == 2) {
            binding.containerName.text = context.getText(R.string.rq_per_read_au)

        }
        binding.btnCancel.clickWithDebounce {
            dismiss()
        }

        binding.btnGrant.clickWithDebounce {
            onClickGrant.invoke()
        }
    }
}