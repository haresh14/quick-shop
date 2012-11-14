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
import android.view.View;

public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyPagerAdapter adapter = new MyPagerAdapter();
		ViewPager myPager = (ViewPager) findViewById(R.id.twopanelpager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);

		Store tesco = new Store("Tesco");
		Store waitrose = new Store("Waitrose");
		
		InputStream is = getResources().openRawResource(R.raw.tesco_wholemeal);
		ParseJSON.getProducts(is, tesco, Category.bread);
		
		InputStream nis = getResources().openRawResource(R.raw.waitrose_wholemeal);
		ParseJSON.getProducts(nis, waitrose, Category.bread);
		
		InputStream jis = getResources().openRawResource(R.raw.tesco_eggs);
		ParseJSON.getProducts(jis, tesco, Category.eggs);
		
		InputStream kis = getResources().openRawResource(R.raw.tesco_milk);
		ParseJSON.getProducts(kis, tesco, Category.milk);
		
		InputStream lis = getResources().openRawResource(R.raw.tesco_pork);
		ParseJSON.getProducts(lis, waitrose, Category.pork);
		
		/*is = getResources().openRawResource(R.raw.waitrose_eggs);
		ParseJSON.getProducts(is, waitrose, Category.eggs);
		
		is = getResources().openRawResource(R.raw.waitrose_pork);
		ParseJSON.getProducts(is, waitrose, Category.pork);
		
		is = getResources().openRawResource(R.raw.waitrose_milk);
		ParseJSON.getProducts(is, waitrose, Category.milk);*/
	}

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
