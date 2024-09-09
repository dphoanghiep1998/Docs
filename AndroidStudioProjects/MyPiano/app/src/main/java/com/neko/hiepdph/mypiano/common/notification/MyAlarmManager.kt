package com.neko.hiepdph.mypiano.common.notification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.neko.hiepdph.mypiano.common.Constant.ALARM_ID
import com.neko.hiepdph.mypiano.common.buildMinVersionM
import com.neko.hiepdph.mypiano.common.buildMinVersionS
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * Created by Thangdd
 */

fun scheduleAlarmManager(context: Context, alarm: AlarmData) {
    var newTime: Long
    if (System.currentTimeMillis() > alarm.time) {
        val oldCalender = Calendar.getInstance()
        oldCalender.time = Date(alarm.time)
        val newCalendar = Calendar.getInstance()
        newCalendar[Calendar.HOUR_OF_DAY] = oldCalender[Calendar.HOUR_OF_DAY]
        newCalendar[Calendar.MINUTE] = oldCalender[Calendar.MINUTE]
        newCalendar[Calendar.SECOND] = 0
        newCalendar[Calendar.MILLISECOND] = 0
        newTime = newCalendar.time.time + TimeUnit.DAYS.toMillis(1)
    } else {
        newTime = alarm.time
    }

    val intent = Intent(context, AlarmsReceiver::class.java)
    intent.putExtra(ALARM_ID, alarm.alarm_id)
    val alarmIntentRTC: PendingIntent = PendingIntent.getBroadcast(
        context, alarm.alarm_id, intent, PendingIntent.FLAG_IMMUTABLE
    )

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    if (buildMinVersionM()) {
        if(buildMinVersionS()){
            if (alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP, newTime, alarmIntentRTC
                )
            }else{
                alarmManager.setAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP, newTime, alarmIntentRTC
                )
            }
        }else{
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP, newTime, alarmIntentRTC
            )
        }

    } else {
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP, newTime, alarmIntentRTC
        )
    }

}



