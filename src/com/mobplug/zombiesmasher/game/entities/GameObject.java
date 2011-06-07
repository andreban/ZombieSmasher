package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameObject {
	protected Vector2D position = new Vector2D();
	protected float collisionRadius;
	
	public boolean collidesWith(GameObject other) {
		if (this == other) return false;
		return false;
	}
	
	public Vector2D getPosition() {
		return this.position;
	}
	
	public float getCollisionRadius() {
		return this.collisionRadius;
	}
	
	public void setCollistionRadius(float newRadius) {
		this.collisionRadius = newRadius;
	}
	
	public void update(long gameTime) {
		
	}
}
