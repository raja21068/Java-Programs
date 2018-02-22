package com.example.timetable;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class SmsSender {

	 public static void sendSMS(String phoneNumber, String message) {
	        //String phoneNo = "0123456789";
	        //String message = "Hello World!";

	        SmsManager smsManager = SmsManager.getDefault();
	        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
	        System.out.println("SMS SENT....!");
	    }


	    public  static void sendLongSMS(EditText phoneNumber, EditText message,Context c ) {    	 
	        //String phoneNo = "0123456789";
	        //String message = "Hello World! Now we are going to demonstrate how to send a message with more than 160 characters from your Android application.";

	        SmsManager smsManager = SmsManager.getDefault();
	        ArrayList<String> parts = smsManager.divideMessage(message.getText().toString()); 
	        smsManager.sendMultipartTextMessage(phoneNumber.getText().toString(), null, parts, null, null);
	        
	        Toast.makeText(c, "Message Sent!", Toast.LENGTH_LONG).show();
	    }
	    
	    public static void sendLongSMS(String phoneNumber, String message)throws Exception{    	 
	        //String phoneNo = "0123456789";
	        //String message = "Hello World! Now we are going to demonstrate how to send a message with more than 160 characters from your Android application.";
	    	System.out.println("check point 1");
	    	SmsManager smsManager = SmsManager.getDefault();
	    	System.out.println("check point 2");
	    	ArrayList<String> parts = smsManager.divideMessage(message); 
	    	System.out.println("check point 3");
	    	smsManager.sendMultipartTextMessage(phoneNumber, null, parts, null, null);
	    	System.out.println("SMS Sent");
	    }

	    
	    public  static void saveInSent(EditText message,EditText phoneNumber,ContentResolver c) {
	    	ContentValues values = new ContentValues(); 
	        
	        values.put("address", phoneNumber.getText().toString()); 
	                  
	        values.put("body", message.getText().toString()); 
	             
	        c.insert(Uri.parse("content://sms/sent"), values);
	    }        
	    
}
