package com.example.quick_shop;

import com.example.quick_shop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CartArrayAdapter extends ArrayAdapter<Product> {

		private final Context context;
		private final Product[] values;
		private final Integer[] counts;
	 
		public CartArrayAdapter(Context context, Product[] values, Integer[] counts) {
			super(context, R.layout.listcart, values);
			this.context = context;
			this.values = values;
			this.counts = counts;
		}
	 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.listcart, parent, false);
			TextView textView = (TextView) rowView.findViewById(R.id.label);
			textView.setText(values[position].toString());
			TextView numView = (TextView) rowView.findViewById(R.id.number);
			numView.setText(String.valueOf(counts[position]));
			return rowView;
		}
}