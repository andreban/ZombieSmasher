package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameEntity extends GameObject {	
	public enum State {ALIVE, DEAD, DESTROYED};
	protected Vector2D speed;

	public GameEntity() {
		speed = new Vector2D();
	}
	
	public GameEntity(Vector2D speed) {
		this.speed = speed;
	}
	
	public Vector2D getSpeed() {
		return speed;
	}

	public void setSpeed(Vector2D speed) {
		this.speed = speed;
	}
	
	public void setBearing(float bearing) {
		
	}		
	
	@Override
	public void update(long gameTime) {
		super.update(gameTime);
		position.add(speed);
	}
	
	@Override
	public boolean isDestroyed() {
		return super.isDestroyed();
	}
	
}
