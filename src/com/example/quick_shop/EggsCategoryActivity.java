package com.example.quick_shop;

import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class EggsCategoryActivity extends ListActivity {
	
	private List<Product> eggList;
	
	private Mediator mediator = Mediator.getInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eggList = Category.eggs.getProducts();
        Product[] productList = new Product[eggList.size()];
        eggList.toArray(productList);
        setListAdapter(new MobileArrayAdapter(this, productList));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cart, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Handle item selection
    	switch(item.getItemId()) {
    	case R.id.view_cart:
    		Intent intent = new Intent(this, CartActivity.class);
    		startActivity(intent);
    		return true;
    	case R.id.cart:
    		Toast.makeText(getApplicationContext(), "Added item" , Toast.LENGTH_SHORT).show();
    		for (int i = 0; i < eggList.size(); ++i) 
    			mediator.set((Product)getListAdapter().getItem(i), i);
    		return true;
    	}
    	return false;
    }
}
