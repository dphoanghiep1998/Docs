package com.neko.hiepdph.mypiano.common.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.neko.hiepdph.mypiano.common.AppSharePreference
import com.neko.hiepdph.mypiano.common.Constant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Thangdd
 */
class AlarmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        startAlarm(intent, context)
        refreshAlarms(intent, context)
    }


    private fun getAlarmEverydayEvening(): AlarmData? {
        return AppSharePreference.INSTANCE.getObjectFromSharePreference<AlarmData>(
            Constant.NOTI_EVERYDAY_EVENING
        )
    }

    private fun refreshAlarms(intent: Intent?, context: Context) {
        val id = intent?.getIntExtra(Constant.ALARM_ID, -1)
        CoroutineScope(Dispatchers.IO).launch {
            CoroutineScope(Dispatchers.Main).launch {
                when (id) {
                    20 -> {
                        getAlarmEverydayEvening()?.let { scheduleAlarmManager(context, it) }
                    }
                }
            }
        }
    }



    private fun startAlarm(intent: Intent?, context: Context) {
        CoroutineScope(Dispatchers.Main).launch {
            val id = intent?.getIntExtra(Constant.ALARM_ID, -1)
            var alarm: AlarmData? = null
            when (id) {
                20 -> {
                    Log.d("TAG", "startAlarm: "+20)
                    alarm = getAlarmEverydayEvening()
                }
            }

            alarm?.let {
                NotificationUtils.runNotification(
                    context,
                    alarm.type,
                    it.alarm_id
                )
            }
        }

    }




}
