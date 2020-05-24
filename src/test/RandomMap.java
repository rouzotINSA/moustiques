package test;

import java.util.ArrayList;

import models.Node;

public class RandomMap extends Map {

	private int size;
	
	public RandomMap(int size) {
		this.size = size;
	}
	
	
	/*
	 * Crée une map carré de taille n, place les noeuds et les relie entre eux
	 */
	public ArrayList<Node> initMap() {
		int index = 0;
		for(int i = 0; i < this.size; i++) {
			// On initialise la map avec n points positionés aléatoirement entre O.O et 10.0
			Node currentNode = new Node(index,(float) Math.random()*10,(float) Math.random()*10);
			System.out.println(currentNode.toString());
			this.map.add(currentNode);
			index++;
		}			
		buildArcs(this.map);
		return this.map;
	}
}
