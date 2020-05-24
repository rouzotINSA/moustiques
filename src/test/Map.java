package test;

import java.util.ArrayList;

import models.Arc;
import models.Node;

public class Map {
	
	public ArrayList<Node> map = new ArrayList<Node>();
	
	
	protected void buildArcs(ArrayList<Node> nodes) {
		for(int i = 0; i < nodes.size(); i++) {
			Node currentNode = this.map.get(i);
			for(int j = 0; j < nodes.size(); j++) {
				if(i != j) {
					Node otherNode = this.map.get(j);
					float arcLenght = (float) Math.sqrt(Math.pow((currentNode.getX() - otherNode.getX()), 2) + Math.pow((currentNode.getY() - otherNode.getY()), 2));
					ArrayList<Node> nodesForTheArc = new ArrayList<Node>();
					nodesForTheArc.add(currentNode);
					nodesForTheArc.add(otherNode);
					Arc arc = new Arc(arcLenght, nodesForTheArc);
					System.out.println(arc.toString());
					currentNode.addArc(arc);		
				}

			}
		}
	}
}
