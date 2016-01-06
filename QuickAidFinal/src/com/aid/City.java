package com.aid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;







import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class City extends Activity {
/** Called when the activity is first created. */
  
   
   public int n;
  TextView txt;
 public String  KEY_121;
  Button go;
  public int choice;
	AutoCompleteTextView autotextView;
@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.city);
    // Create a crude view - this should really be set via the layout resources  
    // but since its an example saves declaring them in the XML.  
    autotextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_name); 
    
    go = (Button) findViewById(R.id.search);
    Bundle b=this.getIntent().getExtras();
    choice=b.getInt("key");
    ImageButton Btn5 = (ImageButton) findViewById(R.id.home);
    Btn5.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {        
        	 finish();
     	  
            Intent intent = new Intent(City.this, Service.class);
           
              startActivity(intent);
              MediaPlayer mp = MediaPlayer.create(City.this, R.raw.mysound);   
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
             Intent intent = new Intent(City.this, Search.class);
               startActivity(intent);
               MediaPlayer mp = MediaPlayer.create(City.this, R.raw.mysound);   
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
    
    if(choice==1)
    {
   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/hospcity.php";
    }
    else  if(choice==2)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/atmcity.php";
    }
    else  if(choice==3)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/policecity.php";
    }
    else  if(choice==4)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/bbankcity.php";
    }
    else  if(choice==5)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/vetcity.php";
    }
    else  if(choice==6)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/ppcity.php";
    }

    // Set the text and call the connect function.  
 
  //call the method to run the data retrieval
   
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, getServerData(KEY_121));
    
    
    autotextView.setThreshold(1);
    autotextView.setAdapter(adapter);
    
   
     
    go.setOnClickListener(new View.OnClickListener() 
    {
        public void onClick(View v) 
        {
           // TODO Auto-generated method stub
        	check();
        	 MediaPlayer mp = MediaPlayer.create(City.this, R.raw.mysound);   
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



 //i use my real ip here

public void check()
{
	
	String s=autotextView.getText().toString();
	if(s.length()==0)
		  Toast.makeText(getBaseContext(), "Please select a city", Toast.LENGTH_SHORT).show();
	else
	{
	Bundle b =new Bundle();
    b.putString("keys",s);
    b.putInt("key", choice);

    Intent i=new Intent(City.this, Select.class);
    i.putExtras(b);
    startActivity(i);
	}
}

private String[] getServerData(String returnString) {
    
   InputStream is = null;
   String city[]=null;
   String result = "";
    //the year data to send
    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

    //http post
    try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(KEY_121);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

    }catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
    }

    //convert response to string
    try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
            }
            is.close();
            result=sb.toString();
    }catch(Exception e){
            Log.e("log_tag", "Error converting result "+e.toString());
    }
    //parse json data
    try{
            JSONArray jArray = new JSONArray(result);
            n=jArray.length();
           city = new String[jArray.length()];
            for(int i=0;i<jArray.length();i++)
            {
                    JSONObject json_data = jArray.getJSONObject(i);
                    
                   city[i]=json_data.getString("city");
                   returnString += "\n\t" + jArray.getJSONObject(i); 
                    
                    
            }
    }catch(JSONException e){
            Log.e("log_tag", "Error parsing data "+e.toString());
    }
    return city; 
}    
    
}