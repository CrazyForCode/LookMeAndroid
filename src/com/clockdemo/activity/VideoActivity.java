package com.clockdemo.activity;

import com.example.clockdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity implements OnClickListener {

	private VideoView video = null;
	private ImageButton button1 = null;
	private ImageButton button2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_video);
        
        video = (VideoView)this.findViewById(R.id.my_video);
        
        
        button1 = (ImageButton)this.findViewById(R.id.button1);
        button2 = (ImageButton)this.findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }
    
    
	@Override
	public void onClick(View arg0) {
	   switch(arg0.getId()){
	   case R.id.button1:
		   Log.i("limao", "aaaaaaaaaaaaaa");
		   video.setVideoPath("android.resource://com.example.clockdemo/"+R.raw.china);
		   video.setMediaController(new MediaController(this));
	       video.requestFocus();
	       Log.i("limao", "aaaaaab");
	       break;
	   case R.id.button2:
		   video.start();
		   break;
	   default:
		   break;
	   }	
		
	   
	}
     
}
