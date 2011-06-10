package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class Bullet extends GameEntity {
	public Bullet(Vector2D position, float radius, long timeToLive) {
		this.position = position;
		setCollistionRadius(radius);
	}
}
