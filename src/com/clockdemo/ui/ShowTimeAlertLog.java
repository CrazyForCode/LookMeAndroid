package com.clockdemo.ui;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.text.format.DateFormat;

/**
 * 弹出时间选择的dialog
 * */
public class ShowTimeAlertLog {
     private TimePickerDialog log = null;
     
     public ShowTimeAlertLog(Context context, OnTimeSetListener callBack, int hourOfDay, int minute){
    	 log  = new TimePickerDialog(context, callBack, hourOfDay, minute, DateFormat.is24HourFormat(context));
         log.show();    
     }
     
     
}
