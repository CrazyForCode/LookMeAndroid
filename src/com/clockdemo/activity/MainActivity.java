package com.clockdemo.activity;

import com.example.clockdemo.R;
import com.special.ResideMenu.menu.ResideMenu;
import com.special.ResideMenu.menu.ResideMenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	// 用于拿到sharedprefrence对象
	private static final String PRENFRENCE = "AlarmClock";

	private Button addClock = null;
	private ListView clockListView = null;

	private SharedPreferences pre = null;
	private Cursor preCursor = null;
	
	private ResideMenu menu = null;
	private String[] titles = {"home","1","2","3"};

	// 初始化视图
	private void initView() {
		menu = new ResideMenu(this);
		menu.setBackground(R.drawable.menu_background);
		menu.attachToActivity(this);
		
		for (int i = 0 ; i < titles.length ; i++){
			ResideMenuItem item = new ResideMenuItem(this,titles[i]);
			menu.addMenuItem(item);
		}
		setContentView(R.layout.activity_main);
		addClock = (Button) this.findViewById(R.id.add_clock_btn);
		clockListView = (ListView) this.findViewById(R.id.clock_listview);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initListener();

		pre = getSharedPreferences(PRENFRENCE, 0);

	}

	private void initListener() {
		// 进入闹钟添加页面
		addClock.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this,
						SetClockActivity.class));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return menu.onInterceptTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

}
