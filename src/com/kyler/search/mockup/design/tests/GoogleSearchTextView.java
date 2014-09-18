package com.kyler.search.mockup.design.tests;

import com.kyler.search.mockup.material.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class GoogleSearchTextView extends TextView {

	public GoogleSearchTextView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	public GoogleSearchTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);

	}

	public GoogleSearchTextView(Context context) {
		super(context);
		init(null);
	}

	private void init(AttributeSet attrs) {
		if (attrs != null) {
			TypedArray a = getContext().obtainStyledAttributes(attrs,
					R.styleable.GoogleSearchTextView);
			String fontName = a
					.getString(R.styleable.GoogleSearchTextView_fontName);
			if (fontName != null) {
				Typeface myTypeface = Typeface.createFromAsset(getContext()
						.getAssets(), "fonts/" + fontName);
				setTypeface(myTypeface);
			}
			a.recycle();
		}
	}

}