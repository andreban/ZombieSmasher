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
		this.set(v.getX(), v.getY());
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
	
	public float getMagnitude() {
		return (float)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
    public void setBearing(float angdeg, float magnitude) {
        double rads = Math.toRadians(angdeg);
        double sinAngle = Math.sin(rads);
        double cosAngle = Math.cos(rads);
        float newX = (float)(x * cosAngle - y * sinAngle);
        float newY = (float)(x * sinAngle + y * cosAngle);
        set(newX, newY);
    }
    
	public void setBearing(float angdeg) {
		float magnitude = getMagnitude();
        setBearing(angdeg, magnitude);
	}
	

}
