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
import org.apache.http.message.BasicNameValuePair;
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
import android.widget.EditText;
import android.widget.ImageButton;

public class Select extends Activity{

	/** Called when the activity is first created. */
	public EditText edittext;
	public Button btnOpen;

   public String city;
   public int choice;
   public String z=null;
   public String l=null;
	public AutoCompleteTextView  zone;
	public AutoCompleteTextView  location;
	public String  KEY_121;
	public String zones[]=null;
	public String locations[]=null;
	
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.select);
    // Create a crude view - this should really be set via the layout resources  
    // but since its an example saves declaring them in the XML.  
   // TextView txt=(TextView)findViewById(R.id.tv); 
    
    Bundle b=this.getIntent().getExtras();
    city=b.getString("keys");
    choice=b.getInt("key");
    ImageButton Btn5 = (ImageButton) findViewById(R.id.home);
    Btn5.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {        
     	  
        	 finish();
            Intent intent = new Intent(Select.this, Service.class);
           
              startActivity(intent);
              MediaPlayer mp = MediaPlayer.create(Select.this, R.raw.mysound);   
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
      	  
             Intent intent = new Intent(Select.this, Search.class);
               startActivity(intent);
               MediaPlayer mp = MediaPlayer.create(Select.this, R.raw.mysound);   
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
   KEY_121 ="http://mysqldb.xtreemhost.com/quickaid/hospselect.php";
    }
    else  if(choice==2)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/atmselect.php";
    }
    else  if(choice==3)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/policeselect.php";
    }
    else  if(choice==4)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/bbankselect.php";
    }
    else  if(choice==5)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/vetselect.php";
    }
    else  if(choice==6)
    {
    	   KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/ppselect.php";
    }
    
    String a=getServerData(KEY_121);
    System.out.println(a);
    zone = (AutoCompleteTextView) findViewById(R.id.zone); 
    location = (AutoCompleteTextView) findViewById(R.id.location); 
    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,zones);
    

    zone.setThreshold(1);
    //zone.getAdapter();
    zone.setAdapter(adapter1);
    
    
    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,locations);

   location.setThreshold(3);
   location.setAdapter(adapter2);
   
    btnOpen = (Button) findViewById(R.id.btnSave);
    
  
  
    
    
    
  //call the method to run the data retreival
    
    
  
    btnOpen.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
           // TODO Auto-generated method stub
        	 finish();
        	z=zone.getText().toString();
            l=location.getText().toString();
        	Bundle b =new Bundle(); 
            b.putString("keys",city);
            b.putInt("key",choice);
            b.putString("keyz",z);
            b.putString("keyl",l);
        
        	Intent intent = new Intent(Select.this, SearchList.class);
        	intent.putExtras(b);
            startActivity(intent);
            MediaPlayer mp = MediaPlayer.create(Select.this, R.raw.mysound);   
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



private String getServerData(String returnString) {
    
   InputStream is = null;
    
   String result = "";
    //the year data to send
    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("city",city));

   

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
            zones = new String[jArray.length()];
            locations=new String[jArray.length()];
            for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    zones[i]=json_data.getString("zone");
                    locations[i]=json_data.getString("location");
            }
    }catch(JSONException e)
    {
            Log.e("log_tag", "Error parsing data "+e.toString());
            e.printStackTrace();
    }
    return returnString; 
}    
 	
	
}
