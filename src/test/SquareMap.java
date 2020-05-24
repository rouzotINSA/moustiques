package test;

import java.util.ArrayList;

import models.Node;

public class SquareMap extends Map{
	
	private int size;
	
	public SquareMap(int size) {
		this.size = size;
	}
	
	/*
	 * Crée une map carré de taille n, place les noeuds et les relie entre eux
	 */
	public ArrayList<Node> initMap() {
		int index = 0;
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				Node currentNode = new Node(index, i, j);
				System.out.println(currentNode.toString());
				this.map.add(currentNode);
				index++;
			}			
		}
		buildArcs(this.map);
		return this.map;
	}
}
