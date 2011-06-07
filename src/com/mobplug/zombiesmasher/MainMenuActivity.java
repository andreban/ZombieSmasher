package com.mobplug.zombiesmasher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		
		Button button = (Button)findViewById(R.id.newgame);
		button.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent newGameIntent = new Intent(MainMenuActivity.this, GameActivity.class);
				startActivity(newGameIntent);				
			}
		});
	}
}
