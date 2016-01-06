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

public class Operation extends Activity {
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operation);
        
       Button Btn1 = (Button) findViewById(R.id.btn1);
       Btn1.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
        	   finish();
               Intent intent = new Intent(Operation.this, Search.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Operation.this, R.raw.mysound);   
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
        	   finish();
               Intent intent = new Intent(Operation.this, Near.class);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Operation.this, R.raw.mysound);   
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
         	   finish();
                Intent intent = new Intent(Operation.this, Service.class);
                  startActivity(intent);
                  MediaPlayer mp = MediaPlayer.create(Operation.this, R.raw.mysound);   
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
       
       ImageButton home= (ImageButton) findViewById(R.id.home);
       home.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {        
         	   finish();
                Intent intent = new Intent(Operation.this, Service.class);
                  startActivity(intent);
                  MediaPlayer mp = MediaPlayer.create(Operation.this, R.raw.mysound);   
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