package com.mobplug.zombiesmasher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.mobplug.android.games.framework.GameSurfaceView2D;
import com.mobplug.games.framework.BaseGameRunnable;
import com.mobplug.games.framework.interfaces.GameRunnable;
import com.mobplug.zombiesmasher.game.InputManager;
import com.mobplug.zombiesmasher.game.ZombieSmasherGame;
import com.mobplug.zombiesmasher.game.renderer.ZombieSmasherRenderer;

public class GameActivity extends Activity {
	private GameRunnable gameRunnable;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.gamelayout);
                
        GameSurfaceView2D surfaceView = (GameSurfaceView2D)findViewById(R.id.gamesurface);
        InputManager im = new InputManager();
        final ZombieSmasherGame game = new ZombieSmasherGame(im);
        ZombieSmasherRenderer renderer = new ZombieSmasherRenderer(surfaceView.getHolder(), game);
        gameRunnable = new BaseGameRunnable<ZombieSmasherGame>(renderer, game);
        surfaceView.init(gameRunnable);     
        surfaceView.setOnTouchListener(im);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		gameRunnable.start();
	}
	
	@Override
	protected void onPause() {
		gameRunnable.stop();
		super.onPause();
	}	
}
