package com.maxmedia.madisonmiller.screens;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.annimon.stream.Optional;
import com.maxmedia.madisonmiller.R;
import com.maxmedia.madisonmiller.controllers.HomeScreenItemAdapter;
import com.maxmedia.madisonmiller.utils.AnimUtils;
import com.maxmedia.madisonmiller.utils.MyUtils;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
	@BindView (R.id.content_loading_spinner) ProgressBar          contentLoadingSpinner;
	@BindView (R.id.fab)                     FloatingActionButton fab;
	@BindView (R.id.home_screen_rv)          RecyclerView         recyclerView;
	@BindView (R.id.toolbar)                 Toolbar              toolbar;
	private                                  RecyclerView.Adapter adapter;

	@Override protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_with_drawer);
		ButterKnife.bind(this);

		setSupportActionBar(toolbar);
		setTitle("");

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
																 drawer,
																 toolbar,
																 R.string.navigation_drawer_open,
																 R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		AnimUtils.fadeIn(contentLoadingSpinner).start();
		AnimUtils.fadeOut(recyclerView, 0).start();
		MyUtils.delayRunnableOnUI(2000,
								  () -> AnimUtils.fadeOut(contentLoadingSpinner)
												 .withEndAction(() -> AnimUtils.fadeIn(recyclerView, 250).start())
												 .start());

		StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
		recyclerView.setLayoutManager(layoutManager);
		adapter = new HomeScreenItemAdapter(-1, this);
		recyclerView.setAdapter(adapter);

		fab.setOnClickListener(v -> openShoppingCart());
	}

	@Override public void onBackPressed () {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		}
		else {
			super.onBackPressed();
		}
	}

	@SuppressWarnings ("StatementWithEmptyBody") @Override public boolean onNavigationItemSelected (MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.nav_favorites) {
			new AlertDialog.Builder(this).setTitle("Favorite Items")
										 .setMessage(
												 "At this point a new screen would be shown that has a list of the items that the user has favorited. \n\nThere will also be another list of items that have been compiled using in-store metrics based on what the system recognized that you like.")
										 .setIcon(R.drawable.ic_favorited)
										 .setPositiveButton("Okay", null)
										 .show();
		}
		else if (id == R.id.nav_appt) {
			new AlertDialog.Builder(this).setTitle("Appointment")
										 .setMessage(
												 "At this point, a new screen would be shown that allows the user to make an appointment with a stylist.")
										 .setIcon(R.drawable.ic_calendar)
										 .setPositiveButton("Okay", null)
										 .show();
		}
		else if (id == R.id.nav_home) {
			Snackbar.make(toolbar, "You're already home :)", Snackbar.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_settings) {
			Snackbar.make(toolbar, "Will open settings", Snackbar.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_share) {
			Snackbar.make(toolbar, "Will share this your experience with your favorite social app", Snackbar.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_shopping_cart) {
			openShoppingCart();
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override protected void onResume () {
		super.onResume();

		adapter.notifyDataSetChanged();
	}

	private void openShoppingCart () {
		BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
		bottomSheetDialog.setContentView(R.layout.shopping_cart);
		Optional.ofNullable(bottomSheetDialog.findViewById(R.id.checkout_button)).ifPresent(view -> view.setOnClickListener(v -> {
			new AlertDialog.Builder(this).setTitle("Checkout")
										 .setMessage("At this point, the user would be taken through a process of checking out via Android Pay")
										 .setIcon(R.drawable.ic_money)
										 .setCancelable(false)
										 .setPositiveButton("Okay", (dialog, which) -> {
											 bottomSheetDialog.hide();
											 Snackbar.make(toolbar, "Transaction complete.. \uD83D\uDE09", Snackbar.LENGTH_LONG).show();
										 })
										 .show();
		}));
		bottomSheetDialog.show();
	}
}
