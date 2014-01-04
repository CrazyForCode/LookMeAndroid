package com.LookMe.utils;

import android.content.Context;
import android.content.Intent;

public class ClockIconManager {
	
	   //显示闹钟图标
		public static void setStatusBarIcon(Context context, boolean enabled) {
	        Intent alarmChanged = new Intent("android.intent.action.ALARM_CHANGED");
	        alarmChanged.putExtra("alarmSet", enabled);
	        context.sendBroadcast(alarmChanged);
	    }
}
