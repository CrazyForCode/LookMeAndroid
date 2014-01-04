package com.clockdemo.alarm;

import java.util.Calendar;

import com.clockdemo.activity.MainActivity;
import com.clockdemo.activity.SetClockActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class AlarmManagers {
	 private static AlarmManager alarmManager = null; 
	
	
     private static AlarmManager getAlarm(Context context){
    	 alarmManager = (AlarmManager)context.getSystemService(Service.ALARM_SERVICE);
    	 return alarmManager;
     }
     
     public static void setAlarm(Activity activity, int hours, int minutes){
    	Intent intent = new Intent();
    	intent.setAction("android.intent.action.TEST");
 		//延迟意图,就算关闭这个应用也能够执行
 		PendingIntent pi = PendingIntent.getBroadcast(activity, 0, intent, 0);
 		Log.i("limao","123123123");
// 		Calendar c = Calendar.getInstance();
// 		c.setTimeInMillis(System.currentTimeMillis());
// 		c.set(Calendar.HOUR_OF_DAY, hours);
// 		c.set(Calendar.MINUTE, minutes);
 		long triggerAtTime = SystemClock.elapsedRealtime() + 5 * 1000;
 		getAlarm(activity).set(AlarmManager.RTC_WAKEUP, triggerAtTime, pi);
 		
     }
}
