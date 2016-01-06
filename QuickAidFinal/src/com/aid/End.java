package com.aid;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.*;
import android.text.format.DateFormat;

public class End extends Activity{
	
    Button btnSendSMS;
    EditText txtPhoneNo;
    EditText txtMessage;
  
   public String str;
    private BroadcastReceiver sendBroadcastReceiver;
    private BroadcastReceiver deliveryBroadcastReciever;
    public String SENT = "SMS_SENT";
    public String DELIVERED = "SMS_DELIVERED";

  
    public EditText Details;
  
   
    public String user;
    
  

 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        Details = (EditText)findViewById(R.id.details);
        btnSendSMS = (Button) findViewById(R.id.btnSend);
        Bundle b=this.getIntent().getExtras();
        final String email=b.getString("keym");
        final String pno=b.getString("keys");
        ImageButton btn1=(ImageButton) findViewById(R.id.home);
        btn1.setOnClickListener(new OnClickListener(){
        	public void onClick(View v)
        	{
        		Intent in=new Intent(End.this, Service.class);
        		startActivity(in);
        		 MediaPlayer mp = MediaPlayer.create(End.this, R.raw.mysound);   
                 mp.start();
                 mp.setOnCompletionListener(new OnCompletionListener() {

                     @Override
                     public void onCompletion(MediaPlayer mp) {
                         // TODO Auto-generated method stub
                         mp.release();
                     }
                 
           
       });
        	}
        });
     
      ImageButton btn2=(ImageButton) findViewById(R.id.back);
        btn2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v)
        	{
        		Intent in= new Intent(End.this, Operation.class);
        		startActivity(in);
        		MediaPlayer mp = MediaPlayer.create(End.this, R.raw.mysound);   
                mp.start();
                mp.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        // TODO Auto-generated method stub
                        mp.release();
                    }
                
          
      });
        	}
        });
     
        sendBroadcastReceiver = new BroadcastReceiver()
        {

            public void onReceive(Context arg0, Intent arg1)
            {
                switch (getResultCode())
                {
                case Activity.RESULT_OK:
                    Toast.makeText(getBaseContext(), "SMS Sent", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NO_SERVICE:
                    Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NULL_PDU:
                    Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_RADIO_OFF:
                    Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        };

        deliveryBroadcastReciever = new BroadcastReceiver()
        {
            public void onReceive(Context arg0, Intent arg1)
            {
                switch (getResultCode())
                {
                case Activity.RESULT_OK:
                    Toast.makeText(getBaseContext(), "SMS Delivered", Toast.LENGTH_SHORT).show();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(getBaseContext(), "SMS not delivered", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        };
 
         
      
        registerReceiver( sendBroadcastReceiver,new IntentFilter(SENT));
        registerReceiver(deliveryBroadcastReciever,new IntentFilter(DELIVERED));

        btnSendSMS.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {           
            	
            	
            	String detail=Details.getText().toString();
            	if(detail.length()==0)
            	{
            		Toast.makeText(getBaseContext(), "Enter Text to Send", Toast.LENGTH_SHORT).show();
            	}
                 
            	else
            	{
                
               
                 Mail m = new Mail("quickaidsystem@gmail.com", "chetankale"); 
            	 
       	      String[] toArr = {email}; 
       	      m.setTo(toArr); 
       	      m.setFrom("kusamasingh@gmail.com"); 
       	      m.setSubject("EMERGENCY");
       	   m.setBody(detail);
       	     
       	 
       	      try { 
       	       // m.addAttachment("/sdcard/filelocation"); 
       	 
       	        if(m.send()) { 
       	          Toast.makeText(End.this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
       	        } else { 
       	          Toast.makeText(End.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
       	        } 
       	      } catch(Exception e) { 
       	        //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
       	        Log.e("MailApp", "Could not send email", e); 
       	      } 
      	      
       	   sendSMS(pno, detail);
       	finish();
       	 Intent intent = new Intent(End.this,Service.class);
            	
         startActivity(intent);
            	}
         MediaPlayer mp = MediaPlayer.create(End.this, R.raw.mysound);   
         mp.start();
         mp.setOnCompletionListener(new OnCompletionListener() {

             @Override
             public void onCompletion(MediaPlayer mp) {
                 // TODO Auto-generated method stub
                 mp.release();
             }
         
   
});
      	   
            }   });     
        
      
        
        
    }
    
    @Override
    protected void onStop()
    {
        unregisterReceiver(sendBroadcastReceiver);
        unregisterReceiver(deliveryBroadcastReciever);
        super.onStop();
    }

    public void sendSMS(String phoneNumber, String message)
    {        
    	 String SENT = "SMS_SENT";
         String DELIVERED = "SMS_DELIVERED";
  
         PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
             new Intent(SENT), 0);
  
         PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
             new Intent(DELIVERED), 0);
       

  
        
         SmsManager sms = SmsManager.getDefault();
         sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);    
    
}
    
    

    
}

