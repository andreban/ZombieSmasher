package com.mobplug.zombiesmasher.game.math2d;

public class Vector2D implements Cloneable {
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
	
	public float getLength() {
		return (float)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
    public void normalize() {
        divide(getLength());
    }
    
    public void setLength(float length) {
        normalize();
        multiply(length);
    }
    public void setBearing(float angdeg, float magnitude) {
    	x = magnitude;
    	y = 0;    	
    	rotate(angdeg);
    }  
    
    public void rotate(float cosAngle, float sinAngle) {
        float newX = x*cosAngle - y*sinAngle;
        float newY = x*sinAngle + y*cosAngle;
        x = newX;
        y = newY;
    }
    
    public void setBearing(float bearing) {
        float length = getLength();
        double rads = Math.toRadians(bearing);
        double sin = Math.sin(rads);
        double cos = Math.cos(rads);
        float newy = (float)(sin * length);
        float newx = (float)(cos * length);
        set(newx, newy);
    }    
    
    public void rotate(float angle) {
        rotate((float)Math.cos(angle), (float)Math.sin(angle));
    }

	public float getBearing() {
		double rads = Math.atan2(y,  x);
        return (float)(Math.toDegrees(rads) + 360) % 360 ;
	}

	public float distanceFrom(Vector2D v2d) {
		return (float)Math.abs(Math.sqrt(Math.pow(v2d.x - this.x, 2) + Math.pow(v2d.y - this.y, 2)));
	}
	
	public float bearingFrom(Vector2D v2d) {   
		double rads = Math.atan2((v2d.y - this.y) , (v2d.x - this.x));
        return (float)(Math.toDegrees(rads) + 360) % 360 ;
	}
	
    @Override
    public Vector2D clone() {
        return new Vector2D(x, y);
    }
    
	@Override
	public String toString() {
		return "Vector2D [x=" + x + ", y=" + y + "]";
	}	
    
    public static void main(String[] args) {
        Vector2D p1 = new Vector2D(10, 0);
        Vector2D p2 = new Vector2D(0, -10);        
        System.out.println(p1.bearingFrom(p2));
        
    }
}
