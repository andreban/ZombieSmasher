package com.mobplug.zombiesmasher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	private static final long SPLASH_TIMEOUT = 3500L;
	private Handler handler = new Handler();
	
	private Runnable mainMenuStarter = new Runnable() {
		public void run() {
			Intent intent = new Intent(SplashActivity.this, MainMenuActivity.class);
			startActivity(intent);
			SplashActivity.this.finish();
		}
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);        
        handler.postDelayed(mainMenuStarter, SPLASH_TIMEOUT);
    }
}