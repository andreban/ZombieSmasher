package com.mobplug.zombiesmasher.game.renderer;

import java.util.Collection;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.mobplug.android.games.framework.AndroidGameRenderer2D;
import com.mobplug.zombiesmasher.game.ZombieSmasherGame;
import com.mobplug.zombiesmasher.game.entities.GameObject;
import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class ZombieSmasherRenderer extends AndroidGameRenderer2D<ZombieSmasherGame> {
	private Paint bluePaint;
	private Paint backgroundPaint;	
	
	public ZombieSmasherRenderer(SurfaceHolder holder, ZombieSmasherGame game) {
		super(holder, game);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(Color.WHITE);		
		bluePaint = new Paint();
		bluePaint.setColor(Color.BLUE);
	}

	@Override
	public void render(Canvas canvas) {
		canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);		
		Collection<GameObject> objects = game.getGameObjects();
		for (GameObject obj: objects) {
			Vector2D vec = obj.getPosition();
			canvas.drawCircle(vec.getX(), vec.getY(), obj.getCollisionRadius(), bluePaint);
		}
		
	}

	@Override
	public void setSize(int width, int height) {
		// TODO Auto-generated method stub		
	}

}
