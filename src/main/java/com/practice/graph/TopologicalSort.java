package com.practice.graph;

import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;

public class TopologicalSort<T> {
	private HashSet<T> visited;
	private Stack<T> postOrder;
	private ArrayList<T> order;
	TopologicalSort(Digraph<T> G) {
		DirectedCycle<T> dc = new DirectedCycle<>(G);
		if (!dc.hasCycle()) {
			visited = new HashSet<>(G.V());
			postOrder = new Stack<>();
			for (T vertex : G.getVertices()) {
				if (!this.visited.contains(vertex)) {
					dfs(G, vertex);
				}
			}
			order = new ArrayList<T>();
			while (!postOrder.isEmpty()) {
				order.add(postOrder.pop());
			}
		}

	}

	void dfs(Digraph<T> G, T source) {
		this.visited.add(source);
		for (T neighbour : G.adjVertices(source)) {
			if (!this.visited.contains(neighbour)) {
				dfs(G, neighbour);
			}
		}

		this.postOrder.push(source);
	}

	Iterable<T> order() {
		return order;
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

		TopologicalSort<Integer> ts = new TopologicalSort<>(G);
		System.out.println(ts.order());
	}
}