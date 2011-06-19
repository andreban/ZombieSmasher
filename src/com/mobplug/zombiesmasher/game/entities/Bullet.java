package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class Bullet extends GameEntity {
	private static final long DEFAULT_DESTROY_TIMEOUT = 1000L * 1L; //1 seconds
	private static final long DEFAULT_TIME_TO_LIVE = 0L;
	private static final float DEFAULT_RADIUS = 5.0f;
	
	public enum State {ALIVE, DEAD, DESTROYED}
	
	private State state = State.ALIVE;
	
	private float radius = DEFAULT_RADIUS;	
	private long timeToLive = DEFAULT_TIME_TO_LIVE;
	private long destroyTimeout = DEFAULT_DESTROY_TIMEOUT;
	
	private long timeCreated;
	private long timeDied;
	
	public Bullet(Vector2D position, long gameTime) {
		timeCreated = gameTime;
		this.position = position;
		setCollistionRadius(radius);
	}
	
	@Override
	public void update(long gameTime) {
		super.update(gameTime);		
		if (state == State.ALIVE && timeCreated + timeToLive < gameTime) {
			state = State.DEAD;
			timeDied = gameTime;
		} else if (state == State.DEAD && timeDied + destroyTimeout < gameTime) {
			state = State.DESTROYED;
		}
	}
	
	public State getState() {
		return this.state;
	}
	@Override
	public boolean isDestroyed() {
		return state == State.DESTROYED;
	}
}
