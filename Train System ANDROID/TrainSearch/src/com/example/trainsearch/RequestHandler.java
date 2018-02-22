package com.example.trainsearch;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import beans.CityBean;
import beans.TrainBean;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class RequestHandler {
	Spinner train;
	private static final String url = "http://192.168.1.3/train_management/get_androids/";

    public static void setTrains(Spinner train, MainActivity parent){
    	new RequestHandler.SetTrains(train, parent).execute();
    }
    public static void setCityFrom(Spinner cityFrom, MainActivity parent){
    	new SetCityFrom(cityFrom, parent).execute();
    }
    public static void setCityTo(Spinner cityTo, MainActivity parent){
    	new SetCityTo(cityTo, parent).execute();
    }
	public static void setResult(ListView list, ResultActivity parent) {
    	new SetResult(list, parent).execute();
	}
//    public void setBogies(Spinner bogies){
//    	new SetBogies().execute();
//    }
    private static class SetTrains extends AsyncTask<Void, Void, JSONObject>{
    	Spinner train;
    	MainActivity parent;
    	public SetTrains(Spinner train, MainActivity parent){
    		this.train = train;
    		this.parent = parent;
    	}
		@Override
		protected JSONObject doInBackground(Void... params) {
			try{
			JSONParser parser = new JSONParser();
			ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>(2);
			JSONObject ob = parser.makeHttpRequest(url+"get_android_trains.php", "GET", params1);
			return ob;
			}
			catch(Exception ex){
				Log.e("trainsearch", "error while req");
				ex.printStackTrace();
			return null;
			}
		}
		
		@Override
		protected void onPostExecute(JSONObject ob) {
			System.out.println(">>>"+ob);
			ArrayList<TrainBean> v = new ArrayList<TrainBean>();
			for (int i = 0; i<ob.length(); i++){
				try {
					JSONObject o = ob.getJSONObject("a"+i);
					TrainBean bean = new TrainBean();
					bean.setTrainId(o.getInt("train_id"));
					bean.setTrainName(o.getString("train_name"));
					bean.setRemarks(o.getString("remarks"));
					v.add(bean);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			train.setAdapter(new ArrayAdapter(parent.getApplicationContext(), android.R.layout.simple_spinner_item, v.toArray() ));
		}
		
	}
    private static class SetCityFrom extends AsyncTask<Void, Void, JSONObject>{
    	Spinner cityFrom;
    	MainActivity parent;
		public SetCityFrom(Spinner cityFrom, MainActivity parent) {
			this.cityFrom = cityFrom;
			this.parent = parent;
		}
		@Override
		protected JSONObject doInBackground(Void... arg0) {
			TrainBean bean = (TrainBean)parent.getTrainSpinner().getSelectedItem();
//			System.out.println("arg0 >>> "+ bean.getTrain_name());
			try{
			JSONParser parser = new JSONParser();
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>(1);
			params.add(new BasicNameValuePair("train_id", ""+bean.getTrain_id()));
			JSONObject ob = parser.makeHttpRequest(url+"get_android_city_from.php", "POST", params);
//			System.out.println(">>cityfrom>>"+ob);
			return ob;
			}
			catch(Exception ex){
				Log.e("trainsearch", "error while req");
				ex.printStackTrace();
			return null;
			}
		}
		@Override
		protected void onPostExecute(JSONObject ob){
			ArrayList<CityBean> list = new ArrayList<CityBean>();
			for (int i = 0; i<ob.length(); i++){
				try {
					JSONObject o = ob.getJSONObject("a"+i);
					CityBean bean = new CityBean();
					bean.setJunction_no(o.getInt("_from"));
					bean.setCity(o.getString("city_from"));
					System.out.print("city: "+bean.getCity());
					System.out.println(" ; junction: "+bean.getJunction_no());
					list.add(bean);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			cityFrom.setAdapter(new ArrayAdapter(parent.getApplicationContext(), android.R.layout.simple_spinner_item, list.toArray() ));
		}

		
	}
    private static class SetCityTo extends AsyncTask<Void, Void, JSONObject>{
    	Spinner cityTo;
    	MainActivity parent;
    	public SetCityTo(Spinner cityTo, MainActivity parent) {
			this.cityTo = cityTo;
			this.parent = parent;
		}
		@Override
		protected JSONObject doInBackground(Void... arg0) {
			TrainBean trainBean = (TrainBean)parent.getTrainSpinner().getSelectedItem();
			CityBean  cityBean = (CityBean)parent.getCityFromSpinner().getSelectedItem();
//			System.out.println("arg0 >>> "+ bean.getTrain_name());
			try{
			JSONParser parser = new JSONParser();
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>(2);
			params.add(new BasicNameValuePair("train_id", ""+trainBean.getTrain_id()));
			params.add(new BasicNameValuePair("city_from",""+cityBean.getJunction_no()));
			System.out.println("train_id "+trainBean.getTrain_id());
			System.out.println("city_from "+cityBean.getJunction_no());
			JSONObject ob = parser.makeHttpRequest(url+"get_android_city_to.php", "POST", params);
			return ob;
			}
			catch(Exception ex){
				Log.e("trainsearch", "error while req");
				ex.printStackTrace();
			return null;
			}
		}
		@Override
		protected void onPostExecute(JSONObject ob){
			ArrayList<CityBean> v = new ArrayList<CityBean>();
			for (int i = 0; i<ob.length(); i++){
				try {
					JSONObject o = ob.getJSONObject("a"+i);
					CityBean bean = new CityBean();
					bean.setJunction_no(o.getInt("_to"));
					bean.setCity(o.getString("city_to"));
					System.out.print("city: "+bean.getCity());
					System.out.println(" ; junction: "+bean.getJunction_no());
					v.add(bean);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			cityTo.setAdapter(new ArrayAdapter(parent.getApplicationContext(), android.R.layout.simple_spinner_item, v.toArray() ));
		}
    }
	    private static class SetResult extends AsyncTask<Void, Void, JSONObject>{
	    	ListView list;
	    	ResultActivity parent;
	    	public SetResult(ListView list, ResultActivity parent) {
				this.list = list;
				this.parent = parent;
			}
			@Override
			protected JSONObject doInBackground(Void... arg0) {
				Bundle bundle = parent.getBundle();
				String train_id = bundle.getString("train_id");
				String city_from = bundle.getString("city_from");
				String city_to = bundle.getString("city_to");
				String date = bundle.getString("date");
				try{
				JSONParser parser = new JSONParser();
				ArrayList<NameValuePair> params = new ArrayList<NameValuePair>(4);
				params.add(new BasicNameValuePair("train_id", train_id));
				params.add(new BasicNameValuePair("from",city_from));
				params.add(new BasicNameValuePair("to",city_to));
				params.add(new BasicNameValuePair("date",date));
				JSONObject jsonOb = parser.makeHttpRequest(url+"get_android_result_2.php", "POST", params);
				System.out.println(">>>>>>>>"+jsonOb);
				return jsonOb;
				}
				catch(Exception ex){
					Log.e("trainsearch", "error while req");
					ex.printStackTrace();
				return null;
				}
			}
			@Override
			protected void onPostExecute(JSONObject ob){
//				System.out.println(">>>>>>>>"+jsonOb);
				ArrayAdapter adapter = new ArrayAdapter(parent, android.R.layout.simple_list_item_1);
				for (int i = 1; i<=ob.length(); i++){
					try {
						JSONObject o = ob.getJSONObject("a"+i);
						String bogieName = o.getString("bogie_name");
						String from = o.getString("from");
						String to = o.getString("to");
						String seats = o.getString("seat");
						String birth = o.getString("birth");
						String detail = "Bogie Name: \n\t"+bogieName+"\n";
						detail += "From: \n\t"+from+"\n";
						detail += "To: \n\t"+to+"\n";
						detail += "Seats: \n\t"+seats+"\n";
						detail += "Births: \n\t"+birth+"\n";
						adapter.add(detail);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				list.setAdapter(adapter);
			}
	}
//    private static class SetBogies extends AsyncTask<Void, Void, JSONObject>{
//
//		@Override
//		protected JSONObject doInBackground(Void... params) {
//			// TODO Auto-generated method stub
//			return null;
//		}}
}
