package com.example.quick_shop;

import com.example.quick_shop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MobileArrayAdapter extends ArrayAdapter<Product> {

		private final Context context;
		private final Product[] values;
		private int[] counts;
		private Spinner spinner;
		
		private final Mediator mediator = Mediator.getInstance();
	 
		public MobileArrayAdapter(Context context, Product[] values) {
			super(context, R.layout.listpicturestuff, values);
			this.context = context;
			this.values = values;
			this.counts = new int[values.length];
		}
	 
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.listpicturestuff, parent, false);
			TextView textView = (TextView) rowView.findViewById(R.id.label);
			spinner = (Spinner) rowView.findViewById(R.id.quantity);
			spinner.setSelection(counts[position]);
			spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					
					counts[position] = arg2;
					mediator.setCount(counts);
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			textView.setText(values[position].getName());
	 
			return rowView;
		}
}
