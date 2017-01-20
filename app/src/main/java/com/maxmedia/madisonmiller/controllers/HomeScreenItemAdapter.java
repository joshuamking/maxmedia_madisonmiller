package com.maxmedia.madisonmiller.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.maxmedia.madisonmiller.R;
import com.maxmedia.madisonmiller.model.HomeScreenItem;
import com.maxmedia.madisonmiller.screens.HomeScreenItemDetailActivity;
import com.maxmedia.madisonmiller.utils.DataStore;

/**
 * Created by Joshua King on 1/20/17.
 */
public class HomeScreenItemAdapter extends RecyclerView.Adapter {
	private final Context context;
	private final boolean isCheckout;
	private final int     numberOfItemsToShow;

	public HomeScreenItemAdapter (int numberOfItemsToShow, Context context) {
		this.numberOfItemsToShow = numberOfItemsToShow;
		this.context = context;
		this.isCheckout = false;
	}

	public HomeScreenItemAdapter (int numberOfItemsToShow, Context context, boolean isCheckout) {
		this.numberOfItemsToShow = numberOfItemsToShow;
		this.context = context;
		this.isCheckout = isCheckout;
	}

	@Override public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
		View inflate = LayoutInflater.from(context).inflate(isCheckout ? R.layout.checkout_row : R.layout.home_screen_row, parent, false);
		return new RecyclerView.ViewHolder(inflate) { };
	}

	@Override public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
		HomeScreenItem homeScreenItem = DataStore.getHomeScreenItems().get(position);
		((TextView) holder.itemView.findViewById(R.id.product_name)).setText(homeScreenItem.getProductName());
		((TextView) holder.itemView.findViewById(R.id.product_price)).setText(homeScreenItem.getProductPrice());
		((ImageView) holder.itemView.findViewById(R.id.product_image)).setImageResource(homeScreenItem.getProductImage());

		holder.itemView.setOnClickListener(v -> {
			Intent intent = new Intent(context, HomeScreenItemDetailActivity.class);
			intent.putExtra(HomeScreenItemDetailActivity.HOME_SCREEN_ITEM, homeScreenItem);
			context.startActivity(intent);
		});
	}

	@Override public int getItemCount () {
		return numberOfItemsToShow <= 0 ? DataStore.getHomeScreenItems().size() : numberOfItemsToShow;
	}
}
