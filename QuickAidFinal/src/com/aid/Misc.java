package com.aid;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Misc extends Activity {
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.misc);
     
       Button Btn1 = (Button) findViewById(R.id.placeLoc);
       Btn1.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
               
               Intent intent = new Intent(Misc.this, Locate.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Misc.this, R.raw.mysound);   
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
       Button Btn2 = (Button) findViewById(R.id.locYou);
       Btn2.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
               
               Intent intent = new Intent(Misc.this, GMapsActivity.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Misc.this, R.raw.mysound);   
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
      
       ImageButton home1= (ImageButton) findViewById(R.id.home);
       home1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {        
         	  
                Intent intent = new Intent(Misc.this, Service.class);
                  startActivity(intent);
                  MediaPlayer mp = MediaPlayer.create(Misc.this, R.raw.mysound);   
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
       
       ImageButton back= (ImageButton) findViewById(R.id.back);
       back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {        
         	   
                Intent intent = new Intent(Misc.this, Service.class);
                  startActivity(intent);
                  MediaPlayer mp = MediaPlayer.create(Misc.this, R.raw.mysound);   
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
    }
	
}