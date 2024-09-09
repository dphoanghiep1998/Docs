package com.neko.hiepdph.mypiano.common.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.common.notification.NotificationUtils


class TimeChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        NotificationUtils.setTimeEveryDay(
            context,
            20,
            0,
            Constant.NOTI_EVERYDAY_EVENING
        )
    }

}
