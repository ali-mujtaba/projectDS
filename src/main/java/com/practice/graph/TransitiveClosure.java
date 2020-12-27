package com.practice.graph;

import java.util.HashMap;

public class TransitiveClosure<T> {
	private HashMap<T, Integer> index;
	private boolean[][] adjMatrix;
	TransitiveClosure(Digraph<T> G) {
		index = new HashMap<>();
		adjMatrix = new boolean[G.V()][G.V()];
		int i = 0;
		for (T vertex : G.getVertices()) {
			index.put(vertex, i);
			i++;
		}

		for (T vertex : G.getVertices()) {
			dfs(G, vertex, vertex);
		}

	}

	void showIndex() {
		this.index.forEach((v, i)-> {
			System.out.println(v + "\t" + i);
		});
	}

	void dfs(Digraph<T> G, T source, T current) {
		adjMatrix[index.get(source)][index.get(current)] = true;
		for (T neighbour : G.adjVertices(current)) {
			if (!adjMatrix[index.get(source)][index.get(neighbour)]) {
				dfs(G, source, neighbour);
			}
		}
	}

	boolean[][] get() {
		return adjMatrix;
	}

	boolean reachable(T v1, T v2) {
		return adjMatrix[index.get(v1)][index.get(v2)];
	}
	void show() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[i][j]) {
					System.out.print(" T");
				} else {
					System.out.print(" F");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Digraph<Integer> G = new Digraph<>();
		for (int i = 0; i < 13; i++) {
			G.addVertex(i);
		}

		G.addEdge(0, 1);
		G.addEdge(0, 5);
		G.addEdge(0, 6);
		G.addEdge(2, 0);
		G.addEdge(2, 3);
		G.addEdge(3, 5);
		G.addEdge(5, 4);
		G.addEdge(6, 4);
		G.addEdge(6, 9);
		G.addEdge(7, 6);
		G.addEdge(8, 7);
		G.addEdge(9, 10);
		G.addEdge(9, 11);
		G.addEdge(9, 12);
		G.addEdge(11, 12);

		G.display();

		TransitiveClosure<Integer> closure = new TransitiveClosure<>(G);
		System.out.println("Index:-");
		closure.showIndex();
		System.out.println("\nTransitive Closure Adjacency Matrix:-");
		closure.show();
	}
}