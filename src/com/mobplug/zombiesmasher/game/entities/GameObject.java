package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public abstract class GameObject {
	protected Vector2D position = new Vector2D();
	protected float collisionRadius;
	protected long lastGameUpdate = 0L;
	
	public boolean collidesWith(GameObject other) {
		if (this == other) return false;
		float totalRadius = this.getCollisionRadius() + other.getCollisionRadius();
		float diffx = Math.abs(this.getPosition().getX() - other.getPosition().getX());
		float diffy = Math.abs(this.getPosition().getY() - other.getPosition().getY());
		float distance = (float)Math.sqrt(Math.pow(diffx, 2) + Math.pow(diffy, 2));
		boolean collided = distance <= totalRadius;
		if (collided) {
			this.takeDamage(other);
			other.takeDamage(this);
		}
		return collided;		
	}
	
	public void takeDamage(GameObject other) {
		
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
		lastGameUpdate = gameTime;
	}
	
	public abstract boolean isDestroyed();
}
