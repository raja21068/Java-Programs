package com.example.timetable;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver 
{
	// All available column names in SMS table
    // [_id, thread_id, address, 
	// person, date, protocol, read, 
	// status, type, reply_path_present, 
	// subject, body, service_center, 
	// locked, error_code, seen]
	String body ="";
	String address ="";
    
	public static final String SMS_EXTRA_NAME = "pdus";
	public static final String SMS_URI = "content://sms";
	
	public static final String ADDRESS = "address";
    public static final String PERSON = "person";
    public static final String DATE = "date";
    public static final String READ = "read";
    public static final String STATUS = "status";
    public static final String TYPE = "type";
    public static final String BODY = "body";
    public static final String SEEN = "seen";
    
    public static final int MESSAGE_TYPE_INBOX = 1;
    public static final int MESSAGE_TYPE_SENT = 2;
    
    public static final int MESSAGE_IS_NOT_READ = 0;
    public static final int MESSAGE_IS_READ = 1;
    
    public static final int MESSAGE_IS_NOT_SEEN = 0;
    public static final int MESSAGE_IS_SEEN = 1;
	
    // Change the password here or give a user possibility to change it
    public static final byte[] PASSWORD = new byte[]{ 0x20, 0x32, 0x34, 0x47, (byte) 0x84, 0x33, 0x58 };
    
	public void onReceive( Context context, Intent intent ) 
	{

		synchronized (intent) {	
    	LocationManager manager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    	
    	PendingIntent launchIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
    	
    	
    	
    	
		// Get SMS map from Intent
        Bundle extras = intent.getExtras();
        
        String messages = "";
        
        if ( extras != null )
        {
            // Get received SMS array
            Object[] smsExtra = (Object[]) extras.get( SMS_EXTRA_NAME );
            
            // Get ContentResolver object for pushing encrypted SMS to incoming folder
            ContentResolver contentResolver = context.getContentResolver();
            
            for ( int i = 0; i < smsExtra.length; ++i )
            {
            	SmsMessage sms = SmsMessage.createFromPdu((byte[])smsExtra[i]);
            	
            	 body = sms.getMessageBody().toString();
            	 address = sms.getOriginatingAddress();
                
                messages += "SMS from " + address + " :\n";                    
                messages += body + "\n";
                
                // Here you can add any your code to work with incoming SMS
                // I added encrypting of all received SMS 
                
            }
            //Send SMS to client 
           
            try{
            	//Toast.makeText(context, address+":"+address.length(), Toast.LENGTH_LONG).show();
            	if(address.length()<10){
            		return;
            	}
            	String data[] = body.split(" ");
            	//Toast.makeText(context, "data[0] "+data[0]+"\ndata[1] "+data[1], Toast.LENGTH_LONG).show();
            		if(data.length == 2){
            			String department_code = data[0];
            			String days_name = data[1];
            			Log.e("department_code",""+department_code);
            			Log.e("days_name",""+days_name);
            			new TimeTableInformationProcessAdmin(address, department_code, days_name).execute();

            		}
            		if(data.length == 3){
            			String department_code = data[0];
            			String days_name = data[1];
            			String teacher_name = data[2];

            			Log.e("teacher_name",""+teacher_name);
            			Log.e("department_code",""+department_code);
            			Log.e("days_name",""+days_name);
            			
            			new TimeTableInformationProcess(address, null, department_code, null, null, days_name, teacher_name).execute();
            		}
            		if(data.length>=4){
            			String department_code= data[0];
            			String days_name= data[1];
            			String part= data[2];
            			String shift= data[3];
            		if(data.length>=5){
            			String group= data[4];
            			Log.e("batch_year",""+part);
            			Log.e("department_code",""+department_code);
            			Log.e("group",""+group);
            			Log.e("shift",""+shift);
            			Log.e("days_name",""+days_name);
            			new TimeTableInformationProcess(address, part, department_code, group, shift, days_name, null).execute();
            		}
            		else{
            			Log.e("batch_year",""+part);
            			Log.e("department_code",""+department_code);
            			Log.e("shift",""+shift);
            			Log.e("days_name",""+days_name);
            			new TimeTableInformationProcess(address, part, department_code, null, shift, days_name, null).execute();
            			
            		}
            		}
            	
            	
         //       Toast.makeText( context, messages, Toast.LENGTH_SHORT ).show();
            	  }catch(Exception ex){
            	ex.printStackTrace();
            }
        }
        }
        
        // WARNING!!! 
        // If you uncomment next line then received SMS will not be put to incoming.
        // Be careful!
        // this.abortBroadcast(); 
	}
	private class TimeTableInformationProcessAdmin extends AsyncTask<Void, Void,JSONObject>{
		String department_code, days_name ,address;
		TimeTableInformationProcessAdmin(String address, String department_code,String days_name){
			this.department_code=department_code;
			this.days_name=days_name;
			this.address=address;
			
		}
		@Override
		protected JSONObject doInBackground(Void... arg0) {
		//	
			JSONObject ob = null;
			try{
				
				System.out.println("Department Code:"+department_code);
				System.out.println("Day Name:"+days_name);
				
				ob=RequestHandler.sendTimeTableInfromationAdmin(address, department_code,  days_name);
				
				System.out.println("Message Information: "+ob);

				if (ob !=null){
						String cellno= ob.getString("cell_no");
						String message= ob.getString("message");
						SmsSender.sendLongSMS(cellno,message);
						Thread.sleep(2000);
						ob=null;
				}
				ob=null;
				return null;
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			return null;
		}	
}		
	private class TimeTableInformationProcess extends AsyncTask<Void, Void,JSONObject>{
		String batch_year , department_code, group,shift, days_name ,address, teacher_name;
		TimeTableInformationProcess(String address,String batch_year , String department_code,String group,String shift,String days_name, String teacher_name){
			this.batch_year =batch_year;
			this.department_code=department_code;
			this.group=group;
			this.shift=shift;
			this.days_name=days_name;
			this.address=address;
			this.teacher_name = teacher_name;
			
		}
		@Override
		protected JSONObject doInBackground(Void... arg0) {
		//	
			JSONObject ob = null;
			try{
				
				System.out.println("Batch Year :"+batch_year);
				System.out.println("Department Code:"+department_code);
				System.out.println("Group:"+group);
				System.out.println("Shift:"+shift);
				System.out.println("Day Name:"+days_name);
				System.out.println("Teacher Name:"+teacher_name);
				
				ob=RequestHandler.sendTimeTableInfromation(address,batch_year, department_code, group, shift, days_name, teacher_name);
				
				System.out.println(">>Message Information: "+ob);

				if (ob !=null){
					System.out.println(">>Message not null: ");
					String cellno= ob.getString("cell_no");
					System.out.println(">>Cell:"+cellno);
					String message= ob.getString("message");
					System.out.println(">>M:"+message);
					SmsSender.sendLongSMS(cellno,message);
						
				}

				return ob;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			return null;
		}	
}		
}