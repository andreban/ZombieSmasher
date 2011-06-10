package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class Weapon {
	private int clipSize;
	private long reloadTime;
	private int bulletCount;
	private int damage;
	private float radius = 5f;
	
	public Bullet fire(float x, float y) {
		Bullet bullet = new Bullet(new Vector2D(x, y), radius, 0);
		
		return bullet;
	}
	
}
