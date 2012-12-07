package com.example.quick_shop;

import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CategoryListActivity extends ListActivity {
	
	private List<Product> productList;
	private Category category;

	// Every class that needs to change the cart gets the single instance of the mediator
	private Mediator mediator = Mediator.getInstance();
	
	/**
	 * @param category Category for this particular ListView
	 */
	public CategoryListActivity(Category category) {
		this.category = category;
	}
	
    @Override
    // List view for products in categories. Layout defined in activity_category_list.xml
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productList = category.getProducts();
        Product[] productArray = new Product[productList.size()];
        productList.toArray(productArray);
        setListAdapter(new CategoryArrayAdapter(this, productArray));
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
    	// Add an item to the cart. Shows text to notify the user of this
    	case R.id.cart:
    		Toast.makeText(getApplicationContext(), "Added item" , Toast.LENGTH_SHORT).show();
    		for (int i = 0; i < productList.size(); ++i) 
    			mediator.set((Product)getListAdapter().getItem(i), i);
    		return true;
    	}
    	return false;
    }
}