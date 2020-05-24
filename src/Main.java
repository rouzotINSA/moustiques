import java.util.ArrayList;

import algorithm.MapEmptyException;
import algorithm.TrapAlgorithm;
import models.Node;
import test.LinearMap;
import test.RandomMap;
import test.SquareMap;

public class Main {
	
	public static void main(String args[]) throws MapEmptyException {
		
		// Choisir ici quel map tester
		// SquareMap map = new SquareMap(); 
		// LinearMap map = new LinearMap(100);
		RandomMap map = new RandomMap(5);
		
		ArrayList<Node> nodes = map.initMap();
		System.out.println("Map : " + nodes);
		float trapRadius = (float) 3; // On peut changer ici la portée du piège
		TrapAlgorithm algorithm = new TrapAlgorithm();
		ArrayList<Node> solution = new ArrayList<Node>();
		
		solution = algorithm.findTrapConfiguration(nodes, trapRadius);
		System.out.println("Nombre de pièges à poser : " + solution.size());
		System.out.println("Noeuds solution : " + solution);
	}
}
