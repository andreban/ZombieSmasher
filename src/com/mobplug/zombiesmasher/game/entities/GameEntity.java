package com.mobplug.zombiesmasher.game.entities;

import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameEntity extends GameObject {	
	public enum State {DEAD, ALIVE}; //technically, zombies are not alive :P
	protected Vector2D speed;
	private int life;
}
