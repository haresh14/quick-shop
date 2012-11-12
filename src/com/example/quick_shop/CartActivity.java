package com.example.quick_shop;

import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;

public class CartActivity extends ListActivity {
	
	private List<Product> products;
	
	private Mediator mediator = Mediator.getInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = mediator.getProducts();
        Product[] productList = new Product[products.size()];
        products.toArray(productList);
        setListAdapter(new CartArrayAdapter(this, productList, mediator.getCounts()));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_none, menu);
        
        return true;
    }
}
