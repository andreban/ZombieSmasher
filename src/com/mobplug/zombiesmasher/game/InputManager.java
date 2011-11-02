package com.mobplug.zombiesmasher.game;

import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class InputManager implements OnTouchListener {
	private static final String TAG = InputManager.class.getName();
	private boolean firePressed = false;
	private PointF firePoint = new PointF();
		
	public void setFirePresset(boolean firePressed) {
		this.firePressed = firePressed;
	}
	
	public boolean isFirePressed() {
		return firePressed;
	}


	public PointF getFirePoint() {
		return firePoint;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		float bwidth, bheight = 0.0f;
		if (v.getWidth() > v.getHeight()) {
			bheight = v.getHeight();
			bwidth = bheight * 1.6f; 
		} else {
			bwidth = v.getWidth();
			bheight = bwidth / 1.6f;
		}		
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			Log.d(TAG, String.format("Touched %f, %f", event.getX(), event.getY()));
			float x = GameObjectManager.BOARD_WIDTH * event.getX() / bwidth;
			float y = GameObjectManager.BOARD_HEIGHT * event.getY() / bheight;			
			firePressed = true;
			firePoint.set(x, y);
		} 
		return true;
	}
}
