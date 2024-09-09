package com.neko.hiepdph.mypiano.common.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.neko.hiepdph.mypiano.common.AppSharePreference

import java.util.Calendar


/**
 * Created by Thangdd
 */
object NotificationUtils {
    fun setTimeEveryDay(context: Context, hour: Int, minute: Int, type: String) {
        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = hour
        calendar[Calendar.MINUTE] = minute
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0

        scheduleAlarm(context, calendar, type, 1, hour)
    }


    private fun scheduleAlarm(
        context: Context, calendar: Calendar, type: String, dayRepeat: Int = 1, id: Int
    ) {
        val alarm = AlarmData(
            alarm_id = id, time = calendar.timeInMillis, type = type, repeat = dayRepeat
        )
        AppSharePreference.INSTANCE.saveObjectToSharePreference(type, alarm)
        scheduleAlarmManager(context, alarm)
    }


    private fun isCheckShowMorning(hour: Int, minute: Int): Boolean {
        return minute == 0 && hour == 7
    }

    private fun isCheckShowEvening(hour: Int, minute: Int): Boolean {
        return minute == 0 && hour == 20
    }

    fun runNotification(context: Context, type: String, alarmID: Int) {
        Log.d("TAG", "runNotification: " + alarmID)
        if (alarmID == 7) {
            if (!isCheckShowMorning(
                    Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                    Calendar.getInstance().get(Calendar.MINUTE)
                )
            ) return
        } else if (alarmID == 20) {
            if (!isCheckShowEvening(
                    Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                    Calendar.getInstance().get(Calendar.MINUTE)
                )
            ) {
                Log.d("TAG", "123123123: ")
                return
            }
        }

//        val indexList = AppSharePreference.INSTANCE.getListIndexNotification(arrayListOf("0"))
//        val groupLayout = listOf(
//            Pair(R.layout.layout_notification_small_1, R.layout.layout_notification_expand_1),
//            Pair(R.layout.layout_notification_small_2, R.layout.layout_notification_expand_2),
//
//            )
//        var index = 0
//
//        if (indexList[0] == "0") {
//            index = 0
//            indexList[0] = "1"
//            AppSharePreference.INSTANCE.saveListIndexNotification(indexList)
//        } else {
//            index = 1
//            indexList[0] = "0"
//            AppSharePreference.INSTANCE.saveListIndexNotification(indexList)
//        }
//
//
//        val remoteViews = RemoteViews(context.packageName, groupLayout[index].first)
//        val remoteViewsExpand = RemoteViews(context.packageName, groupLayout[index].second)
//
//        if (buildMinVersionO()) {
//            val channel = NotificationChannel(
//                Constant.CHANNEL_ID, Constant.CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
//            )
//            val manager: NotificationManager =
//                context.getSystemService(NotificationManager::class.java)
//            manager.createNotificationChannel(channel)
//        }
//        val mIntent = Intent(context.applicationContext, SplashActivity::class.java)
//        mIntent.putExtra(Constant.KEY_NOTIFY_POS, index)
//
//        val pendingIntent = PendingIntent.getActivity(
//            context,
//            (System.currentTimeMillis()/10000).toInt(),
//            mIntent,
//            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
//        )
//
//        val builder = NotificationCompat.Builder(context, Constant.CHANNEL_ID)
//        builder.setStyle(NotificationCompat.DecoratedCustomViewStyle())
//            .setCustomContentView(remoteViews).setAutoCancel(true).setShowWhen(true)
//            .setSmallIcon(R.drawable.ic_logo_black).setColor(context.getColor(R.color.black)).setWhen(System.currentTimeMillis())
//            .setCustomBigContentView(remoteViewsExpand).setContentIntent(pendingIntent)
//            .setOngoing(false).priority = NotificationCompat.PRIORITY_HIGH
//
//        val am = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        am.notify(23941, builder.build())


    }
}