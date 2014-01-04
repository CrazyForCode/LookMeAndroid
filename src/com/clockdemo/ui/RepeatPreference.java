package com.clockdemo.ui;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

public class RepeatPreference extends ListPreference{
	//设置时间选项为周一到周日
	private String[] weekends = new DateFormatSymbols().getWeekdays();
    private String[] values = {
    	  weekends[Calendar.MONDAY],
    	  weekends[Calendar.TUESDAY],
    	  weekends[Calendar.WEDNESDAY],
    	  weekends[Calendar.THURSDAY],
    	  weekends[Calendar.FRIDAY],
    	  weekends[Calendar.SATURDAY],
    	  weekends[Calendar.SUNDAY],
    };
	
	
	public RepeatPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		setEntries(values);
		setEntryValues(values);
	}

	

}
