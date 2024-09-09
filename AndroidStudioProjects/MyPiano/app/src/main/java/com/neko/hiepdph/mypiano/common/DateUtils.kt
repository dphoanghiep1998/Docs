package com.neko.hiepdph.mypiano.common

import java.text.SimpleDateFormat

object DateUtils {
    fun convertTimeInMillisecondToTimeString(time:Long):String{
        val formatter = SimpleDateFormat("yyyy/MM/dd HH:mm a")
        return formatter.format(time).toString()
    }

    fun convertSecondToString(second:Int):String{
        val minutes = second / 60
        val remainingSeconds = second % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }
}