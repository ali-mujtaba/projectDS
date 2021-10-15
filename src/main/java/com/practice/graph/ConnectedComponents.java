package com.practice.graph;

import java.util.HashSet;
import java.util.HashMap;

public class ConnectedComponents<T> {
	private HashSet<T> visited;
	private HashMap<T, Integer> componentId;
	int count = 1;

	ConnectedComponents(Graph<T> G) {
		visited = new HashSet<>(G.V());
		componentId = new HashMap<>(G.V());
		for (T vertex : G.getVertices()) {
			if (!visited.contains(vertex)) {
				dfs(G, vertex);
				count++;
			}
		}
	}

	void dfs(Graph<T> G, T source) {
		this.visited.add(source);
		this.componentId.put(source, count);
		for (T n : G.adjVertices(source)) {
			if (!visited.contains(n)) {
				dfs(G, n);
			}
		}
	}

	boolean connected(T v1, T v2) {
		return this.getComponentId(v1) == this.getComponentId(v2);
	}

	int count() {
		return count - 1;
	}

	int getComponentId(T v) {
		return componentId.get(v);
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

		ConnectedComponents<Integer> cc = new ConnectedComponents<>(G);
		System.out.println(cc.getComponentId(8));
		System.out.println(cc.getComponentId(4));
		System.out.println(cc.getComponentId(0));
		System.out.println(cc.getComponentId(12));

		System.out.println("No. of components: " + cc.count());
	}
}