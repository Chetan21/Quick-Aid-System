package com.aid;

import java.text.DecimalFormat;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Map extends MapActivity {
    /** Called when the activity is first created. */
	private MapView mapView;
	private static final int latitudes = 19243541;
	private static final int longitudes = 72855576;
	public static double EARTH_RADIUS_KM = 6384;// km
	public int n=0;
	public String s[]=new String[100];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
   
        ImageButton home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {        
            	 
         	  
                Intent intent = new Intent(Map.this, Service.class);
               
                  startActivity(intent);
                  MediaPlayer mp = MediaPlayer.create(Map.this, R.raw.mysound);   
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
        
        ImageButton back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {        
            	 
         	  
                Intent intent = new Intent(Map.this, Operation.class);
               
                  startActivity(intent);
                  MediaPlayer mp = MediaPlayer.create(Map.this, R.raw.mysound);   
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
       
        mapView = (MapView) findViewById(R.id.map_view);       
        mapView.setBuiltInZoomControls(true);
       
        List<Overlay> mapOverlays = mapView.getOverlays();
        
        Drawable drawable1= this.getResources().getDrawable(R.drawable.marker);
        CustomItemizedOverlay item=new CustomItemizedOverlay(drawable1, this);
		
        Bundle b=this.getIntent().getExtras();
        String[] name=b.getStringArray("key1");
        String[] address=b.getStringArray("key2");
       
        String[] email=b.getStringArray("key4");
        
       double lat[]=b.getDoubleArray("key7");
       double lont[]=b.getDoubleArray("key8");
       String phone[]=b.getStringArray("key9");
       //String ContactNo2[]=b.getStringArray("key6");
       int v=b.getInt("key10");
      
      n=name.length;
       
   
        int lats[]=new int[n];
        int lonts[]=new int[n];
        for(int i=0;i<v;i++)
        {
        	s[i]=calculatedist(lat[i],lont[i]);
        }
        
          for(int i=0;i<v;i++)
  		{
        	lat[i]=lat[i]*1E6; 
        	lont[i]=lont[i]*1E6;
        	lats[i]=(int)lat[i];
        	lonts[i]=(int)lont[i];
  		GeoPoint point = new GeoPoint(lats[i], lonts[i]);
  		
  		OverlayItem overlayitem = new OverlayItem(point,"PLACE: "+name[i],"ADDRESS:  "+address[i]+" , "+"CONTACT NUMBER: "+phone[i]+" , DISTANCE:" +s[i]+"km");
  		item.addOverlay(overlayitem);
  		
  		}
          mapOverlays.add(item);
  		MapController mapController = mapView.getController();
  		Drawable drawable = this.getResources().getDrawable(R.drawable.user);
  		List<Overlay> mapOver=mapView.getOverlays();
		CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(drawable, this);
  		GeoPoint point2 = new GeoPoint(latitudes, longitudes);
  		OverlayItem overlayitem2 = new OverlayItem(point2,"HELLO","YOU ARE HERE");
  		itemizedOverlay.addOverlay(overlayitem2);
  		mapOver.add(itemizedOverlay);
  		mapController.animateTo(point2);
  		mapController.setZoom(16);
  		 
        }
    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
}
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
        
        
    }
    public String calculatedist(double y,double z)
    {
    	double d2r = (Math.PI / 180);
        double alat=y;
        double along=z;
        double dLat = ((latitudes/ 1E6) - alat) * d2r;
        double dLon = ((longitudes/ 1E6) - along) * d2r;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
        + Math.cos(alat * d2r) * Math.cos((latitudes/ 1E6) * d2r)
        * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d=EARTH_RADIUS_KM * c;
        d=roundTwoDecimals(d);
        String aString = Double.toString(d);
        return aString;
    }
    
}