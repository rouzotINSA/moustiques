package models;

public class Trap {

	
	/*
	 * Attributes
	 */
	private float x;
	private float y;
	private float radius;
	
	
	/*
	 * Constructor
	 */
	public Trap(float x, float y, float radius) {
		setX(x);
		setY(y);
		setRadius(radius);
	}
	
	
	/*
	 * Getters and setters
	 */
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
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
}
