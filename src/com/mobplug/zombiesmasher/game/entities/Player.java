package com.mobplug.zombiesmasher.game.entities;

public class Player {
	private Weapon currentWeapon = new Weapon();
	
	public Bullet fire(float x, float y) {
		return currentWeapon.fire(x, y);
	}
}
