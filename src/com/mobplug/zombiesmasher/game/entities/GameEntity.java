package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameEntity extends GameObject {	
	public enum State {ALIVE, DEAD, DESTROYED};
	protected Vector2D speed;

	private State state = State.ALIVE;
	
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
	
	public void takeDamage(GameObject other) {
		if (other instanceof Bullet) {
			Bullet bullet = (Bullet)other;
			if (bullet.getState() == Bullet.State.ALIVE) {
				this.state = State.DESTROYED;
			}
		}
	}
	
	@Override
	public boolean collidesWith(GameObject other) {
		float totalRadius = this.getCollisionRadius() + other.getCollisionRadius();
		float diffx = Math.abs(this.getPosition().getX() - other.getPosition().getX());
		float diffy = Math.abs(this.getPosition().getY() - other.getPosition().getY());
		float distance = (float)Math.sqrt(Math.pow(diffx, 2) + Math.pow(diffy, 2));
		boolean collided = distance <= totalRadius;
		if (collided) takeDamage(other);
		return collided;		
	}
	
	@Override
	public void update(long gameTime) {
		super.update(gameTime);
		position.add(speed);
	}
	
	@Override
	public boolean isDestroyed() {
		return state == State.DESTROYED;
	}
	
}
