package cr.ac.ulead.entidades;

public class Node {

	public Persona data; 
	public Node leftChild; 
	public Node rightChild; 

	public void displayNode() 
	{
		System.out.print('{');
		System.out.print(data.toString());
		System.out.print("} ");
	}

}
