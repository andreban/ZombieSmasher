package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class Weapon {
//	public static enum State{READY, FIRING, RELOADING}
	
	private static final long FIRE_RATE_INTERVAL = 300l;
	private static final long RELOAD_TIME = 1000l;
	private static final int CLIP_SIZE = 5;
	
	private long nextFireTime = 0L;
	private int bulletCount = CLIP_SIZE;	
//	private State state = State.READY;
	
	public boolean canFire(long gameTime) {
		if (gameTime > nextFireTime && bulletCount > 0) {
//			state = State.READY;
			return true;
		}
		return false;
	}
	
	public void reload(long gameTime) {
		bulletCount = CLIP_SIZE;
		nextFireTime = gameTime + RELOAD_TIME;		
//		state = State.RELOADING;
	}
	
	public Bullet fire(long gameTime, float x, float y) {
		if (!canFire(gameTime)) return null;
		Bullet bullet = new Bullet(new Vector2D(x, y), gameTime);	
		nextFireTime = gameTime + FIRE_RATE_INTERVAL;
//		state = State.FIRING;
		//bulletCount--;
		return bullet;
	}
	
}
