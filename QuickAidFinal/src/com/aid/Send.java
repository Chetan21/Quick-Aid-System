package com.aid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Send extends Activity {
	public int s;
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        final Bundle b =new Bundle();
       Button Btn1 = (Button) findViewById(R.id.btn1);
       Btn1.setOnClickListener(new OnClickListener() {
           public void onClick(View v) 
           {        
        	   s=1;
        	   b.putInt("key",s); 
               Intent intent = new Intent(Send.this, Select2.class);
               intent.putExtras(b);
               finish();
                 startActivity(intent);
           }
       });
      Button Btn2 = (Button) findViewById(R.id.btn2);
       Btn2.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
               
        	   s=2;
        	   b.putInt("key",s); 
               Intent intent = new Intent(Send.this, Select2.class);
               intent.putExtras(b);
                 startActivity(intent);
                 finish();
           }
       });
       Button Btn3 = (Button) findViewById(R.id.btn3);
       Btn3.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
               
        	   s=3;
        	   b.putInt("key",s); 
               Intent intent = new Intent(Send.this, Select2.class);
               intent.putExtras(b);
                 startActivity(intent);
                 finish();
           }
       });
       Button Btn4 = (Button) findViewById(R.id.btn4);
       Btn4.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
               
        	   s=4;
        	   b.putInt("key",s); 
               Intent intent = new Intent(Send.this, Select2.class);
               intent.putExtras(b);
                 startActivity(intent);
                 finish();
           }
       });
       Button Btn5 = (Button) findViewById(R.id.btn5);
       Btn5.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {    
        	   finish();
        	   s=5;
        	   
        	   b.putInt("key",s); 
               Intent intent = new Intent(Send.this, Select2.class);
               intent.putExtras(b);
                 startActivity(intent);
           }
       });
       
       Button Btn6 = (Button) findViewById(R.id.btn6);
       Btn6.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {    
        	   finish();
        	   s=6;
        	   
        	   b.putInt("key",s); 
               Intent intent = new Intent(Send.this, Select2.class);
               intent.putExtras(b);
                 startActivity(intent);
           }
       });
       Button Btn7 = (Button) findViewById(R.id.btn7);
       Btn7.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {        
        	   finish();
        	  
               Intent intent = new Intent(Send.this, Service.class);
              
                 startActivity(intent);
           }
       });
       
       Button back= (Button) findViewById(R.id.back);
       back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {        
         	   finish();
                Intent intent = new Intent(Send.this, Operation.class);
                  startActivity(intent);
            }
        });
    }
	
}