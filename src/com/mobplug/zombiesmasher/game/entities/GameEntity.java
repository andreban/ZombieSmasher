package com.mobplug.zombiesmasher.game.entities;

import java.util.Collection;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public abstract class GameEntity extends GameObject {	
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
	
//	public void setBearing(float bearing) {
//		speed.setBearing(bearing);
//	}		
		
	@Override
	public void update(Collection<GameObject> others, long gameTime) {
		super.update(others, gameTime);		
		position.add(speed);
	}	
}
