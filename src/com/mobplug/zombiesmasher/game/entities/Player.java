package com.mobplug.zombiesmasher.game.entities;

public class Player {
	private Weapon currentWeapon = new Weapon();
	
	public boolean canFire(long gameTime) {
		return currentWeapon.canFire(gameTime);
	}
	public Bullet fire(long gameTime, float x, float y) {
		return currentWeapon.fire(gameTime, x, y);
	}
}
