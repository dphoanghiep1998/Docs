package com.neko.hiepdph.mypiano.common.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

class BackgroundGradient @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?= null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private val paint = Paint()
    private val paint1 = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }
    private var gradient: LinearGradient ?= null
    private val rectF = RectF()
    private val rectFIn = RectF()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        gradient = LinearGradient(
            0f, 0f, width.toFloat(), height.toFloat(),  // From top-left to bottom-right
            Color.parseColor("#F46700"),  // Start color (pink)
            Color.parseColor("#FF00D6"),  // End color (blue)
            Shader.TileMode.CLAMP
        )
        paint.setShader(gradient)
        rectF.set(0F, 0F, width.toFloat(), height.toFloat())
        rectFIn.set(3F, 3F, width.toFloat() - 3, height.toFloat() - 3)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        gradient = LinearGradient(
            0f, 0f, width.toFloat(), height.toFloat(),  // From top-left to bottom-right
            Color.parseColor("#F46700"),  // Start color (pink)
            Color.parseColor("#FF00D6"),  // End color (blue)
            Shader.TileMode.CLAMP
        )
        paint.setShader(gradient)
        rectF.set(0F, 0F, width.toFloat(), height.toFloat())
        rectFIn.set(3F, 3F, width.toFloat() - 3, height.toFloat() - 3)
        canvas.drawRoundRect(rectF, toPx(12), toPx(12), paint)
        canvas.drawRoundRect(rectFIn, toPx(12), toPx(12), paint1)
    }
    fun toPx(dp: Int): Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        resources.displayMetrics)
}