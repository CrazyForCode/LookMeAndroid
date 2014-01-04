package com.LookMe.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ClockService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("limao","start........");
		
	}

	
	
	

}
