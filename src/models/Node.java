package models;

import java.util.ArrayList;

public class Node {

	
	/*
	 * Attributes
	 */
	private int ID;
	private float x;
	private float y;
	private int value = 0;
	private ArrayList<Arc> arcs;
	private boolean isMarked = false;
	
	
	/*
	 * Constructor
	 */
	public Node(int ID, float x, float y) {
		setID(ID);
		setX(x);
		setY(y);
		this.setArcs(new ArrayList<Arc>());
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public ArrayList<Arc> getArcs(){
		return arcs;
	}	
	public void setArcs(ArrayList<Arc> arcs){
		this.arcs = arcs;
	}
	public boolean isMarked() {
		return isMarked;
	}
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	
	/*
	 * Methods
	 */
	public void addArc(Arc arc) {
		ArrayList<Arc> arcs = this.getArcs();
		arcs.add(arc);
		this.setArcs(arcs);
	}
	
	public String toString() {
		return "Node ID : " + this.getID() + ", position : (" + this.getX() + ", " + this.getY() + "), " + " value : " + this.getValue();
	}
}
