package com.practice.graph;

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class BreadthFirstSearch<T> {
	private HashSet<T> visited;
	private HashMap<T, T> edgeTo = new HashMap<>();
	private final T source;
	BreadthFirstSearch(Graph<T> G, T s) {
		visited = new HashSet<>(G.V());
		this.source = s;
		System.out.print("Breadth-First Traversal: ");
		bfs(G);
		System.out.println();
	}

	void bfs(Graph<T> G) {
		Queue<T> q = new LinkedList<>();
		q.offer(this.source);
		visited.add(this.source);

		while (!q.isEmpty()) {
			T vertex = q.poll();
			System.out.print(vertex + " ");
			for (T neighbour : G.adjVertices(vertex)) {
				if (!visited.contains(neighbour)) {
					q.offer(neighbour);
					edgeTo.put(neighbour, vertex);
					visited.add(neighbour);
				}
			}
		}
	}

	Iterable<T> pathTo(T v) {
		LinkedList<T> path = new LinkedList<>();
		while (v != this.source) {
			path.addFirst(v);
			v = edgeTo.get(v);
		}

		path.addFirst(v);
		return path;
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

		BreadthFirstSearch<Integer> BFS = new BreadthFirstSearch<>(G, 0);
		System.out.println(BFS.pathTo(4));
	}
}