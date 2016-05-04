package com.example.testapp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Seconds extends Activity implements OnClickListener{

	int second = 0, minut = 0, actionbar_item = 0;
	TextView tv_seconds, tv_minuts;
	DisplayMetrics metrics;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seconds);
		tv_seconds = (TextView) findViewById(R.id.textview_seconds);
		tv_minuts = (TextView) findViewById(R.id.textview_minuts);

		final Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Seconds.this.runOnUiThread(new Runnable() {
                    public void run() {
                    	if(actionbar_item == 1)
                    	{
                    		second = 0;
                    		minut = 0;
                    		actionbar_item = 0;
                    	}
                    	if(second >= 60)
                    	{
                    		minut++;
                    		second = 0;
                    	}
                    	tv_minuts.setText("Минут: " + (Integer.toString(minut)));
                        tv_seconds.setText(Integer.toString(second++));
                    }
                });
            }
        }, 0, 1000);
        
        
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.seconds, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.seconds_restart) {
			actionbar_item = 1;
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/*private String getScreenOrientation(){    
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
		    return "vertical";
		else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			return "horizontal";
		else
			return "";
	}*/

	@Override
	public void onClick(View v) {

	}
	
	 protected void onSaveInstanceState(Bundle outState) {
		    super.onSaveInstanceState(outState);
		    outState.putInt("seconds", second);
		    outState.putInt("minuts", minut);
		  }
	 
	 protected void onRestoreInstanceState(Bundle savedInstanceState) {
		    super.onRestoreInstanceState(savedInstanceState);
		    second = savedInstanceState.getInt("seconds");
		    minut = savedInstanceState.getInt("minuts");
		  }
	 
}
