package com.mobplug.zombiesmasher.game.math2d;

public class Vector2D {
	private float x = 0.0f;
	private float y = 0.0f;
	
	public Vector2D() {
		
	}
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D(Vector2D v) {
		this(v.getX(), v.getY());
	}
	
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2D v) {
		this.set(v.getX(), v.getX());
	}
	
	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	public void add(Vector2D v) {
		add(v.getX(), v.getY());
	}
	
	public void subtract(float x, float y) {
		add(-x, -y);
	}
	
	public void subtract(Vector2D v) {
		subtract(v.getX(), v.getY());
	}
	
	public void multiply(float magnitude) {
		x *= magnitude;
		y *= magnitude;
	}
	
	public void divide(float magnitude) {
		x /= magnitude;
		y /= magnitude;
	}
}
