package com.kyler.search.mockup.material;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.kyler.search.mockup.design.tests.adapter.SearchMockupDrawerAdapter;
import com.kyler.search.mockup.design.tests.ui.Icons;
import com.kyler.search.mockup.material.fragments.WeatherFragment;
import com.wisemandesigns.android.widgets.CircularImageView;

public class SearchMockup extends FragmentActivity {

	private DrawerLayout mDrawerLayout;

	private ListView mDrawerList;

	private ActionBarDrawerToggle mDrawerToggle;

	@SuppressWarnings("unused")
	private CharSequence mDrawerTitle;

	private CharSequence mTitle;

	private ArrayList<Icons> icons;
	private SearchMockupDrawerAdapter adapter;
	private String[] MDTitles;
	private TypedArray MDIcons;

	public CircularImageView iv;

	final Context context = this;

	Fragment weather = new WeatherFragment();

	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		SharedPreferences first = PreferenceManager
				.getDefaultSharedPreferences(this);

		if (!first.getBoolean("firstTime", false)) {

			SharedPreferences.Editor editor = first.edit();

			editor.putBoolean("firstTime", true);
			editor.commit();

		}

		final ActionBar actionBar = getActionBar();

		// getActionBar().setTitle("Google Search");

		getActionBar().setIcon(R.drawable.ic_drawer_white);

		SpannableString s = new SpannableString("Google Search");
		s.setSpan(new TypefaceSpan("sans-serif-light"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar.setTitle(s);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		getActionBar().setHomeButtonEnabled(true);

		ImageView view = (ImageView) findViewById(android.R.id.home);
		view.setPadding(16, 0, 0, 0);

		setContentView(R.layout.search_mockup);

		mTitle = mDrawerTitle = getTitle();

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		MDTitles = getResources().getStringArray(
				R.array.navigation_main_sections);

		MDIcons = getResources().obtainTypedArray(R.array.drawable_ids);

		icons = new ArrayList<Icons>();

		icons.add(new Icons(MDTitles[0], MDIcons.getResourceId(0, -1)));

		icons.add(new Icons(MDTitles[1], MDIcons.getResourceId(1, -2)));

		icons.add(new Icons(MDTitles[2], MDIcons.getResourceId(2, -3)));

		icons.add(new Icons(MDTitles[3], MDIcons.getResourceId(3, -4)));

		MDIcons.recycle();

		adapter = new SearchMockupDrawerAdapter(getApplicationContext(), icons);
		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		LayoutInflater inflater = getLayoutInflater();
		final ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header,
				mDrawerList, false);

		mDrawerList.addHeaderView(header, null, false);

		mDrawerToggle = new ActionBarDrawerToggle(

		this, mDrawerLayout, android.R.color.transparent, R.string.drawer_open,
				R.string.drawer_close)

		{
			public void onDrawerClosed(View view) {

				getActionBar().setIcon(R.drawable.ic_drawer_white);
				setActionBarTitle();
				invalidateOptionsMenu();

			}

			public void onDrawerOpened(View drawerView) {

				getActionBar().setIcon(R.drawable.ic_drawer_white);
				setActionBarTitle();
				invalidateOptionsMenu();

			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {

			selectItem(0);
		}
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.search_mockup, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (mDrawerToggle.onOptionsItemSelected(item)) {

			return true;
		}
		switch (item.getItemId()) {

		default:

		}
		;

		return super.onOptionsItemSelected(item);
	}

	private void setActionBarTitle() {
		SpannableString s = new SpannableString("Google Search");
		s.setSpan(new TypefaceSpan("sans-serif-light"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		getActionBar().setTitle(s);

	}

	private void selectItem(int position) {

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		switch (position) {

		case 0:
			ft.replace(R.id.content_frame, weather);
			break;

		case 1:
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;

		case 5:
			break;

		}

		ft.commit();

		mDrawerList.setItemChecked(position, true);

		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {

		super.onPostCreate(savedInstanceState);

		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);

		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	public static class CategoriesFragment extends Fragment {

		public static final String ARG_CATEGORY = "category";

		public CategoriesFragment() {

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.fragment_categories,
					container, false);

			int i = getArguments().getInt(ARG_CATEGORY);

			String List = getResources().getStringArray(
					R.array.navigation_main_sections)[i];

			getActivity().setTitle(List);

			return rootView;

		}
	}
}
