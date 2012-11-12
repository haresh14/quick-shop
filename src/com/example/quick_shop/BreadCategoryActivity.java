package com.example.quick_shop;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BreadCategoryActivity extends ListActivity {
	
	private List<Product> breadList;
	
	private Mediator mediator = Mediator.getInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        breadList = Category.bread.getProducts();
        Product[] productList = new Product[breadList.size()];
        breadList.toArray(productList);
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
    		for (int i = 0; i < breadList.size(); ++i) 
    			mediator.set((Product)getListAdapter().getItem(i), i);
    		return true;
    	}
    	return false;
    }
}
