package com.aid;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class QuickAid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        Thread splashThread = new Thread() {
            @Override
            public void run() {
               try 
               {
                  int waited = 0;
                  while (waited < 5000) {
                     sleep(100);
                     waited += 100;
                  }
               } catch (InterruptedException e) {
                  // do nothing
               } finally {
                  finish();
                  Intent i = new Intent();
                  i.setClassName("com.aid","com.aid.Service");
                  startActivity(i);
               }
            }
         };
         splashThread.start();
    }
}