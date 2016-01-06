package com.aid;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
public class GMapsActivity extends MapActivity 
{
	
	private MapView mapView;
	private ImageButton btnHome, back;
	private static final int latitude = 19243541;
	private static final int longitude = 72855576;
	public static double EARTH_RADIUS_KM = 6384;// km
	
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        btnHome= (ImageButton)findViewById(R.id.home);
        btnHome.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent in=new Intent(GMapsActivity.this, Service.class);
				startActivity(in);
				 MediaPlayer mp = MediaPlayer.create(GMapsActivity.this, R.raw.mysound);   
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
				Intent in=new Intent(GMapsActivity.this, Misc.class);
				startActivity(in);
				 MediaPlayer mp = MediaPlayer.create(GMapsActivity.this, R.raw.mysound);   
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
        mapView.setSatellite(true);
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable draw = this.getResources().getDrawable(R.drawable.user);
        CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(draw, this);
        
        
        GeoPoint point = new GeoPoint(latitude, longitude);
        OverlayItem overlayitem = new OverlayItem(point,"HELLO","YOU ARE HERE");
  		itemizedOverlay.addOverlay(overlayitem);
		
		mapOverlays.add(itemizedOverlay);
		MapController mapController = mapView.getController();
		
		mapController.animateTo(point);
		mapController.setZoom(15);
		mapView.setStreetView(true);
		MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mapView.getOverlays();
        listOfOverlays.add(mapOverlay);  
      
        
    }
    class MapOverlay extends com.google.android.maps.Overlay
    {
    	@Override
        public boolean onTouchEvent(MotionEvent event, MapView mapView) 
        {   
            //---when user lifts his finger---
            if (event.getAction() == 1) 
            {                
                GeoPoint p = mapView.getProjection().fromPixels(
                    (int) event.getX(),
                    (int) event.getY());
                	final Toast toast, toast1;
                   toast= Toast.makeText(getBaseContext(), 
                        "LATITUDE IS: "+p.getLatitudeE6() / 1E6 + "," + 
                        "LONGITUDE IS: "+p.getLongitudeE6() /1E6 , 
                        Toast.LENGTH_SHORT);
                   toast.show();
                    double d2r = (Math.PI / 180);
                    double alat=p.getLatitudeE6() / 1E6;
                    double along=p.getLongitudeE6() / 1E6;
                    double dLat = ((latitude/ 1E6) - alat) * d2r;
                    double dLon = ((longitude/ 1E6) - along) * d2r;
                    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                    + Math.cos(alat * d2r) * Math.cos((latitude/ 1E6) * d2r)
                    * Math.sin(dLon / 2) * Math.sin(dLon / 2);
                    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                    double d=EARTH_RADIUS_KM * c;
                    String aString = Double.toString(d);
                    toast1=Toast.makeText(getBaseContext(),"DISTANCE FROM YOU: "+aString+" KM",Toast.LENGTH_SHORT);
                    toast1.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           toast.cancel(); 
                           toast1.cancel();
                       }
                }, 1000);
                    
            }                            
            return false;
        }        
    }
    

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
    
}