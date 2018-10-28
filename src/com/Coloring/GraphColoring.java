package com.Coloring;
/**
 * 
 * @author Asif
 * This is a greedy algorithm for graph coloring
 * 
 *
 */
public class GraphColoring {

	public static void main(String[] args) {
		Node n=new Node(5);
		n.addEdge(0, 1);
		n.addEdge(0, 2);
		n.addEdge(1, 3);
		n.addEdge(2, 3);
		n.addEdge(3, 4);
		n.graphColoring();

	}

}
