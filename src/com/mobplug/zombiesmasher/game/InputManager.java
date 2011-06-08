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
		
	public boolean isFirePressed() {
		return firePressed;
	}


	public PointF getFirePoint() {
		return firePoint;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			Log.d(TAG, String.format("Touched %f, %f", event.getX(), event.getY()));
			firePressed = true;
			firePoint.set(event.getX(), event.getY());
		} else {			
			firePressed = false;
		}
		return true;
	}
}
