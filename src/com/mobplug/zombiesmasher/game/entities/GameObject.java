package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameObject {
	protected Vector2D position;
	protected float collisionRadius;
	
	public boolean collidesWith(GameObject other) {
		if (this == other) return false;
		return false;
	}
}
