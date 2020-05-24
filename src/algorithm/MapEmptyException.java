package algorithm;


public class MapEmptyException extends Exception{ 

	private static final long serialVersionUID = 1L;

	public MapEmptyException() {
		  System.out.println("La MAP n'a pas été initialisée ou est vide");
	}
}
