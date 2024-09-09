package com.neko.hiepdph.mypiano.view.dialog

import android.content.Context
import android.widget.Toast
import com.neko.hiepdph.mypiano.R
import com.neko.hiepdph.mypiano.common.base_component.BaseDialog
import com.neko.hiepdph.mypiano.common.clickWithDebounce
import com.neko.hiepdph.mypiano.databinding.DialogSaveFileBinding

class DialogSaveFile(
    val mContext: Context,
    val onSaveFile: (text: String) -> Unit,
    val onCancelFile: () -> Unit,
    val name: String
) : BaseDialog<DialogSaveFileBinding>(mContext, 0.4f) {
    override fun getViewBinding(): DialogSaveFileBinding {
        return DialogSaveFileBinding.inflate(layoutInflater)
    }

    override fun setBackGroundDrawable() {
        window?.setBackgroundDrawableResource(R.drawable.bg_n2_corner_12)
    }

    override fun initView() {
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        binding.edtName.setText(name)
        binding.btnSave.clickWithDebounce {
            if (binding.btnSave.text.toString().isNotEmpty()) {
                onSaveFile.invoke(binding.edtName.text.toString())
            } else {
                Toast.makeText(
                    mContext,
                    mContext.getString(R.string.name_is_not_empty),
                    Toast.LENGTH_SHORT
                ).show()
            }
            dismiss()
        }

        binding.btnCancel.clickWithDebounce {
            onCancelFile.invoke()
            dismiss()
        }
    }
}