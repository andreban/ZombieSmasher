package com.mobplug.zombiesmasher.game.entities;

public class Player {
	private Weapon currentWeapon;
	
	public void fire(int x, int y) {
		currentWeapon.fire(x, y);
	}
}
