package com.kyler.search.mockup.material.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyler.search.mockup.material.R;

public class WeatherFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		SpannableString s = new SpannableString("Google Now");
		s.setSpan(new TypefaceSpan("sans-serif-thin"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		getActivity().getActionBar().setTitle(s);

		View rootView = inflater.inflate(R.layout.weather_fragment, container,
				false);
		return rootView;
	}
}
