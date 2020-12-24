package com.practice.graph;

import java.util.HashSet;
// import java.util.HashMap;
import java.util.LinkedList;

public class DepthFirstSearch<T> {
	private HashSet<T> visited;
	// HashMap<T, T> edgeTo = new HashMap<>();
	private final T source;
	DepthFirstSearch(Graph<T> G, T s) {
		visited = new HashSet<>(G.V());
		this.source = s;
		System.out.print("Depth-First Traversal: ");
		dfs(G, source);
		System.out.println();

	}

	void dfs(Graph<T> G, T source) {
		this.visited.add(source);
		System.out.print(source + " ");
		for (T vertex : G.adjVertices(source)) {
			if (!visited.contains(vertex)) {
				// edgeTo.put(vertex, source);
				dfs(G, vertex);
			}
		}
	}

	public boolean isConnected(T v) {
		return visited.contains(v);
	}

	// Iterable<T> pathTo(T v) {
	// 	if (!visited.contains(v)) {
	// 		return null;
	// 	}


	// 	LinkedList<T> path = new LinkedList<>();
	// 	while (v != this.source) {
	// 		path.addFirst(v);
	// 		v = edgeTo.get(v);
	// 	}

	// 	path.addFirst(this.source);
	// 	return path;
	// }

	// stateless function for finding path
	Iterable<T> pathTo(Graph<T> G, T v) {
		if (!visited.contains(v)) {
			return null;
		}
		this.visited = new HashSet<>(G.V());
		return getPath(G, this.source, v);
	}

	LinkedList<T> getPath(Graph<T> G, T s, T v) {
		LinkedList<T> path;
		visited.add(s);
		if (s == v) {
			path = new LinkedList<>();
			path.add(s);
			return path;
		}

		for (T neighbour : G.adjVertices(s)) {
			if (!visited.contains(neighbour)) {
				path = getPath(G, neighbour, v);
				if (path != null) {
					path.addFirst(s);
					return path;
				}
			}
		}
		return null;
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
		G.addEdge(0, 2);
		G.addEdge(11, 12);
		G.addEdge(9, 10);
		G.addEdge(0, 6);
		G.addEdge(7, 8);
		G.addEdge(9, 11);
		G.addEdge(5, 3);

		G.display();
		DepthFirstSearch<Integer> DFS = new DepthFirstSearch<>(G, 0);
		// System.out.println(DFS.pathTo(6));
		System.out.println(DFS.pathTo(G, 6));
	}
}