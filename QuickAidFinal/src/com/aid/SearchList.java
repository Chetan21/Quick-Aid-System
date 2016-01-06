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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


public class SearchList extends Activity{

	public String KEY_121;
	public int choice;
	public String z;
	public String l, city;
	public int id[]=new int[0];
	public String name[]=new String[0];
	public String address[]=new String[0];
	public String email[]=new String[0];
	public String Landmark[]=new String[0];
    public String Specialtiy[]=new String[0];
    public double lat[];
    public double lont[];
    public String phone[]=new String[0];
    public ImageButton btnMap, home, back;
    public double distance[]=new double[0];
    public int n=0;
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.displist);
    	Bundle b=this.getIntent().getExtras();
        
    	city=b.getString("keys");
        choice=b.getInt("key");
        z=b.getString("keyz");
        l=b.getString("keyl");
        
        home=(ImageButton) findViewById(R.id.home);
        back=(ImageButton) findViewById(R.id.back);
        home.setOnClickListener(new OnClickListener(){
        	public void onClick(View v)
        	{
        		Intent in= new Intent(SearchList.this, Service.class);
        		startActivity(in);
        		MediaPlayer mp = MediaPlayer.create(SearchList.this, R.raw.mysound);   
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
        back.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent in=new Intent(SearchList.this, Search.class);
        		startActivity(in);
        		MediaPlayer mp = MediaPlayer.create(SearchList.this, R.raw.mysound);   
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
        	if(z.length()==0 && l.length()==0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/hosp1.php";
        		getServerData1(KEY_121);
        	}
        	else if(z.length()==0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/hosp2.php";
        		getServerData2(KEY_121);
        	}
        	else if(l.length()==0 && z.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/hosp3.php";
        		getServerData3(KEY_121);
        	}
        	else if(z.length()!=0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/hosp4.php";
     		   getServerData4(KEY_121);
     		   if(n==0)
     		  {
    			  
   			   val();
   			   
     		  }
        	}
        } 
        else if(choice==2)
        {
        	if(z.length()==0 && l.length()==0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/atm1.php";
        		getServerData1(KEY_121);
        	}
        	else if(z.length()==0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/atm2.php";
        		getServerData2(KEY_121);
        	}
        	else if(l.length()==0 && z.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/atm3.php";
        		getServerData3(KEY_121);
        	}
        	else if(z.length()!=0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/atm4.php";
     		   getServerData4(KEY_121);
     		  if(n==0)
     		  {
    			  
   			   val();
   			   
     		  }
        }}
        else if(choice==3)
        {
        	if(z.length()==0 && l.length()==0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/police1.php";
        		getServerData1(KEY_121);
        	}
        	else if(z.length()==0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/police2.php";
        		getServerData2(KEY_121);
        	}
        	else if(l.length()==0 && z.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/police3.php";
        		getServerData3(KEY_121);
        	}
        	else if(z.length()!=0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/police4.php";
     		   getServerData4(KEY_121);
     		  if(n==0)
     		  {
    			  
   			   val();
   			   
     		  }
        } }
        else if(choice==4)
        {
        	if(z.length()==0 && l.length()==0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/bbank1.php";
        		getServerData1(KEY_121);
        	}
        	else if(z.length()==0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/bbank2.php";
        		getServerData2(KEY_121);
        	}
        	else if(l.length()==0 && z.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/bbank3.php";
        		getServerData3(KEY_121);
        	}
        	else if(z.length()!=0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/bbank4.php";
     		   getServerData4(KEY_121);
     		  if(n==0)
     		  {
    			  
   			   val();
   			   
     		  }
        } }
        else if(choice==5)
        	{
        	if(z.length()==0 && l.length()==0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/vet1.php";
        		getServerData1(KEY_121);
        	}
        	else if(z.length()==0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/vet2.php";
        		getServerData2(KEY_121);
        	}
        	else if(l.length()==0 && z.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/vet3.php";
        		getServerData3(KEY_121);
        	}
        	else if(z.length()!=0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/vet4.php";
     		   getServerData4(KEY_121);
     		  if(n==0)
     		  {
    			  
   			   val();
   			   
     		  }
        	
        	}
        	}
        else if(choice==6)
        {
        	if(z.length()==0 && l.length()==0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/pp1.php";
        		getServerData1(KEY_121);
        	}
        	else if(z.length()==0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/pp2.php";
        		getServerData2(KEY_121);
        	}
        	else if(l.length()==0 && z.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/pp3.php";
        		getServerData3(KEY_121);
        	}
        	else if(z.length()!=0 && l.length()!=0)
        	{
        		KEY_121="http://mysqldb.xtreemhost.com/quickaid/pp4.php";
     		   getServerData4(KEY_121);
     		   if(n==0)
     		  {
    			  
   			   val();
   			   
     		  }
        	}
        
        } 	
        System.out.println("1");
    }
    private String getServerData1(String returnString) {
        
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
    	            n=jArray.length();
    	            name=new String[n];
    	           
    	            address=new String[n];
    	            Landmark=new String[n];
    	            Specialtiy=new String[n];
    	            email=new String[n];
    	            phone=new String[n];
    	            lat=new double[n];
    	            lont=new double[n];
    	            id=new int[n];
    	            if(n!=0)
    	            {
    	            for(int i=0;i<jArray.length();i++){
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
    	                     
    	                   
    	                    returnString += "\n\t" + jArray.getJSONObject(i); 
    	            }
    	            ListView lv=(ListView) findViewById(R.id.list1);
    	            lv.setAdapter(new MyReviewAdapter1(this, id, name, address, Landmark, Specialtiy, phone, email, lat, lont,n));
    	            lv.setClickable(true);
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
    	                   // b.putStringArray("key6", ContactNo2);
    	                    b.putDoubleArray("key7", lat);
    	                    b.putDoubleArray("key8", lont);
    	                    b.putStringArray("key9", phone);
    	                    b.putDoubleArray("key11", distance);
    	                    b.putInt("key10",n);
    	                    
    	                    Intent i=new Intent(SearchList.this, Map.class);
    	                    i.putExtras(b);
    	                    startActivity(i);
    	                    MediaPlayer mp = MediaPlayer.create(SearchList.this, R.raw.mysound);   
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
    	private String getServerData2(String returnString) {
    	    
    		   InputStream is = null;
    		    
    		   String result = "";
    		    //the year data to send
    		    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    		    nameValuePairs.add(new BasicNameValuePair("city",city));
    		    nameValuePairs.add(new BasicNameValuePair("location",l));

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
    		            name=new String[n];
        	            
        	            address=new String[n];
        	            Landmark=new String[n];
        	            Specialtiy=new String[n];
        	            email=new String[n];
        	            phone=new String[n];
        	            lat=new double[n];
        	            lont=new double[n];
        	            id=new int[n];
    		            if(n!=0)
    		            {
    		            for(int i=0;i<jArray.length();i++){
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
    		                     
    		                    returnString += "\n\t" + jArray.getJSONObject(i); 
    		            }
    		            ListView lv=(ListView) findViewById(R.id.list1);
        	            lv.setAdapter(new MyReviewAdapter1(this, id, name, address, Landmark, Specialtiy, phone, email, lat, lont,n));
        	            lv.setClickable(true);
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
        	                   // b.putStringArray("key6", ContactNo2);
        	                    b.putDoubleArray("key7", lat);
        	                    b.putDoubleArray("key8", lont);
        	                    b.putStringArray("key9", phone);
        	                    b.putDoubleArray("key11", distance);
        	                    b.putInt("key10",n);
        	                    
        	                    Intent i=new Intent(SearchList.this, Map.class);
        	                    i.putExtras(b);
        	                    startActivity(i);
        	                    MediaPlayer mp = MediaPlayer.create(SearchList.this, R.raw.mysound);   
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
    	private String getServerData3(String returnString) {
    	    
    		   InputStream is = null;
    		    
    		   String result = "";
    		    //the year data to send
    		    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    		    nameValuePairs.add(new BasicNameValuePair("city",city));
    		    nameValuePairs.add(new BasicNameValuePair("zone",z));

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
    		            name=new String[n];
        	            
        	            address=new String[n];
        	            Landmark=new String[n];
        	            Specialtiy=new String[n];
        	            email=new String[n];
        	            phone=new String[n];
        	            lat=new double[n];
        	            lont=new double[n];
        	            id=new int[n];
    		            if(n!=0)
    		            {
    		            for(int i=0;i<jArray.length();i++){
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
    		                     
    		                    returnString += "\n\t" + jArray.getJSONObject(i); 
    		            }
    		            ListView lv=(ListView) findViewById(R.id.list1);
        	            lv.setAdapter(new MyReviewAdapter1(this, id, name, address, Landmark, Specialtiy, phone, email, lat, lont,n));
        	            lv.setClickable(true);
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
        	                   // b.putStringArray("key6", ContactNo2);
        	                    b.putDoubleArray("key7", lat);
        	                    b.putDoubleArray("key8", lont);
        	                    b.putStringArray("key9", phone);
        	                    b.putDoubleArray("key11", distance);
        	                    b.putInt("key10",n);
        	                    
        	                    Intent i=new Intent(SearchList.this, Map.class);
        	                    i.putExtras(b);
        	                    startActivity(i);
        	                    MediaPlayer mp = MediaPlayer.create(SearchList.this, R.raw.mysound);   
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
    	public void val()
    	{
    		 AlertDialog.Builder alert = new AlertDialog.Builder(SearchList.this);

    	     alert.setTitle("YOUR SEARCH RETURNED NO RESULTS");
    	     alert.setMessage("Please Try Again! ");
    	     alert.setIcon(R.drawable.icon);
    	     alert.setPositiveButton("OK",
    	      new DialogInterface.OnClickListener() {
    	       public void onClick(DialogInterface dialog, int id) 
    	       {
    	    	   Toast.makeText(SearchList.this, "SORRY, PLEASE TRY ANOTHER SEARCH", Toast.LENGTH_SHORT).show();
    	       
    	       }
    	      });
    	     

    	     alert.show();
    	}
    	private String getServerData4(String returnString) {
    	    
    		   InputStream is = null;
    		    
    		   String result = "";
    		    //the year data to send
    		    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    		    nameValuePairs.add(new BasicNameValuePair("city",city));
    		    nameValuePairs.add(new BasicNameValuePair("location",l));
    		    nameValuePairs.add(new BasicNameValuePair("zone",z));
    		    

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
    		            System.out.println(jArray.length());
    		            n=jArray.length();
		            	name=new String[n];
	    	            
	    	            address=new String[n];
	    	            Landmark=new String[n];
	    	            Specialtiy=new String[n];
	    	            email=new String[n];
	    	            phone=new String[n];
	    	            lat=new double[n];
	    	            lont=new double[n];
	    	            id=new int[n];
	    	            if(n!=0)
    		            {
	    	            	for(int i=0;i<jArray.length();i++)
    		            	 
    		                 {
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
    		                     
    		                    returnString += "\n\t" + jArray.getJSONObject(i); 
    		            }
	    	            	ListView lv=(ListView) findViewById(R.id.list1);
	        	            lv.setAdapter(new MyReviewAdapter1(this, id, name, address, Landmark, Specialtiy, phone, email, lat, lont,n));
	        	            lv.setClickable(true);
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
	        	                   // b.putStringArray("key6", ContactNo2);
	        	                    b.putDoubleArray("key7", lat);
	        	                    b.putDoubleArray("key8", lont);
	        	                    b.putStringArray("key9", phone);
	        	                    b.putDoubleArray("key11", distance);
	        	                    b.putInt("key10",n);
	        	                    
	        	                    Intent i=new Intent(SearchList.this, Map.class);
	        	                    i.putExtras(b);
	        	                    startActivity(i);
	        	                    MediaPlayer mp = MediaPlayer.create(SearchList.this, R.raw.mysound);   
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

