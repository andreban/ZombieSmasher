package com.mobplug.zombiesmasher.game.entities;

public class Player {
	private Weapon currentWeapon = new Weapon();
	
	public Bullet fire(long gameTime, float x, float y) {
		return currentWeapon.fire(gameTime, x, y);
	}
}
