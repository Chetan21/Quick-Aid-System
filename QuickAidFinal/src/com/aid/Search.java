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

public class Search extends Activity {
	
	public int s;
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        final Bundle b =new Bundle();
       ImageButton Btn1 = (ImageButton) findViewById(R.id.btn1);
       Btn1.setOnClickListener(new OnClickListener() {
           public void onClick(View v) 
           {     	
        	   s=1;
        	   b.putInt("key",s);   
        	  
               Intent intent = new Intent(Search.this, City.class);
               intent.putExtras(b);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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
       ImageButton Btn2 = (ImageButton) findViewById(R.id.btn2);
       Btn2.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {    
        	 
        	   s=2;
        	   b.putInt("key",s); 
               Intent intent = new Intent(Search.this, City.class);
               intent.putExtras(b);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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
       ImageButton Btn3 = (ImageButton) findViewById(R.id.btn3);
       Btn3.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
        	   
        	   s=3;
        	   b.putInt("key",s); 
               Intent intent = new Intent(Search.this, City.class);
               intent.putExtras(b);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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
       ImageButton Btn4 = (ImageButton) findViewById(R.id.btn4);
       Btn4.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {    
        	   
        	   s=4;
        	   
        	   b.putInt("key",s); 
               Intent intent = new Intent(Search.this, City.class);
               intent.putExtras(b);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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
       
       ImageButton Btn5 = (ImageButton) findViewById(R.id.btn5);
       Btn5.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {    
        	   
        	   s=5;
        	   
        	   b.putInt("key",s); 
               Intent intent = new Intent(Search.this, City.class);
               intent.putExtras(b);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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
       
       ImageButton Btn6 = (ImageButton) findViewById(R.id.btn6);
       Btn6.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {    
        	   
        	   s=6;
        	   
        	   b.putInt("key",s); 
               Intent intent = new Intent(Search.this, City.class);
               intent.putExtras(b);
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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
       ImageButton home = (ImageButton) findViewById(R.id.home);
       home.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
        	   
        	  
               Intent intent = new Intent(Search.this, Service.class);
              
                 startActivity(intent);
                 MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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
         	   
                Intent intent = new Intent(Search.this, Operation.class);
                  startActivity(intent);
                  MediaPlayer mp = MediaPlayer.create(Search.this, R.raw.mysound);   
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