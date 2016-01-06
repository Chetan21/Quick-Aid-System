package com.aid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DispHav extends Activity {
/** Called when the activity is first created. */
	public String KEY_121;
	
	   public int choice;
	   public String z;
	   public String l;
	   public String name[]=new String[500];
	   public String address[]=new String[500];
	   public String email[]=new String[500];
	   public String Landmark[]=new String[500];
	   public String Specialtiy[]=new String[500];
	   public double lat[]=new double [225];
	   public double lont[]=new double [225];
	   public String phone[]=new String[200];
	   public String ContactNo2[]=new String[200];
	   public double distance[]=new double[500];
	   public TextView txt;
	   public ImageButton btnOpen;
	   public ImageButton btnBack;
	   public ImageButton btnHome;
	   public int n=0;
	   double roundTwoDecimals(double d) {
           DecimalFormat twoDForm = new DecimalFormat("#.##");
       return Double.valueOf(twoDForm.format(d));
}
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.disphav);
    // Create a crude view - this should really be set via the layout resources  
    // but since its an example saves declaring them in the XML.  
   txt=(TextView)findViewById(R.id.tv_un); 
   btnBack=(ImageButton) findViewById(R.id.back);
   btnOpen = (ImageButton) findViewById(R.id.btnSave);
   btnHome=(ImageButton) findViewById(R.id.home);
    Bundle b=this.getIntent().getExtras();
    
    choice=b.getInt("key");
   // z=b.getString("keyz");
   //l=b.getString("keyl");
   if(choice==1)
   {
	  
		   KEY_121="http://mysqldb.xtreemhost.com/quickaid/hosphav.php";
		   getServerData1(KEY_121);
		   for(int i=0;i<n;i++)
		    {
		    	txt.append("->NAME:-"+name[i]);
		    	txt.append("\n");
		    	txt.append("ADDRESS:-"+address[i]);
		    	txt.append("\n");
		    	txt.append("LANDMARK:-"+Landmark[i]);
		    	txt.append("\n");
		    	txt.append("SPECIALITY:-"+Specialtiy[i]);
		    	txt.append("\n");
		    	txt.append("LATITUDE:-"+lat[i]);
		    	txt.append("\n");
		    	txt.append("LONGITUDE:-"+lont[i]);
		    	txt.append("\n");
		    	txt.append("CONTACT NUMBERS:-"+phone[i]+"/"+ContactNo2[i]);
		    	txt.append("\n");
		    	txt.append("EMAIL ID:-"+email[i]);
		    	txt.append("\n");
		    	txt.append("DISTANCE:-"+roundTwoDecimals(distance[i])+"km");
		    	txt.append("\n");
		    	txt.append("-----------------------------------------------------------");
		    	txt.append("\n\n");
		
		    }
	  
   }
   if(choice==2)
   {
	  
		   KEY_121="http://mysqldb.xtreemhost.com/quickaid/atmhav.php";
		   getServerData1(KEY_121);
		   for(int i=0;i<n;i++)
		    {
		    	txt.append("->NAME:-"+name[i]);
		    	txt.append("\n");
		    	txt.append("ADDRESS:-"+address[i]);
		    	txt.append("\n");
		    	txt.append("LANDMARK:-"+Landmark[i]);
		    	txt.append("\n");
		    	txt.append("SPECIALITY:-"+Specialtiy[i]);
		    	txt.append("\n");
		    	txt.append("LATITUDE:-"+lat[i]);
		    	txt.append("\n");
		    	txt.append("LONGITUDE:-"+lont[i]);
		    	txt.append("\n");
		    	txt.append("CONTACT NUMBERS:-"+phone[i]+"/"+ContactNo2[i]);
		    	txt.append("\n");
		    	txt.append("EMAIL ID:-"+email[i]);
		    	txt.append("\n");
		    	txt.append("DISTANCE:-"+roundTwoDecimals(distance[i])+"km");
		    	txt.append("\n\n");
		
		    	}
	  
	   
   }
   if(choice==3)
   {
	   
		   KEY_121="http://mysqldb.xtreemhost.com/quickaid/policehav.php";
		   getServerData1(KEY_121);
		   for(int i=0;i<n;i++)
		    {
		    	txt.append("->NAME:-"+name[i]);
		    	txt.append("\n");
		    	txt.append("ADDRESS:-"+address[i]);
		    	txt.append("\n");
		    	txt.append("LANDMARK:-"+Landmark[i]);
		    	txt.append("\n");
		    	txt.append("SPECIALITY:-"+Specialtiy[i]);
		    	txt.append("\n");
		    	txt.append("LATITUDE:-"+lat[i]);
		    	txt.append("\n");
		    	txt.append("LONGITUDE:-"+lont[i]);
		    	txt.append("\n");
		    	txt.append("CONTACT NUMBERS:-"+phone[i]+"/"+ContactNo2[i]);
		    	txt.append("\n");
		    	txt.append("EMAIL ID:-"+email[i]);
		    	txt.append("\n");
		    	txt.append("DISTANCE:-"+roundTwoDecimals(distance[i])+"km");
		    	txt.append("\n\n");
		
		    	}
	   
   }
   if(choice==4)
   {
	   
		   KEY_121="http://mysqldb.xtreemhost.com/quickaid/bbankhav.php";
		   getServerData1(KEY_121);
		   for(int i=0;i<n;i++)
		    {
		    	txt.append("->NAME:-"+name[i]);
		    	txt.append("\n");
		    	txt.append("ADDRESS:-"+address[i]);
		    	txt.append("\n");
		    	txt.append("LANDMARK:-"+Landmark[i]);
		    	txt.append("\n");
		    	txt.append("SPECIALITY:-"+Specialtiy[i]);
		    	txt.append("\n");
		    	txt.append("LATITUDE:-"+lat[i]);
		    	txt.append("\n");
		    	txt.append("LONGITUDE:-"+lont[i]);
		    	txt.append("\n");
		    	txt.append("CONTACT NUMBERS:-"+phone[i]+"/"+ContactNo2[i]);
		    	txt.append("\n");
		    	txt.append("EMAIL ID:-"+email[i]);
		    	txt.append("\n");
		    	txt.append("DISTANCE:-"+roundTwoDecimals(distance[i])+"km");
		    	txt.append("\n\n");
		
		    	}
	 
   }
 
   if(choice==5)
   {
	   
		   KEY_121="http://mysqldb.xtreemhost.com/quickaid/vethav.php";
		   getServerData1(KEY_121);
		   for(int i=0;i<n;i++)
		    {
		    	txt.append("->NAME:-"+name[i]);
		    	txt.append("\n");
		    	txt.append("ADDRESS:-"+address[i]);
		    	txt.append("\n");
		    	txt.append("LANDMARK:-"+Landmark[i]);
		    	txt.append("\n");
		    	txt.append("SPECIALITY:-"+Specialtiy[i]);
		    	txt.append("\n");
		    	txt.append("LATITUDE:-"+lat[i]);
		    	txt.append("\n");
		    	txt.append("LONGITUDE:-"+lont[i]);
		    	txt.append("\n");
		    	txt.append("CONTACT NUMBERS:-"+phone[i]+"/"+ContactNo2[i]);
		    	txt.append("\n");
		    	txt.append("EMAIL ID:-"+email[i]);
		    	txt.append("\n");
		    	txt.append("DISTANCE:-"+roundTwoDecimals(distance[i])+"km");
		    	txt.append("\n\n");
		
		    	}
	  
   }
   if(choice==6)
   {
	  
		   KEY_121="http://mysqldb.xtreemhost.com/quickaid/pphav.php";
		   getServerData1(KEY_121);
		   for(int i=0;i<n;i++)
		    {
		    	txt.append("->NAME:-"+name[i]);
		    	txt.append("\n");
		    	txt.append("ADDRESS:-"+address[i]);
		    	txt.append("\n");
		    	txt.append("LANDMARK:-"+Landmark[i]);
		    	txt.append("\n");
		    	txt.append("SPECIALITY:-"+Specialtiy[i]);
		    	txt.append("\n");
		    	txt.append("LATITUDE:-"+lat[i]);
		    	txt.append("\n");
		    	txt.append("LONGITUDE:-"+lont[i]);
		    	txt.append("\n");
		    	txt.append("CONTACT NUMBERS:-"+phone[i]+"/"+ContactNo2[i]);
		    	txt.append("\n");
		    	txt.append("EMAIL ID:-"+email[i]);
		    	txt.append("\n");
		    	txt.append("DISTANCE:-"+roundTwoDecimals(distance[i])+"km");
		    	txt.append("\n\n");
		
		    	}
	
   }
   if(n!=0)
   {
	   btnBack.setVisibility(View.VISIBLE);
	   
   btnOpen.setOnClickListener(new OnClickListener() 
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
           
           Intent i=new Intent(DispHav.this, Map.class);
           i.putExtras(b);
           startActivity(i);
    	   }
    	   
       	
       
   });
   }
   else
   {
	  
	   btnOpen.setVisibility(View.VISIBLE);
	   
	   
	   
	   
   }
   btnBack.setOnClickListener(new OnClickListener() 
   {
       public void onClick(View v) 
       {
    	   
           
           Intent i=new Intent(DispHav.this, Near.class);
           
           startActivity(i);
    	   }
    	   
       	
       
   });
   btnHome.setOnClickListener(new OnClickListener() 
   {
       public void onClick(View v) 
       {
    	   finish();
      
           
           Intent i=new Intent(DispHav.this, Service.class);
        
           startActivity(i);
    	   }
    	   
       	
       
   });
   }






private String getServerData1(String returnString) {
    
   InputStream is = null;
    
   String result = "";
    //the year data to send
   // ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
  // nameValuePairs.add(new BasicNameValuePair("city",city));

    //http post
    try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(KEY_121);
       //     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

    }catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
    }

    //convert response to string
    try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),20);
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
            if(n!=0)
            {
            for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
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
                   
                    returnString += "\n\t" + jArray.getJSONObject(i); 
            }
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
	 AlertDialog.Builder alert = new AlertDialog.Builder(DispHav.this);

     alert.setTitle("YOUR SEARCH RETURNED NO RESULTS");
     alert.setMessage("Please Try Again! ");
     alert.setIcon(R.drawable.icon);
     alert.setPositiveButton("OK",
      new DialogInterface.OnClickListener() {
       public void onClick(DialogInterface dialog, int id) 
       {
    	   Toast.makeText(DispHav.this, "SORRY, PLEASE TRY ANOTHER SEARCH", Toast.LENGTH_SHORT).show();
       
       }
      });
     

     alert.show();
}

    
}