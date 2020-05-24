package test;

import java.util.ArrayList;

import models.Node;

public class LinearMap extends Map {
	
	private int size;
	
	public LinearMap(int size) {
		this.size = size;
	}
	/*
	 * Crée une map ligne de n noeuds, place les noeuds et les relie entre eux
	 */
	public ArrayList<Node> initMap() {
		int index = 0;
		for(int i = 0; i < this.size; i++) {
			Node currentNode = new Node(index, i, 0);
			System.out.println(currentNode.toString());
			this.map.add(currentNode);
			index++;		
		}
		buildArcs(this.map);
		return this.map;
	}
}
