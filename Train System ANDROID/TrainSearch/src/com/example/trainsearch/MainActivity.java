package com.example.trainsearch;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.CityBean;
import beans.TrainBean;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeAllVariables();
		addActionListenerToAll();
		RequestHandler.setTrains(train,this);
	}

	private void addActionListenerToAll() {
		// TODO Auto-generated method stub
		train.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//				TrainBean bean = (TrainBean)parent.getItemAtPosition(pos);
//				Toast.makeText(getApplicationContext(), selTrain, Toast.LENGTH_LONG).show();
				RequestHandler.setCityFrom(cityFrom, MainActivity.this);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		cityFrom.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				RequestHandler.setCityTo(cityTo,MainActivity.this);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}});
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				initBundle();
				searchResult.putExtras(bundle);
				startActivity(searchResult);
			}
		});
	}
	private void initBundle(){
		TrainBean trainBean = (TrainBean)train.getSelectedItem();
		CityBean cityBeanFrom = (CityBean)cityFrom.getSelectedItem();
		CityBean cityBeanTo = (CityBean)cityTo.getSelectedItem();
		bundle = new Bundle();
		
		bundle.putString("train_id", ""+trainBean.getTrain_id());
		bundle.putString("city_from", ""+cityBeanFrom.getJunction_no());
		bundle.putString("city_to", ""+cityBeanTo.getJunction_no());
		String d = date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDayOfMonth();
		bundle.putString("date", d);
	}
	private void initializeAllVariables() {
		// TODO Auto-generated method stub
		cityFrom = (Spinner)findViewById(R.id.city_from_spinner);
		train = (Spinner)findViewById(R.id.spinner_train);
		cityTo = (Spinner)findViewById(R.id.city_to_spinner);
		search = (Button)findViewById(R.id.buttonSearch);
		date = (DatePicker)findViewById(R.id.datePicker1);
		searchResult = new Intent("com.example.trainsearch.ACTIVITY_RESULT");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public Spinner getTrainSpinner(){
		return this.train;
	}
	public Spinner getCityFromSpinner(){
		return cityFrom;
	}
	public Spinner getCityToSpinner(){
		return cityTo;
	}
	
	public static Activity session;
	private Spinner cityFrom;
	private Spinner train;
	private Spinner cityTo;
	private Button search;
	private Bundle bundle;
	private DatePicker date;
	private Intent searchResult;

}