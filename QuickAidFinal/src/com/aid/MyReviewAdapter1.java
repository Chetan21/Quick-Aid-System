package com.aid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyReviewAdapter1 extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] name;
	
	private final String[] address;
	private final String[] Landmark;
	private final String[] Specialtiy;
	private final String[] phone;
	private final String[] email;
	private final double[] lat;
	private final double[] lont;
	int idn[];
	int n=0;
	
	static class ViewHolder {
		public TextView text;
		public TextView text1;
	}
	
	public MyReviewAdapter1(Activity context, int[] idn, String[] name, String[] address , String[] Landmark, 
			String[] Specialtiy, String[] phone, String[] email, double[] lat, double[] lont, int n) {
		super(context, R.layout.listadap, name);
		this.context=context;
		this.idn=idn;
		this.name=name;
		
		this.address=address;
		this.Landmark=Landmark;
		this.Specialtiy=Specialtiy;
		this.phone=phone;
		this.email=email;
		this.lat=lat;
		this.lont=lont;
		this.n=n;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.listadap, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.text = (TextView) rowView.findViewById(R.id.txtview);
			viewHolder.text1= (TextView) rowView.findViewById(R.id.txt1);
			rowView.setTag(viewHolder);
		}

		ViewHolder holder = (ViewHolder) rowView.getTag();
		String s = name[position];
		//double d= distance[position];
		//String str=Double.toString(d);
		final String pos = "" + position;
		holder.text.setText(s);
		
		
		holder.text.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Bundle b= new Bundle();
					 b.putStringArray("key1",name);
			          b.putStringArray("key2",address);
			           b.putStringArray("key3", Landmark);
			           b.putStringArray("key4",email);
			           b.putStringArray("key5", Specialtiy);
			           
			           b.putDoubleArray("key7", lat);
			           b.putDoubleArray("key8", lont);
			           b.putStringArray("key9", phone);
			           
			           b.putInt("key10",n);
					
					Intent intent = new Intent(v.getContext(), DispListItems1.class);
					intent.putExtras(b);
					intent.putExtra("id_no", idn[Integer.parseInt(pos)]);
					
		            v.getContext().startActivity(intent);
					//System.out.println(uid+" "+eids[Integer.parseInt(pos)]);
				}
			});
		return rowView;
	}
	
}
