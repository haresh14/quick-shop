package com.example.quick_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class CartActivity extends ListActivity {
	
	private List<Product> products;
	
	private Mediator mediator = Mediator.getInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = mediator.getProducts();
        Product[] productList = new Product[products.size()];
        products.toArray(productList);
        setListAdapter(new StoreArrayAdapter(this, productList, mediator.getCounts()));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_none, menu);
        
        return true;
    }
}
