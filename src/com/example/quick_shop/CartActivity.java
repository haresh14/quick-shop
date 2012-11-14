package com.example.quick_shop;


import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CartActivity extends ListActivity {
	
	private Product[] products;
	private Integer[] counts;
	
	private Mediator mediator = Mediator.getInstance();
	private CartArrayAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = new Product[mediator.getProducts().size()];
        counts = new Integer[mediator.getCount().size()];
        
        products = mediator.getProducts().toArray(products);
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
    		products = null;
    		counts = null;
    		adapter.notifyDataSetChanged();
    		return true;
    	}
    	return false;
    }
}
