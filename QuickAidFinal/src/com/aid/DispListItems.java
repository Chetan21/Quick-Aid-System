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
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class DispListItems extends Activity{

	public String name[]=new String[0];
	public String address[]=new String[0];
	public String email[]=new String[0];
	public String Landmark[]=new String[0];
    public String Specialtiy[]=new String[0];
    public double lat[]=new double [0];
    public double lont[]=new double [0];
    public String phone[]=new String[0];
    public String ContactNo2[]=new String[0];
    public double distance[]=new double[0];
    String name1, address1, Landmark1, email1, phone1, Specialtiy1;
    double lat1, lont1, distance1;
    public ImageButton mapbtn, send, callBtn, home, back;
    public String KEY_121;
    String id;
    int idn;
    int no=0;
    
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.listdisp);
    	Bundle b=this.getIntent().getExtras();
 
    	no=b.getInt("key10");
    	idn=b.getInt("id_no");
    	id=Integer.toString(idn);
    	distance=b.getDoubleArray("key11");

		callBtn=(ImageButton) findViewById(R.id.call);
    	
    	callBtn.setOnClickListener(new OnClickListener() {
    	@Override
		public void onClick(View v) {

    		 Intent i = new Intent((Intent.ACTION_DIAL));
    	      //  String p = "tel:" + getString(R.string.Phone);
    	        i.setData(Uri.parse("tel:"+phone1));
			startActivity(i);
			MediaPlayer mp = MediaPlayer.create(DispListItems.this, R.raw.mysound);   
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
    	
    	home=(ImageButton) findViewById(R.id.home);
    	home.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    			Intent in=new Intent(DispListItems.this, Service.class);
    			startActivity(in);
    			MediaPlayer mp = MediaPlayer.create(DispListItems.this, R.raw.mysound);   
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
			
    	back=(ImageButton) findViewById(R.id.back);
    	back.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    			Intent in=new Intent(DispListItems.this, Operation.class);
    			startActivity(in);
    			MediaPlayer mp = MediaPlayer.create(DispListItems.this, R.raw.mysound);   
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
		
		
    	tv1=(TextView) findViewById(R.id.txt);
    	tv2=(TextView) findViewById(R.id.txt1);
    	tv3=(TextView) findViewById(R.id.txt2);
    	tv4=(TextView) findViewById(R.id.txt3);
    	tv5=(TextView) findViewById(R.id.txt4);
    	tv6=(TextView) findViewById(R.id.txt5);
    	
    	
    	KEY_121="http://mysqldb.xtreemhost.com/quickaid/list.php";
    	getServerData(KEY_121);
    	
    }
    public String getServerData(String returnString) 
	{
		
	   InputStream is = null;
	   String result = "";
 
	  
	   ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	   
	   nameValuePairs.add(new BasicNameValuePair("id_no",id));
		   //rstname = rstname.replace(" ", "%20");
		   //System.out.println(rstname);
		   //url = "http://10.0.2.2/foodle/getrestdetails.php?eid="+str;
		   
		   //http post
		    try{
		    	System.out.println("before http");
		            HttpClient httpclient = new DefaultHttpClient();
		            HttpPost httppost = new HttpPost(KEY_121);
		            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		            //HttpPost httppost = new HttpPost(url);
		            HttpResponse response = httpclient.execute(httppost);
		            HttpEntity entity = response.getEntity();
		            is = entity.getContent();
		            //System.out.println(response.toString());

		    }catch(Exception e){
		            Log.e("log_tag", "Error in http connection "+e.toString());
		    }

		    //convert response to string
		    try{
		            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
		            StringBuilder sb = new StringBuilder();
		            String line = null;
		            while ((line = reader.readLine()) != null) 
		            {
		                    sb.append(line + "\n");
		            }
		            is.close();
		            result += sb.toString();
		          
		    }catch(Exception e){
		            Log.e("log_tag", "Error converting result "+e.toString());
		    }
		    //parse json data
		    try{
		            JSONArray jArray = new JSONArray(result);
		        	int num; 
		        	name=new String[jArray.length()];
		        	address=new String[jArray.length()];
		        	Landmark=new String[jArray.length()];
		        	phone=new String[jArray.length()];
		        	email=new String[jArray.length()];
		        	Specialtiy=new String[jArray.length()];
		        	lat=new double[jArray.length()];
		        	lont=new double[jArray.length()];
		        	//distance=new double[jArray.length()];
		            num=jArray.length();
		            int i;
		            for(i=0;i<num;i++)
		            {
		                   JSONObject json_data = jArray.getJSONObject(i);
		                   name[i]=json_data.getString("name");
		                   address[i]=json_data.getString("address");
		                   phone[i]=json_data.getString("phone");
		                   Landmark[i]=json_data.getString("Landmark");
		                   email[i]=json_data.getString("email");
		                   Specialtiy[i]=json_data.getString("Specialtiy");
		                   lat[i]=json_data.getDouble("latitude");
		                   lont[i]=json_data.getDouble("longitude");
		                   //distance[i]=json_data.getDouble("distance");
		                  // System.out.println(name[i]+" "+add[i]+" "+ph_no[i]+" "+price[i]+" "+cat[i]+" "+rev[i]);
		                   returnString += "\n\t" + jArray.getJSONObject(i);
		            }
	                   
		            //distance1=distance[i-1];
		            
		            tv1.setText(name[i-1]);
		            tv2.setText(address[i-1]);
		            tv3.setText(Landmark[i-1]);
		            tv4.setText(Specialtiy[i-1]);
		            tv5.setText(phone[i-1]);
		            tv6.setText(email[i-1]);
		            
		            name1=name[i-1];
		            address1=address[i-1];
		            phone1=phone[i-1];
		            email1=email[i-1];
		            
		            lat1=lat[i-1];
		            lont1=lont[i-1];
		            mapbtn=(ImageButton) findViewById(R.id.map);
		        	mapbtn.setOnClickListener(new OnClickListener()
		        	{
		        		public void onClick(View v)
		        		{	
		        			Bundle b= new Bundle();
		        			b.putString("key1", name1);
		        			b.putString("key2", address1);
		        			b.putStringArray("key3", Landmark);
		        			b.putString("key4", email1);
		        			b.putStringArray("key5", Specialtiy);
		        			b.putDouble("key7", lat1);
		        			b.putDouble("key8", lont1);
		        			b.putString("key9", phone1);
		        			b.putInt("key10", no);
		        			//b.putDouble("key11", distance1);
		        			
		        			Intent in=new Intent(DispListItems.this, MapOne.class);
		        			in.putExtras(b);
		        			startActivity(in);
		        			MediaPlayer mp = MediaPlayer.create(DispListItems.this, R.raw.mysound);   
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
		        	
		        	send=(ImageButton) findViewById(R.id.send);
		        	send.setOnClickListener(new OnClickListener()
		        	{
		        		public void onClick(View v)
		        		{	
		        			Bundle b= new Bundle();
		        			b.putString("key1", name1);
		        			b.putString("key2", address1);
		        			b.putStringArray("key3", Landmark);
		        			b.putString("key4", email1);
		        			b.putStringArray("key5", Specialtiy);
		        			b.putDouble("key7", lat1);
		        			b.putDouble("key8", lont1);
		        			b.putString("key9", phone1);
		        			b.putInt("key10", no);
		        			//b.putDouble("key11", distance1);
		        			
		        			Intent in=new Intent(DispListItems.this, Finish.class);
		        			in.putExtras(b);
		        			startActivity(in);
		        			MediaPlayer mp = MediaPlayer.create(DispListItems.this, R.raw.mysound);   
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
		        	
		        	

		        	
		        	
	                  
		    }catch(JSONException e)
		    {
		            Log.e("log_tag", "Error parsing data "+e.toString());
		            e.printStackTrace();
		    }
		  return returnString;
		    	}
    
    
    
    
}
