package com.maxmedia.madisonmiller.screens;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.maxmedia.madisonmiller.R;
import com.maxmedia.madisonmiller.model.HomeScreenItem;
import com.maxmedia.madisonmiller.utils.DataStore;

public class HomeScreenItemDetailActivity extends AppCompatActivity {
	public static final String HOME_SCREEN_ITEM = "home_screen_item";
	@BindView (R.id.fab)                  FloatingActionButton fab;
	@BindView (R.id.product_description)  TextView             productDescription;
	@BindView (R.id.product_image)        ImageView            productImage;
	@BindView (R.id.product_name)         TextView             productName;
	@BindView (R.id.product_price)        TextView             productPrice;
	@BindView (R.id.product_share_button) ImageButton          productShareButton;
	private                               HomeScreenItem       homeScreenItem;

	@Override protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen_item_detail);
		ButterKnife.bind(this);

		homeScreenItem = (HomeScreenItem) getIntent().getSerializableExtra(HOME_SCREEN_ITEM);
		productImage.setImageResource(homeScreenItem.getProductImage());
		productName.setText(homeScreenItem.getProductName());
		productPrice.setText(homeScreenItem.getProductPrice());
		productDescription.setText(homeScreenItem.getProductDescription());

		productShareButton.setOnClickListener(v -> Snackbar.make(v,
																 "Will share this item with your favorite social app",
																 Snackbar.LENGTH_LONG).show());

		fab.setOnClickListener(view -> {
			homeScreenItem.setFavorited(!homeScreenItem.isFavorited());
			DataStore.getHomeScreenItems().remove(homeScreenItem);
			DataStore.getHomeScreenItems().add(homeScreenItem);
			String un = homeScreenItem.isFavorited() ? "" : "un";
			updateFabIcon();
			Snackbar.make(view, "Item " + un + "favorited!", Snackbar.LENGTH_LONG).setAction("Undo", v -> view.callOnClick()).show();
		});

		updateFabIcon();
	}

	private void updateFabIcon () {
		fab.setImageResource(homeScreenItem.isFavorited() ? R.drawable.ic_favorited : R.drawable.ic_unfavorited);
	}
}
