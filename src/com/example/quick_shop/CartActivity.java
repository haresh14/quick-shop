package com.example.quick_shop;

import java.util.Collection;
import java.util.Set;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;

public class CartActivity extends ListActivity {
	
	private Set<Product> products;
	private Collection<Integer> counts;
	
	private Mediator mediator = Mediator.getInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = mediator.getProducts();
        Product[] productList = new Product[products.size()];
        products.toArray(productList);
        counts = mediator.getCount();
        Integer[] count = new Integer[counts.size()];
        counts.toArray(count);
        setListAdapter(new CartArrayAdapter(this, productList, count));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_none, menu);
        
        return true;
    }
}
