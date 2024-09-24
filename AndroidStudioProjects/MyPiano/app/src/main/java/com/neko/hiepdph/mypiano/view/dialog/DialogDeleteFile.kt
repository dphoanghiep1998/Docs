package com.neko.hiepdph.mypiano.view.dialog

import android.content.Context
import android.widget.Toast
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseDialog
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.DialogDeleteFileBinding
import com.neko.hiepdph.mypiano.databinding.DialogSaveFileBinding

class DialogDeleteFile(
    val mContext: Context,
    val onDelete: () -> Unit,
) : BaseDialog<DialogDeleteFileBinding>(mContext, 0.4f) {
    override fun getViewBinding(): DialogDeleteFileBinding {
        return DialogDeleteFileBinding.inflate(layoutInflater)
    }

    override fun setBackGroundDrawable() {
        window?.setBackgroundDrawableResource(R.drawable.bg_n2_corner_12)
    }

    override fun initView() {
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        binding.btnDelete.clickWithDebounce {
            onDelete.invoke()
            dismiss()
        }

        binding.btnCancel.clickWithDebounce {
            dismiss()
        }
    }
}