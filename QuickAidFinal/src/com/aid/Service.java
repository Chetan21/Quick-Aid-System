package com.aid;




import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Service extends Activity {
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);
        TextView txt= (TextView) findViewById(R.id.txt);
        Typeface tf=Typeface.createFromAsset(getAssets(), "HTOWERT.TTF");
        txt.setTypeface(tf);
        
        
       Button Btn1 = (Button) findViewById(R.id.service);
       
       Btn1.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
               
               Intent intent = new Intent(Service.this, Operation.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Service.this, R.raw.mysound);   
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
       
       Button Btn2 = (Button) findViewById(R.id.loc);
      
       Btn2.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
        	   
               Intent intent = new Intent(Service.this, Misc.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Service.this, R.raw.mysound);   
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
       Button Btn3 = (Button) findViewById(R.id.btn3);
       
       Btn3.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
        	   
               Intent intent = new Intent(Service.this, AboutUs.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Service.this, R.raw.mysound);   
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
       Button Btn4 = (Button) findViewById(R.id.btn4);
      
       Btn4.setOnClickListener(new OnClickListener() 
       {
           public void onClick(View v) {        
        	   
               Intent intent = new Intent(Service.this, Help.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Service.this, R.raw.mysound);   
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
       Button btn5= (Button) findViewById(R.id.exit);
    
       btn5.setOnClickListener(new OnClickListener()
       {
    	   public void onClick(View v)
    	   {
    		   Intent intent = new Intent(Intent.ACTION_MAIN);
    		   intent.addCategory(Intent.CATEGORY_HOME);
    		   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    		   startActivity(intent);
    		   MediaPlayer mp = MediaPlayer.create(Service.this, R.raw.mysound);   
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
       Btn1.setTypeface(tf);
       Btn2.setTypeface(tf);
       Btn3.setTypeface(tf);
       Btn4.setTypeface(tf);
       btn5.setTypeface(tf);
    }
	 
	 
	
}