package com.LookMe.receiver;

import com.LookMe.service.ClockService;
import com.LookMe.utils.ClockIconManager;
import com.LookMe.activity.VideoActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.util.Log;

public class ClockReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
        //启动闹钟服务
		Log.i("limao", intent.getAction());
		ClockIconManager.setStatusBarIcon(context, false);
		Intent in = new Intent(context, ClockService.class);
		context.startService(in);
		}

}
