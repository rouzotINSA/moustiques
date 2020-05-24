package algorithm;

import java.util.ArrayList;
import java.util.Iterator;

import models.Arc;
import models.Node;

public class TrapAlgorithm {
	
	/*
	 * Initialise la valeur des noeuds
	 */
	public void setValueToAllNodes(ArrayList<Node> nodes, float trapRadius) {
		for(Node node : nodes) {
			int value = 0;
			for(Arc arc : node.getArcs()) {
				if(arc.getLength() <= trapRadius) {
					value++;
				}
			}
			node.setValue(value);
		}
	}
	
	/*
	 * Retourne le noeud avec la plus petite value de la liste de noeuds 
	 */
	public Node findLowestNode(ArrayList<Node> nodes) throws MapEmptyException {
		if(nodes.isEmpty()) {
			throw new MapEmptyException();
		}
		Node lowestNode = nodes.get(0);
		for(int i = 0; i < nodes.size(); i++) {
			if(lowestNode.getValue() > nodes.get(i).getValue()) {
				lowestNode = nodes.get(i);
			}
		}
		return lowestNode;
	}
	
	
	/*
	 * Retourne le noeud avec la value maximum parmi les voisins du noeud donné
	 */
	public Node findHeighestNeighbor(Node currentNode, float trapRadius) {
		Node heighestNeighbor = currentNode;
		for(int i = 0; i < currentNode.getArcs().size(); i++) {
			if(currentNode.getArcs().get(i).getLength() <= trapRadius) {
				Node challenger = currentNode.getArcs().get(i).getNodes().get(1); // Le noeud à tester dans cette itération
				if(challenger.getValue() >= heighestNeighbor.getValue()) {
					heighestNeighbor = challenger;
				}	
			}
		}
		return heighestNeighbor;
	}
	
	
	/*
	 * Marque les voisins d'un noeuds équipé d'un piège
	 */
	public void updateNodes(Node trapLocation, float trapRadius) {
		trapLocation.setMarked(true);
		for(int i = 0; i < trapLocation.getArcs().size(); i++) {
			if(trapLocation.getArcs().get(i).getLength() <= trapRadius) {
				trapLocation.getArcs().get(i).getNodes().get(1).setMarked(true);
			}
		}
	}
	
	/*
	 * Retourne la liste des noeuds diminué du nombre de noeuds couverts
	 */
	public ArrayList<Node> removeCoveredNodes(ArrayList<Node> nodes){
		Iterator<Node> it = nodes.iterator();
		while(it.hasNext()) {
			Node node = it.next();
			if(node.isMarked()) {
				it.remove();
			}
		}
		return nodes;
	}
	
	/*
	 * La carte de noeuds est définie dans les test JUnit 
	 */
	public ArrayList<Node> findTrapConfiguration(ArrayList<Node> nodes, float trapRadius) throws MapEmptyException {
		
		ArrayList<Node> solution = new ArrayList<Node>();
		
		System.out.println("Initialisation de la valeur des noeuds");
		
		/*
		 * On initialise la value des noeuds
		 */
		setValueToAllNodes(nodes, trapRadius);
		
		System.out.println();
		System.out.println("---------------");
		System.out.println();
		
		
		while(nodes.size() > 0) {
			
			Node currentNode;
			Node heighestNeighbor;
			
			System.out.println("Recherche du noeud de value la plus faible");
			
			/*
			 * On trouve le sommet de plus petite valeur ( le plus excentré )
			 */
			currentNode = findLowestNode(nodes);
			
			System.out.println("Noeud trouvé ! " + currentNode.toString());
			
			
			/*
			 * On trouve le voisin avec la plus grande valeur ( le plus centré )
			 */
			heighestNeighbor = findHeighestNeighbor(currentNode, trapRadius);
			solution.add(heighestNeighbor);
			
			System.out.println("Meilleur voisin trouvé ! " + heighestNeighbor.toString());
			
			/*
			 * On marque les sommets couverts par ce sommet
			 */
			updateNodes(heighestNeighbor, trapRadius);
			
			/*
			 * On supprime les noeuds qui sont déjà marqués
			 */
			nodes = removeCoveredNodes(nodes);
			
			System.out.println();
			System.out.println("---------------");
			System.out.println();
		}
		return solution;
	}
}
