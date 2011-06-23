package com.mobplug.zombiesmasher.game.entities;


public class Human extends GameEntity {
	private static final long DESTROY_TIMEOUT = 1000L;
	private static final long SHIFTING_TIMEOUT = 2000L;
	private static final float UNDEAD_SPEED = 0.5f;
	public enum State{ALIVE, SHIFTING, UNDEAD, DEAD};
	private long lastStateTime = 0L;
	private State state = State.ALIVE;
	
	public Human(boolean isUndead, long gameTime) {
		this.state = isUndead ? State.UNDEAD : State.ALIVE;
		if (isUndead) {			
			speed.setBearing(0f, UNDEAD_SPEED);
		}
		this.lastStateTime = gameTime;
	}
	
	@Override
	public void update(long gameTime) {	
		lastGameUpdate = gameTime;
		if (this.state == State.SHIFTING && lastStateTime + SHIFTING_TIMEOUT < gameTime) {
			this.state = State.UNDEAD;
			this.speed.setBearing(0f, UNDEAD_SPEED);
			this.lastStateTime = gameTime;
		}
		
		if (this.state == State.UNDEAD) {
			float bearingdiff = (float)(Math.random() * 90f - 45f);
			speed.setBearing(speed.getBearing() + bearingdiff);
			position.add(speed);
		}
	}
		
	@Override
	public boolean collidesWith(GameObject other) {
		if (state == State.DEAD) return false;
		return super.collidesWith(other);
	}
	
	@Override
	public void takeDamage(GameObject other) {
		//if entity is already dead, return.
		if (this.state == State.DEAD) return;
		
		if (other instanceof Bullet) {
			Bullet bullet = (Bullet)other;
			if (bullet.getState() == Bullet.State.ALIVE) {
				this.lastStateTime = lastGameUpdate;
				this.state = State.DEAD;
			}
		}
		
		if (!this.isUndead()) {
			if (other instanceof Human) {
				Human human = (Human)other;
				if (human.isUndead()) {
					this.lastStateTime = lastGameUpdate;
					this.state = State.SHIFTING;
				}
			}
		}
	
	}

	@Override
	public boolean isDestroyed() {
		return this.state == State.DEAD && lastStateTime + DESTROY_TIMEOUT < lastGameUpdate;
	}
	
	public boolean isUndead() {
		return this.state == State.UNDEAD;
	}
	
	public State getState() {
		return state;
	}

}
