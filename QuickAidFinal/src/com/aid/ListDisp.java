package com.aid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.aid.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;


public class ListDisp extends Activity{

	public String KEY_121;
	public int choice;
	public int id[]=new int[100];
	public String name[]=new String[0];
	public String address[]=new String[0];
	public String email[]=new String[0];
	public String Landmark[]=new String[0];
    public String Specialtiy[]=new String[0];
    public double lat[];
    public double lont[];
    public String phone[]=new String[0];
    public String ContactNo2[]=new String[0];
    public double distance[]=new double[0];
    public ImageButton btnMap, btnHome, back;
    public int n=0;
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.displist);
    	btnHome= (ImageButton)findViewById(R.id.home);
        btnHome.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent in=new Intent(ListDisp.this, Service.class);
				startActivity(in);
				 MediaPlayer mp = MediaPlayer.create(ListDisp.this, R.raw.mysound);   
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
        
        back= (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent in=new Intent(ListDisp.this, Near.class);
				startActivity(in);
				 MediaPlayer mp = MediaPlayer.create(ListDisp.this, R.raw.mysound);   
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
    	Bundle b=this.getIntent().getExtras();
        
        choice=b.getInt("key");
        if(choice==1)
        {
        	KEY_121="http://mysqldb.xtreemhost.com/quickaid/hosphav.php";
        }
        else if(choice==2)
        {
        	KEY_121="http://mysqldb.xtreemhost.com/quickaid/atmhav.php";
        }
        else if(choice==3)
        {
        	KEY_121="http://mysqldb.xtreemhost.com/quickaid/policehav.php";
        }
        else if(choice==4)
        {
        	KEY_121="http://mysqldb.xtreemhost.com/quickaid/bbankhav.php";
        }
        else if(choice==5)
        	{
        	KEY_121="http://mysqldb.xtreemhost.com/quickaid/vethav.php";
        	}
        else if(choice==6)
        {
        	KEY_121="http://mysqldb.xtreemhost.com/quickaid/pphav.php";
        }
        getServerData(KEY_121);
        	
        System.out.println("1");
    }
    private String getServerData(String returnString) {
        	
    	   
    	   InputStream is = null;
    	   System.out.println("1.5");
    	   String result = "";
    	    //the year data to send
    	   // ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    	  // nameValuePairs.add(new BasicNameValuePair("city",city));

    	    //http post
    	    try{	System.out.println("2.0");
    	            HttpClient httpclient = new DefaultHttpClient();
    	            HttpPost httppost = new HttpPost(KEY_121);
    	       //     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    	            HttpResponse response = httpclient.execute(httppost);
    	            HttpEntity entity = response.getEntity();
    	            is = entity.getContent();
    	            System.out.println("2");

    	    }catch(Exception e){
    	            Log.e("log_tag", "Error in http connection "+e.toString());
    	    }

    	    //convert response to string
    	    try{
    	    	System.out.println("3");
    	            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
    	            StringBuilder sb = new StringBuilder();
    	            String line = null;
    	            while ((line = reader.readLine()) != null) {
    	                    sb.append(line + "\n");
    	            }
    	            is.close();
    	            result=sb.toString();
    	            System.out.println("4");
    	    }catch(Exception e){
    	            Log.e("log_tag", "Error converting result "+e.toString());
    	    }
    	    //parse json data
    	    try{	
    	    	System.out.println("5");
    	            JSONArray jArray = new JSONArray(result);
    	            n=jArray.length();
    	            name=new String[n];
    	            distance=new double[n];
    	            address=new String[n];
    	            Landmark=new String[n];
    	            Specialtiy=new String[n];
    	            ContactNo2=new String[n];
    	            email=new String[n];
    	            phone=new String[n];
    	            lat=new double[n];
    	            lont=new double[n];
    	            int i=0;
    	            if(n!=0)
    	            {
    	            for( i=0;i<jArray.length();i++){
    	                    JSONObject json_data = jArray.getJSONObject(i);
    	                    id[i]=json_data.getInt("id_no");
    	                    name[i]=json_data.getString("name");
    	                    address[i]=json_data.getString("address");
    	                    Landmark[i]=json_data.getString("Landmark");
    	                    Specialtiy[i]=json_data.getString("Specialtiy");
    	                    email[i]=json_data.getString("email");
    	                    lat[i]=json_data.getDouble("latitude");
    	                    lont[i]=json_data.getDouble("longitude");
    	                    phone[i]=json_data.getString("phone");
    	                    ContactNo2[i]=json_data.getString("ContactNo2");
    	                    distance[i]=json_data.getDouble("distance");
    	                    System.out.println(name[i]+" "+id[i]);
    	                    returnString += "\n\t" + jArray.getJSONObject(i); 
    	            }
    	            System.out.println("6");
    	            ListView lv=(ListView) findViewById(R.id.list1);
    	            lv.setAdapter(new MyReviewAdapter(this, id, name, distance, address, Landmark, Specialtiy, phone, email, lat, lont,n));
    	            
    	            btnMap=(ImageButton) findViewById(R.id.btnMap);
    	            btnMap.setOnClickListener(new OnClickListener() 
    	            {
    	                public void onClick(View v) 
    	                {
    	             	   finish();
    	                	Bundle b =new Bundle(); 
    	                    b.putStringArray("key1",name);
    	                    b.putStringArray("key2",address);
    	                    b.putStringArray("key3", Landmark);
    	                    b.putStringArray("key4",email);
    	                    b.putStringArray("key5", Specialtiy);
    	                    b.putStringArray("key6", ContactNo2);
    	                    b.putDoubleArray("key7", lat);
    	                    b.putDoubleArray("key8", lont);
    	                    b.putStringArray("key9", phone);
    	                    b.putDoubleArray("key11", distance);
    	                    b.putInt("key10",n);
    	                    
    	                    Intent i=new Intent(ListDisp.this, Map.class);
    	                    i.putExtras(b);
    	                    startActivity(i);
    	                    MediaPlayer mp = MediaPlayer.create(ListDisp.this, R.raw.mysound);   
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
    	    }catch(JSONException e)
    	    {
    	            Log.e("log_tag", "Error parsing data "+e.toString());
    	            e.printStackTrace();
    	    }
			return returnString;
    	    
    	}
}

