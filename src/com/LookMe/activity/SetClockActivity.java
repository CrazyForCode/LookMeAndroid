package com.LookMe.activity;

import java.util.Calendar;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

import com.LookMe.alarm.AlarmManagers;
import com.LookMe.ui.RepeatPreference;
import com.LookMe.ui.ShowTimeAlertLog;
import com.LookMe.utils.ClockIconManager;
import com.example.clockdemo.R;
import com.example.clockdemo.R.layout;
import com.example.clockdemo.R.menu;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class SetClockActivity extends PreferenceActivity implements
		OnTimeSetListener, PreferenceChangeListener, OnClickListener{
    private int hours = 1;
	private int minutes = 30;
	
	private Button btnComplete = null;
	private Button btnCancle = null;
	
	private CheckBoxPreference enableAlarm = null;
	private Preference myTime = null;
	private EditTextPreference label = null;
	private RepeatPreference repeat = null;
   
    private AlarmManager alarmm = null;
    
    //初始化
	private void initViewPreference() {
		setContentView(R.layout.activity_set_clock);
		addPreferencesFromResource(R.xml.clock_setting);

		enableAlarm = (CheckBoxPreference) this.findPreference("enable");
		repeat = (RepeatPreference) this.findPreference("repeat");
		label = (EditTextPreference) this.findPreference("label");
		myTime = (Preference)this.findPreference("time");
		
		btnComplete= (Button)this.findViewById(R.id.button1);
		btnCancle = (Button)this.findViewById(R.id.button2);
	}
	
	private void initListeners(){
	   btnComplete.setOnClickListener(this);
	   btnCancle.setOnClickListener(this);
	}
	
	//入口
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViewPreference();
        initListeners();
		alarmm = (AlarmManager)this.getSystemService(Service.ALARM_SERVICE);
	}

    //表示任何一个item被点击的时候触发事件
	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference) {
		if (preference == myTime){
			new ShowTimeAlertLog(this, this, hours, minutes);
		}
		return super.onPreferenceTreeClick(preferenceScreen, preference);
	}

	@Override
	public void preferenceChange(PreferenceChangeEvent arg0) {
		
		
	}
    
	//时间设置完成之后的回调函数
	@Override
	public void onTimeSet(TimePicker arg0, int arg1, int arg2) {
		hours = arg1;
		minutes = arg2;
		
		myTime.setSummary(hours+":"+minutes );
		enableAlarm.setEnabled(true);
	}
    
	//按钮点击之后的回调函数
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(SetClockActivity.this, MainActivity.class);
		switch(v.getId()){
		case R.id.button1:
		if (enableAlarm.isEnabled()){
			
			AlarmManagers.setAlarm(this, hours, minutes);
			ClockIconManager.setStatusBarIcon(this, true);
			startActivity(intent);
		}
		break;
		case R.id.button2:
		startActivity(intent);
		Intent i = new Intent();
		i.setAction("android.intent.action.TEST2");
		sendBroadcast(i);
	    break;
		
		default:break;
		}
	}
	
	

}
