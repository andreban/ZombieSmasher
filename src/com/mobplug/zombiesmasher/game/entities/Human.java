package com.mobplug.zombiesmasher.game.entities;

import java.util.Collection;


public class Human extends GameEntity {
	private static final long DESTROY_TIMEOUT = 1000L;
	private static final long SHIFTING_TIMEOUT = 2000L;
	private static final float UNDEAD_SPEED = 0.5f;
	private static final long FIND_TARGET_TIMEOUT = 1000L;
	public enum State{ALIVE, SHIFTING, UNDEAD, DEAD};
	private long lastStateTime = 0L;
	private State state = State.ALIVE;
	
	private long findTargetTime = 0;
	
	public Human(boolean isUndead, long gameTime) {
		this.state = isUndead ? State.UNDEAD : State.ALIVE;
		if (isUndead) {			
			speed.setBearing(0f, UNDEAD_SPEED);
		}
		this.lastStateTime = gameTime;
	}
	
	@Override
	public void update(Collection<GameObject> others, long gameTime) {	
		lastGameUpdate = gameTime;
		if (this.state == State.SHIFTING && lastStateTime + SHIFTING_TIMEOUT < gameTime) {
			this.state = State.UNDEAD;
			this.speed.setBearing(0f, UNDEAD_SPEED);
			this.lastStateTime = gameTime;
		}
		
		if (this.state == State.UNDEAD) {
			if (findTargetTime < gameTime) {
				GameObject closer = null;
				float bestDistance = Float.POSITIVE_INFINITY;
				
				for (GameObject object: others) {
					if (object == this)
						continue;
					if (!(object instanceof Human))
						continue;
					Human h = (Human)object;
					if (h.getState() != State.ALIVE) 
						continue;
					float distance = this.getPosition().distanceFrom(h.getPosition());
					if (closer == null || distance < bestDistance) {
						closer = object;
						bestDistance = distance;
					}
				}
				if (closer != null) {
					float bearingFrom = getPosition().bearingFrom(closer.getPosition());
					speed.setBearing(bearingFrom);
				}
				findTargetTime = gameTime + FIND_TARGET_TIMEOUT;
			}
			position.add(speed);
		}
	}
		
	@Override
	public boolean collidesWith(GameObject other) {
		if (state == State.DEAD) return false;
		boolean collided = super.collidesWith(other);
		if (other instanceof Bullet) return collided;
		return false;
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
