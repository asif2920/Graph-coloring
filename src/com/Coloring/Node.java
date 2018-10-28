package com.Coloring;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Node {

	int V;
	LinkedList<Integer> adj[];
	public Node(int v) {
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	/*public void printNode() {
		
		for(int h=0;h<adj.length;h++) {
			for(int c=0;c<adj[h].size();c++) {
			System.out.print(adj[h].get(c)+" ");
			}
		}
	}*/
	
	/**
	 * Two arrays are used for this part
	 * Result array is an integer array which stores all the
	 * value for graph
	 * Array available: this is a boolean array
	 * whose value is changed to obtain some desired
	 * outcome
	 */
    public void graphColoring()
    {
        int result[] = new int[V];
 
        // Initialize all vertices as unassigned
        Arrays.fill(result, -1);
 
        // Assign the first color to first vertex
        result[0]  = 0;
 
        // A temporary array to store the available colors. False
        // value of available[cr] would mean that the color cr is
        // assigned to one of its adjacent vertices
        boolean available[] = new boolean[V];
         
        // Initially, all colors are available
        Arrays.fill(available, true);
 
        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++)
        {
            // Process all adjacent vertices and flag their colors
            // as unavailable
            Iterator<Integer> it = adj[u].iterator() ;
            while (it.hasNext())
            {
                int i = it.next();
                if (result[i] != -1) {
                    available[result[i]] = false;
                }
            }
 
            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++){
                if (available[cr])
                    break;
            }
           System.out.println("Before Assiging, Color is: "+cr+" Node: "+u);
            result[u] = cr; // Assign the found color
 
            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }
 
        // print the result
        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color "
                                + result[u]);
    }
}
