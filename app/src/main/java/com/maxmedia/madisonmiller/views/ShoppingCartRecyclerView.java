package com.maxmedia.madisonmiller.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.maxmedia.madisonmiller.controllers.HomeScreenItemAdapter;

/**
 * Created by Joshua King on 1/20/17.
 */
public class ShoppingCartRecyclerView extends RecyclerView {
	public ShoppingCartRecyclerView (Context context) {
		super(context);
		init();
	}

	public ShoppingCartRecyclerView (Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ShoppingCartRecyclerView (Context context, @Nullable AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init () {
		setAdapter(new HomeScreenItemAdapter(3, getContext(), true));
		setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
	}
}