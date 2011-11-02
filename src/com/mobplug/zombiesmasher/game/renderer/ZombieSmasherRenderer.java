package com.mobplug.zombiesmasher.game.renderer;

import java.util.Collection;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.mobplug.android.games.framework.AndroidGameRenderer2D;
import com.mobplug.zombiesmasher.game.GameObjectManager;
import com.mobplug.zombiesmasher.game.ZombieSmasherGame;
import com.mobplug.zombiesmasher.game.entities.GameObject;
import com.mobplug.zombiesmasher.game.entities.Human;
import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class ZombieSmasherRenderer extends AndroidGameRenderer2D<ZombieSmasherGame> {
	private Paint zombiePaint;
	private Paint humanPaint;
	private Paint shiftingPaint;
	private Paint bluePaint;
	private Paint backgroundPaint;	
	
	public ZombieSmasherRenderer(SurfaceHolder holder, ZombieSmasherGame game) {
		super(holder, game);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(Color.WHITE);		
		bluePaint = new Paint();
		bluePaint.setColor(Color.BLUE);
		zombiePaint = new Paint();
		zombiePaint.setColor(Color.RED);
		shiftingPaint = new Paint();
		shiftingPaint.setColor(Color.GRAY);
		humanPaint = new Paint();
		humanPaint.setColor(Color.GREEN);
	}

	@Override
	public void render(Canvas canvas) {
		canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), shiftingPaint);		
		float bwidth, bheight = 0.0f;
		if (canvas.getWidth() > canvas.getHeight()) {
			bheight = canvas.getHeight();
			bwidth = bheight * 1.6f; 
		} else {
			bwidth = canvas.getWidth();
			bheight = bwidth / 1.6f;
		}
		canvas.drawRect(0, 0, bwidth, bheight, backgroundPaint);		
		Collection<GameObject> objects = game.getGameObjects();
		for (GameObject obj: objects) {
			Paint paint = bluePaint;
			if (obj instanceof Human) {
				Human h = (Human)obj;
				switch(h.getState()) {
					case ALIVE: paint = humanPaint; break;
					case UNDEAD: paint = zombiePaint; break;
					case SHIFTING: paint = shiftingPaint; break;
					default: paint = shiftingPaint;					
				}
			}
			Vector2D vec = obj.getPosition();
			float x = vec.getX() * bwidth / GameObjectManager.BOARD_WIDTH;
			float y = vec.getY() * bheight / GameObjectManager.BOARD_HEIGHT;
			float radius = obj.getCollisionRadius() * bwidth / GameObjectManager.BOARD_WIDTH;
			canvas.drawCircle(x, y, radius, paint);
		}
		
	}

	@Override
	public void setSize(int width, int height) {
		// TODO Auto-generated method stub		
	}

}
