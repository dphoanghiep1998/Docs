package com.neko.hiepdph.mypiano.common

import android.content.Context
import android.graphics.drawable.ScaleDrawable
import android.graphics.drawable.StateListDrawable
import android.util.Log
import android.view.Gravity
import androidx.core.content.ContextCompat
import com.neko.hiepdph.mypiano.data.model.PianoStyleModel

object FastUtils {
    fun getWidthScreen(context: Context): Int {
        return context.resources.displayMetrics.widthPixels.coerceAtMost(context.resources.displayMetrics.heightPixels)
    }

    fun getHeightScreen(context: Context): Int {
        return context.resources.displayMetrics.widthPixels.coerceAtLeast(context.resources.displayMetrics.heightPixels)
    }

    fun formatTime(seconds: Int): String {
        val minutes = seconds / 60
        val sec = seconds % 60
        return String.format("%02d:%02d", minutes, sec)
    }

    fun getStyle(context: Context, index: Int, scaleX: Float, scaleY: Float): PianoStyleModel? {
        val listOfWhite = mutableListOf<StateListDrawable>()
        var nIndex = 0
        when (index) {
            0 -> {
                for (i in 1..7) {
                    listOfWhite.add(
                        getStateListDrawableKey(
                            context,
                            getDrawableFromResources(context, "ic_white_piano_up"),
                            getDrawableFromResources(context, "ic_white_piano_down"),
                            scaleX,
                            scaleY
                        )
                    )


                }

                val black = getStateListDrawableKey(
                    context,
                    getDrawableFromResources(context, "ic_black_piano_up"),
                    getDrawableFromResources(context, "ic_black_piano_down"),
                    scaleX,
                    scaleY
                )
                return PianoStyleModel(listOfWhite, black)
            }

            1 -> {
                nIndex = 1
            }

            2 -> {
                nIndex = 2
            }

            3 -> {
                nIndex = 3
            }

            4 -> {
                nIndex = 4
            }

            5 -> {
                nIndex = 5
            }

            6 -> {
                nIndex = 6
            }

            7 -> {
                nIndex = 7
            }

            8 -> {
                nIndex = 8
            }

            9 -> {
                nIndex = 9
            }

            10 -> {
                nIndex = 36
            }

            11 -> {
                nIndex = 10
            }

            12 -> {
                nIndex = 11
            }

            13 -> {
                nIndex = 12
            }

            14 -> {
                nIndex = 13
            }

            15 -> {
                nIndex = 14
            }

            16 -> {
                nIndex = 15
            }

            17 -> {
                nIndex = 16
            }

            18 -> {
                nIndex = 17
            }

            19 -> {
                nIndex = 18
            }

            20 -> {
                nIndex = 19
            }

            21 -> {
                nIndex = 20
            }

            22 -> {
                nIndex = 21
            }

            23 -> {
                nIndex = 22
            }

            24 -> {
                nIndex = 23
            }

            25 -> {
                nIndex = 24
            }

            26 -> {
                nIndex = 25
            }

            27 -> {
                nIndex = 26
            }

            28 -> {
                nIndex = 27
            }

            29 -> {
                nIndex = 28
            }

            30 -> {
                nIndex = 29
            }

            31 -> {
                nIndex = 30
            }

            32 -> {
                nIndex = 31
            }

            33 -> {
                nIndex = 32
            }

            34 -> {
                nIndex = 33
            }

            35 -> {
                nIndex = 34
            }

            36 -> {
                nIndex = 35
            }

            37 -> {
                nIndex = 37
            }

            38 -> {
                nIndex = 38
            }

        }
        if (nIndex != 14 && nIndex != 15 && nIndex != 16) {
            for (i in 1..7) {
                listOfWhite.add(
                    getStateListDrawableKey(
                        context,
                        getDrawableFromResources(context, "ic_white_${i}_style_${nIndex}_up"),
                        getDrawableFromResources(context, "ic_white_style_${nIndex}_down"),
                        scaleX,
                        scaleY
                    )
                )
            }

            val black = getStateListDrawableKey(
                context,
                getDrawableFromResources(context, "ic_black_style_${nIndex}_up"),
                getDrawableFromResources(context, "ic_black_style_${nIndex}_down"),
                scaleX,
                scaleY
            )
            return PianoStyleModel(listOfWhite, black)

        } else {
            for (i in 1..7) {
                listOfWhite.add(
                    getStateListDrawableKey(
                        context,
                        getDrawableFromResources(context, "ic_white_style_${nIndex}_up"),
                        getDrawableFromResources(context, "ic_white_style_${nIndex}_down"),
                        scaleX,
                        scaleY
                    )
                )
            }

            val black = getStateListDrawableKey(
                context,
                getDrawableFromResources(context, "ic_black_style_${nIndex}_up"),
                getDrawableFromResources(context, "ic_black_style_${nIndex}_down"),
                scaleX,
                scaleY
            )
            return PianoStyleModel(listOfWhite, black)
        }


    }

    private fun getDrawableFromResources(context: Context, drawableName: String): Int {
        return context.resources.getIdentifier(drawableName, "drawable", context.packageName)
    }

    private fun getStateListDrawableKey(
        context: Context, keyDrawableUp: Int, keyDrawableDown: Int, scaleX: Float, scaleY: Float
    ): StateListDrawable {
        val res = StateListDrawable()
        res.addState(
            intArrayOf(android.R.attr.state_pressed), ScaleDrawable(
                ContextCompat.getDrawable(context, keyDrawableDown),
                Gravity.NO_GRAVITY,
                scaleX,
                scaleY
            ).drawable
        )
        res.addState(
            intArrayOf(), ScaleDrawable(
                ContextCompat.getDrawable(context, keyDrawableUp),
                Gravity.NO_GRAVITY,
                scaleX,
                scaleY
            ).drawable
        )
        return res
    }
}