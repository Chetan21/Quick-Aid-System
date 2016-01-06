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
import android.widget.TextView;


public class Select2 extends Activity {
/** Called when the activity is first created. */
  
	public  String KEY_121;
   public int n;
  TextView txt;
  public int choice;
  Button go;
  Button Home;
	AutoCompleteTextView autotextView;
@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hospital2);
    // Create a crude view - this should really be set via the layout resources  
    // but since its an example saves declaring them in the XML.  
    autotextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_name); 
    
    go = (Button) findViewById(R.id.search);
    Home=(Button) findViewById(R.id.Home);
    // Set the text and call the connect function.  
 
  //call the method to run the data retrieval
    Bundle b=this.getIntent().getExtras();
   choice=b.getInt("key");
    if(choice==1)
    KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/hosp.php";
    else if(choice==2)
    	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/atm.php";
    else if(choice==3)
   	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/police.php";
    else if(choice==4)
   	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/bbank.php";
    else if(choice==5)
      	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/vet.php";
    else if(choice==6)
      	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/pp.php";
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, getServerData(KEY_121));
    
    
    autotextView.setThreshold(1);
    autotextView.setAdapter(adapter);
    
   
     
    go.setOnClickListener(new View.OnClickListener() 
    {
        public void onClick(View v) 
        {
           // TODO Auto-generated method stub
        	check();
       	
          
        }
     });
    Home.setOnClickListener(new View.OnClickListener() 
    {
        public void onClick(View v) 
        {
           // TODO Auto-generated method stub
        	  Intent i=new Intent(Select2.this, Service.class);
        	  
        	    startActivity(i);
        	    finish();
        	    MediaPlayer mp = MediaPlayer.create(Select2.this, R.raw.mysound);   
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
    Button back= (Button) findViewById(R.id.back);
    back.setOnClickListener(new OnClickListener() {
         public void onClick(View v) {        
      	   finish();
             Intent intent = new Intent(Select2.this, Send.class);
               startActivity(intent);
               MediaPlayer mp = MediaPlayer.create(Select2.this, R.raw.mysound);   
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



public void check()
{
	
	String s=autotextView.getText().toString();
	Bundle b =new Bundle();
    b.putString("key",s);
    b.putInt("key2",choice);

    Intent i=new Intent(Select2.this, Finish.class);
    i.putExtras(b);
    startActivity(i);
    finish();
}

private String[] getServerData(String returnString) {
    
   InputStream is = null;
   String name[]=null;
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
            name = new String[jArray.length()];
            for(int i=0;i<jArray.length();i++)
            {
                    JSONObject json_data = jArray.getJSONObject(i);
                    /*Log.i("log_tag","id: "+json_data.getInt("id")+
                            ", name: "+json_data.getString("name")+
                            ", sex: "+json_data.getInt("sex")+
                            ", birthyear: "+json_data.getInt("birthyear")
                    );*/
                    //Get an output to the screen
                    //returnString += "\n\t" + jArray.getJSONObject(i);
                    name[i]=json_data.getString("name");
                
                    
                    
            }
    }catch(JSONException e){
            Log.e("log_tag", "Error parsing data "+e.toString());
    }
    return name; 
}    
    
}