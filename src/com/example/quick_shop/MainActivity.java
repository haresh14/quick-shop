package com.example.quick_shop;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	
	// I wish I had a better idea for this. I want to dispatch these automatically but I'm stuck
	// on getting the categories to match up all the time. Right now, if we added a new store
	// it would have to have resources in this order: bread, eggs, milk, and pork
	private int[] tesco_resources = {R.raw.tesco_bread, R.raw.tesco_eggs, R.raw.tesco_milk,
									  R.raw.tesco_pork};
	private int[] waitrose_resources = {R.raw.waitrose_bread, R.raw.waitrose_eggs, R.raw.waitrose_milk,
									     R.raw.waitrose_pork};
	private Category[] categories = { Category.bread, Category.eggs, Category.milk, Category.pork };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyPagerAdapter adapter = new MyPagerAdapter();
		ViewPager myPager = (ViewPager) findViewById(R.id.twopanelpager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);

		Store tesco = new Store("Tesco");
		tesco.setResources(tesco_resources);
		Store waitrose = new Store("Waitrose");
		waitrose.setResources(waitrose_resources);
		retrieveInput(tesco);
		retrieveInput(waitrose);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.cart) {
			Intent intent = new Intent(this, CartActivity.class);
    		startActivity(intent);
    		return true;
		}
		return false;
	}
	
	/**
	 * Populates the ListViews with items from the files given in store.getResources()
	 */
	public void retrieveInput(Store store) {
		int[] resources = store.getResources();
		for (int i = 0; i < resources.length; ++i) {
			InputStream is = getResources().openRawResource(resources[i]);
			ParseJSON.getProducts(is, store, categories[i]);	
		}
	}

	// Necessary methods to start each individual activity. This list will grow
	// very large in the future. I'm looking into making this process less tiresome.
	public void gotoPork(View view) {
		Intent intent = new Intent(this, PorkCategoryActivity.class);
		startActivity(intent);
	}

	public void gotoBread(View view) {
		Intent intent = new Intent(this, BreadCategoryActivity.class);
		startActivity(intent);
	}

	public void gotoMilk(View view) {
		Intent intent = new Intent(this, MilkCategoryActivity.class);
		startActivity(intent);
	}

	public void gotoEggs(View view) {
		Intent intent = new Intent(this, EggsCategoryActivity.class);
		startActivity(intent);
	}
	
	public void gotoCart(View view) {
		Intent intent = new Intent(this, CartActivity.class);
		startActivity(intent);
	}

	/**
	 * @author sebastian
	 * Switches views on slide. Currently there are only two views (named left and right) which have
	 * the same layout. 
	 */
	private class MyPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);
		}
		
		@Override
		public Object instantiateItem(View collection, int position) {
			LayoutInflater inflater = (LayoutInflater) collection.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			int resId = 0;
			switch (position) {
			case 0:
				resId = R.layout.right;
				break;
			case 1:
				resId = R.layout.left;
				break;
			}
			View view = inflater.inflate(resId, null);
			((ViewPager) collection).addView(view, 0);
			return view;
		}
	}
}
