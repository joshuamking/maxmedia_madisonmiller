package com.maxmedia.madisonmiller.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.maxmedia.madisonmiller.R;
import com.maxmedia.madisonmiller.utils.MyUtils;

public class SplashActivity extends AppCompatActivity {
	@Override protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		MyUtils.delayRunnableOnUI(0, () -> {
			startActivity(new Intent(this, MainActivity.class));
			finish();
		});
	}
}
