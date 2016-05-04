package com.example.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity implements OnClickListener{
	  
	  String[] data = {"Секундомер", "другое...", "другое..."};
	  Button btn_goto_act;
	  String act_chosen = "";
	  int position_in_spinner;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        btn_goto_act = (Button) findViewById(R.id.btn_to_act);
	        btn_goto_act.setOnClickListener(this);
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        Spinner spinner = (Spinner) findViewById(R.id.spinner);
	        spinner.setAdapter(adapter);
	        spinner.setPrompt("Title"); 
	        spinner.setSelection(0);
	        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
	      @Override
	      public void onItemSelected(AdapterView<?> parent, View view,
	          int position, long id) {
	    	  position_in_spinner = position;
	      }

	      
	      @Override
	      public void onNothingSelected(AdapterView<?> arg0) {
	      }
	    });
	    }

	    
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.btn_to_act:
				if(position_in_spinner == 0)
				{
				Intent intent = new Intent(this, Seconds.class);
			    startActivity(intent);
				}
				break;
			default:
				break;
			}
		}
	}
