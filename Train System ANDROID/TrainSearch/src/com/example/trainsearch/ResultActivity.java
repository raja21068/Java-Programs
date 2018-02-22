package com.example.trainsearch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ResultActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		this.bundle = getIntent().getExtras();
		ListView list = (ListView)findViewById(R.id.train_data);
		RequestHandler.setResult(list,this);
	}
	public Bundle getBundle(){
		return this.bundle;
	}
	
	private Bundle bundle;
}
