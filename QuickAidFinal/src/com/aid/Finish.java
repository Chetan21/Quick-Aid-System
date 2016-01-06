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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Finish extends Activity{

	/** Called when the activity is first created. */
	public EditText edittext;
	public Button btnOpen;
	public int choice;
	public String email;
	public String phone;
   public String u;
   public String name;
	public EditText emailid;
	public EditText pno;
	public  String KEY_121;
	ImageButton Home, back;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.finish);
    // Create a crude view - this should really be set via the layout resources  
    // but since its an example saves declaring them in the XML.  
    TextView txt=(TextView)findViewById(R.id.tv); 
    Bundle b=this.getIntent().getExtras();
    name=b.getString("key1");
    email=b.getString("key4");
    phone=b.getString("key9");
    /*choice=b.getInt("key2");
    if(choice==1)
        KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/finish1.php";
        else if(choice==2)
        	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/finish2.php";
        else if(choice==3)
       	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/finish3.php";
        else if(choice==4)
       	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/finish4.php";
        else if(choice==5)
          	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/finish5.php";
        else if(choice==6)
          	 KEY_121 = "http://mysqldb.xtreemhost.com/quickaid/finish7.php";*/
    //getServerData(KEY_121);
    edittext = (EditText) findViewById(R.id.edittext);
    edittext.setText(name);
   
    emailid = (EditText) findViewById(R.id.edittext2);
    emailid.setText(email);
    pno = (EditText) findViewById(R.id.edittext3);
    pno.setText(phone);
    btnOpen = (Button) findViewById(R.id.btnSave);
    Home = (ImageButton) findViewById(R.id.Home);
  
 
  //call the method to run the data retreival
    
   
	
    btnOpen.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
        	check();
           // TODO Auto-generated method stub
        	//getServerData(KEY_121);
        	   
            MediaPlayer mp = MediaPlayer.create(Finish.this, R.raw.mysound);   
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
    Home.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
         
        	
       
        	Intent intent = new Intent(Finish.this,Service.class);
        
            startActivity(intent);    
       	 finish();
       	 MediaPlayer mp = MediaPlayer.create(Finish.this, R.raw.mysound);   
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
    
    back= (ImageButton) findViewById(R.id.back);
    back.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {        
      	   
             finish();
               MediaPlayer mp = MediaPlayer.create(Finish.this, R.raw.mysound);   
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
	
	String s=pno.getText().toString();
	String s1=emailid.getText().toString();
	if(s.length()==0 || s1.length()==0 || s==null || s1==null || s.startsWith("-") || s1.startsWith("-"))
		  Toast.makeText(getBaseContext(), "No E-Mail or Contact Info", Toast.LENGTH_SHORT).show();
	else
	{
		Bundle b =new Bundle(); 
        b.putString("keym",email);
        b.putString("keys",phone);
   
    	Intent intent = new Intent(Finish.this,End.class);
    	intent.putExtras(b);
        startActivity(intent); 
	}
}
  //i use my real ip here



/*private String getServerData(String returnString) {
    
   InputStream is = null;
    
   String result = "";
    //the year data to send
    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("name",name));
    

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
            for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    email=json_data.getString("email");
                    phone=json_data.getString("phone");
                   // Log.i("log_tag","id: "+json_data.getInt("id")+
                     //       ", name: "+json_data.getString("name")+
                       //     ", sex: "+json_data.getInt("sex")+
                       //     ", birthyear: "+json_data.getInt("birthyear")
                    //);
                    //Get an output to the screen
                    returnString += "\n\t" + jArray.getJSONObject(i); 
            }
    }catch(JSONException e)
    {
            Log.e("log_tag", "Error parsing data "+e.toString());
            e.printStackTrace();
    }
    return returnString; 
}*/    
 	
	
}
