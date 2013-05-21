package com.dcy.blahblah;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 MyPagerAdapter adapter = new MyPagerAdapter();
	        ViewPager myPager = (ViewPager) findViewById(R.id.home_pannels_pager);
	        myPager.setAdapter(adapter);
	        myPager.setCurrentItem(0);
	}

	

}
