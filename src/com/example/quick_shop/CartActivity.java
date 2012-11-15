package com.example.quick_shop;


import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CartActivity extends ListActivity {
	
	private ArrayList<Product> products;
	private Integer[] counts;
	
	private Mediator mediator = Mediator.getInstance();
	private CartArrayAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = mediator.getProducts();
        counts = new Integer[mediator.getCount().size()];
        
        products = mediator.getProducts();
        counts = mediator.getCount().toArray(counts);
        
        adapter = new CartArrayAdapter(this, products, counts);
        setListAdapter(adapter);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cart_view, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if (item.getItemId() == R.id.clear_cart) {
    		mediator.clear();
    		products.clear();
    		counts = null;
    		adapter.notifyDataSetInvalidated();
    		return true;
    	}
    	return false;
    }
}
