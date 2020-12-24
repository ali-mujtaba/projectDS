package com.practice.graph;

import java.util.HashSet;

public class Cycle<T> {
	private boolean hasCycle;
	private HashSet<T> visited;

	Cycle(Graph<T> G) {
		visited = new HashSet<>(G.V());
		for (T vertex : G.getVertices()) {
			if (!visited.contains(vertex)) {
				dfs(G, vertex, vertex);
			}
		}
	}


	void dfs(Graph<T> G, T current, T previous) {
		this.visited.add(current);
		for (T neighbour : G.adjVertices(current)) {
			if (!this.visited.contains(neighbour)) {
				dfs(G, neighbour, current);
			} else if (neighbour != previous) {
				hasCycle = true;
			}
		}
	}

	boolean hasCycle() {
		return hasCycle;
	}

	public static void main(String[] args) {
		Graph<Integer> G = new Graph<>();
		for (int i = 0; i < 13; i++) {
			G.addVertex(i);
		}

		G.addEdge(0, 5);
		G.addEdge(4, 3);
		G.addEdge(0, 1);
		G.addEdge(9, 12);
		G.addEdge(6, 4);
		G.addEdge(5, 4);

		// un-comment the following to get a graph with loops
		// G.addEdge(0, 2);
		// G.addEdge(11, 12);
		// G.addEdge(9, 10);
		// G.addEdge(0, 6);
		// G.addEdge(7, 8);
		// G.addEdge(9, 11);
		// G.addEdge(5, 3);

		G.display();

		Cycle<Integer> cy = new Cycle<>(G);
		System.out.println(cy.hasCycle);
	}
}