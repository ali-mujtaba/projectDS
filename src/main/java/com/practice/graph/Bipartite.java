package com.practice.graph;

import java.util.HashSet;
import java.util.HashMap;

public class Bipartite<T> {
	private boolean isBipartite;
	private HashSet<T> visited;
	private HashMap<T, Boolean> allottedGroup;
	Bipartite(Graph<T> G) {
		visited = new HashSet<>(G.V());
		allottedGroup = new HashMap<>(G.V());
		isBipartite = true;
		for (T vertex : G.getVertices()) {
			if (!visited.contains(vertex)) {
				dfs(G, vertex, false);
			}
		}
	}

	void dfs(Graph<T> G, T v, boolean group) {
		this.visited.add(v);
		this.allottedGroup.put(v, group);
		for (T neighbour : G.adjVertices(v)) {
			if (!visited.contains(neighbour)) {
				dfs(G, neighbour, !group);
			} else if (this.allottedGroup.get(neighbour) == this.allottedGroup.get(v)) {
				isBipartite = false;
			}
		}
	}

	boolean isBipartite() {
		return isBipartite;
	}

	public static void main(String[] args) {
		Graph<Integer> G = new Graph<>();
		for (int i = 0; i < 13; i++) {
			G.addVertex(i);
		}

		// some edges are removed/un-commented to make a
		// bipartite graph example
		G.addEdge(0, 5);
		// G.addEdge(4, 3);
		G.addEdge(0, 1);
		G.addEdge(9, 12);
		G.addEdge(6, 4);
		G.addEdge(5, 4);
		G.addEdge(0, 2);
		G.addEdge(11, 12);
		G.addEdge(9, 10);
		G.addEdge(0, 6);
		G.addEdge(7, 8);
		// G.addEdge(9, 11);
		// G.addEdge(5, 3);

		G.display();

		Bipartite<Integer> b = new Bipartite<>(G);
		System.out.println(b.isBipartite());

	}
}