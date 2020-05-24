package models;

import java.util.ArrayList;

public class Arc {
	
	
	/*
	 * Attributes
	 */
	private float length;
	private ArrayList<Node> nodes;
	
	
	/*
	 * Constructor
	 */
	public Arc(float length, ArrayList<Node> nodes) {
		this.setLength(length);
		this.setNodes(nodes);
	}
	
	
	/*
	 * Getters and setters
	 */
	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	public String toString() {
		return "Arc de longueur " + this.length + ", entre les noeuds " + this.nodes.get(0).getID() + " et " + this.nodes.get(1).getID();
	}
	
}	
