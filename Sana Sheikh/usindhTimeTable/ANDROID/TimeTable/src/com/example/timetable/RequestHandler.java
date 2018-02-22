package com.example.timetable;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

public class RequestHandler {
	
	private static final String url = "http://192.168.1.3/testphp/online_time_table_uos/mobile/";
//	private static final String url = "http://timetable.stbb.edu.pk/mobile/";
	
	
	
	private static final String timetable = "timetable.php";
	private static final String adminTimetable = "timetableAdmin.php";
	
	private static List<NameValuePair> params;
	
	
	public static JSONObject sendTimeTableInfromationAdmin(String address, String program, String days_name)throws Exception{
		
		JSONParser jsonParser = new JSONParser();
		params = new ArrayList<NameValuePair>(7);
		if(program!=null)params.add(new BasicNameValuePair("program", program.toUpperCase().toString()));
		if(days_name!=null)params.add(new BasicNameValuePair("day", days_name.toUpperCase().toString()));
		if(address!=null)params.add(new BasicNameValuePair("cell_no", address));

		Log.e("Requesting to",""+(url+adminTimetable));
		System.out.println("Requesting to:"+(url+adminTimetable));
		JSONObject ob = jsonParser.makeHttpRequest(url+adminTimetable, "POST", params);
		return ob;
	}
	public static JSONObject sendTimeTableInfromation(String address, String part , String program,String group,String shift,String days_name, String teacher_name)throws Exception{
		
		JSONParser jsonParser = new JSONParser();
		params = new ArrayList<NameValuePair>(7);
		if(part!=null)params.add(new BasicNameValuePair("part", part.toUpperCase().toString()));
		if(program!=null)params.add(new BasicNameValuePair("program", program.toUpperCase().toString()));
		if(group!=null)params.add(new BasicNameValuePair("group", group.toUpperCase().toString()));
		if(shift!=null)params.add(new BasicNameValuePair("shift", shift.toUpperCase().toString()));
		if(days_name!=null)params.add(new BasicNameValuePair("day", days_name.toUpperCase().toString()));
		if(address!=null)params.add(new BasicNameValuePair("cell_no", address));
		if(teacher_name!=null)params.add(new BasicNameValuePair("teacher", teacher_name));

		Log.e("Requesting to",""+(url+timetable));
		System.out.println("Requesting to:"+(url+timetable));
		JSONObject ob = jsonParser.makeHttpRequest(url+timetable, "POST", params);
		System.out.println("got object:"+ob);
		return ob;
	}
}