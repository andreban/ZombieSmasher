package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameEntity {	
	public enum State {DEAD, ALIVE}; //technically, zombies are not alive :P
	private Vector2D position;
	private Vector2D speed;
	private int life;
}
