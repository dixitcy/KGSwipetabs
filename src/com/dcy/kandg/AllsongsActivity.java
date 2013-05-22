package com.dcy.kandg;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;


import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class AllsongsActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_allsongs);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up action bar.
		final ActionBar actionBar = getActionBar();

		// Specify that the Home button should show an "Up" caret, indicating
		// that touching the
		// button will take the user one step up in the application's hierarchy.
		actionBar.setDisplayHomeAsUpEnabled(true);

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.allsongs, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
		final int NUM_ITEMS = 3; // number of tabs

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			// Fragment fragment = new DummySectionFragment();
			// Bundle args = new Bundle();
			// args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position +
			// 1);
			// fragment.setArguments(args);
			// return fragment;
			Fragment fragment = new TabFragment();
			Bundle args = new Bundle();
			args.putInt(TabFragment.ARG_OBJECT, i);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return NUM_ITEMS;
		}

		@Override
		public CharSequence getPageTitle(int position) {

			String tabLabel = null;
			switch (position) {
			case 0:
				tabLabel = getString(R.string.label1);
				break;
			case 1:
				tabLabel = getString(R.string.label2);
				break;
			case 2:
				tabLabel = getString(R.string.label3);
				break;
			}

			return tabLabel;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class TabFragment extends Fragment {

		public static final String ARG_OBJECT = "object";
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Bundle args = getArguments();
			int position = args.getInt(ARG_OBJECT);

			int tabLayout = 0;
			switch (position) {
			case 0:
				tabLayout = R.layout.tabs1;
				break;
			case 1:
				tabLayout = R.layout.tabs2;
				break;
			case 2:
				tabLayout = R.layout.tabs3;
				break;
			}
			View rootView = inflater.inflate(tabLayout, container, false);
			GridView gridView = (GridView) rootView.findViewById(R.id.gridview);

			gridView.setAdapter(new MYadapter(rootView.getContext()));
			gridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {

					// Sending image id to FullScreenActivity
					Intent i = new Intent(getActivity().getBaseContext(),
							Imgact.class);
					// passing array index
					i.putExtra("id", position);
					startActivity(i);

				}
			});
			return rootView;

		}

	}

}
