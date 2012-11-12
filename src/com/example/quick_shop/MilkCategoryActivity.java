package com.example.quick_shop;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MilkCategoryActivity extends ListActivity {

	private List<Product> milkList;
	
	private Mediator mediator = Mediator.getInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        milkList = Category.milk.getProducts();
        Product[] productList = new Product[milkList.size()];
        milkList.toArray(productList);
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
    		Toast.makeText(getApplicationContext(), "Added item" , 2).show();
    		for (int i = 0; i < milkList.size(); ++i) 
    			mediator.set((Product)getListAdapter().getItem(i), i);
    		return true;
    	}
    	return false;
    }
}
