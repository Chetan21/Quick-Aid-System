package com.aid;

import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Locate extends MapActivity {
	protected boolean isRouteDisplayed() {
		return false;
	}

	private static MapView myMap;
	private Button btnSearch;
	private ImageButton btnHome;
	private EditText adress;
	private Geocoder gc;
	private double lat;
	private double lon;
	public static CustomItemizedOverlay item;
	public static List<Overlay> mapOverlays; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locate);

		myMap = (MapView) findViewById(R.id.simpleGM_map); // Get map from XML
		btnSearch = (Button) findViewById(R.id.simpleGM_btn_search); // Get button from xml
		adress = (EditText) findViewById(R.id.simpleGM_adress); // Get address from XML
		
		gc = new Geocoder(this); // create new geocoder instance
		
		btnHome= (ImageButton)findViewById(R.id.home);
		
		
		btnHome.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent in=new Intent(Locate.this, Service.class);
				startActivity(in);
			    MediaPlayer mp = MediaPlayer.create(Locate.this, R.raw.mysound);   
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
		
		ImageButton btnBack=(ImageButton) findViewById(R.id.back);
		btnBack.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent in=new Intent(Locate.this, Misc.class);
				startActivity(in);
				 MediaPlayer mp = MediaPlayer.create(Locate.this, R.raw.mysound);   
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
		
		mapOverlays = myMap.getOverlays();
        
        Drawable drawable1= this.getResources().getDrawable(R.drawable.marker);
         item=new CustomItemizedOverlay(drawable1, this);
	        
		btnSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String addressInput = adress.getText().toString(); // Get input text

				try {

					List<Address> foundAdresses = gc.getFromLocationName(
							addressInput, 5); // Search addresses

					if (foundAdresses.size() == 0) { // if no address found,
						// display an error
						Dialog locationError = new AlertDialog.Builder(
								Locate.this).setIcon(0).setTitle(
								"Error").setPositiveButton(R.string.ok, null)
								.setMessage(
										"Sorry, your address doesn't exist.")
								.create();
						locationError.show();
					} else { // else display address on map
						for (int i = 0; i < foundAdresses.size(); ++i) {
							// Save results as Longitude and Latitude
							// @todo: if more than one result, then show a
							// select-list
							Address x = foundAdresses.get(i);
							lat = x.getLatitude();
							lon = x.getLongitude();
						}
						navigateToLocation((lat * 1000000), (lon * 1000000),
								myMap); // display the found address
					}
				} catch (Exception e) {
					// @todo: Show error message
				}

			}
		});
	}

	/**
	 * Navigates a given MapView to the specified Longitude and Latitude
	 * 
	 * @param latitude
	 * @param longitude
	 * @param mv
	 */
	public static void navigateToLocation(double latitude, double longitude,
			MapView mv) {
		GeoPoint p = new GeoPoint((int) latitude, (int) longitude); // new
		// GeoPoint
		 
	        OverlayItem overlayitem2 = new OverlayItem(p,"HELLO","YOU ARE HERE");
	  		item.addOverlay(overlayitem2);
	  		mapOverlays.add(item);
		mv.displayZoomControls(true); // display Zoom (seems that it doesn't
		// work yet)
		MapController mc = mv.getController();
		mc.animateTo(p); // move map to the given point
		int zoomlevel = mv.getMaxZoomLevel(); // detect maximum zoom level
		mc.setZoom(zoomlevel - 1); // zoom
		mv.setSatellite(false); // display only "normal" mapview

	}
}