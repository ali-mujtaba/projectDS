package com.practice.graph;

import java.util.HashMap;
import java.util.Stack;

public class KosarajuSCC<T> {
	private Stack<T> postOrder;
	private HashMap<T, Integer> componentId;
	private int count = 0;
	public KosarajuSCC(Digraph<T> G) {
		DepthFirstTraversals<T> traversals = new DepthFirstTraversals<>(G.reverse());
		componentId = new HashMap<>();
		postOrder = new Stack<>();
		for (T v : traversals.postOrder()) {
			this.postOrder.push(v);
		}

		while (!this.postOrder.isEmpty()) {
			T v = this.postOrder.pop();
			if (!this.componentId.containsKey(v)) {
				count++;
				dfs(G, v);
			}
		}
	}

	public int count() {
		return count;
	}

	public boolean areStronglyConnected(T v1, T v2) {
		return this.componentId.get(v1) == this.componentId.get(v2);
	}

	HashMap<T, Integer> components() {
		return componentId;
	}


	private void dfs(Digraph<T> G, T source) {
		this.componentId.put(source, count);
		for (T neighbour : G.adjVertices(source)) {
			if (!this.componentId.containsKey(neighbour)) {
				dfs(G, neighbour);
			}
		}
	}
	public static void main(String[] args) {
		Digraph<Integer> G = new Digraph<>();
		for (int i = 0; i < 13; i++) {
			G.addVertex(i);
		}

		G.addEdge(0, 1);
		G.addEdge(0, 5);
		G.addEdge(2, 0);
		G.addEdge(2, 3);
		G.addEdge(3, 2);
		G.addEdge(3, 5);
		G.addEdge(4, 2);
		G.addEdge(4, 3);
		G.addEdge(5, 4);
		G.addEdge(6, 0);
		G.addEdge(6, 4);
		G.addEdge(6, 9);
		G.addEdge(7, 6);
		G.addEdge(7, 8);
		G.addEdge(8, 7);
		G.addEdge(8, 9);
		G.addEdge(9, 10);
		G.addEdge(9, 11);
		G.addEdge(10, 12);
		G.addEdge(11, 4);
		G.addEdge(11, 12);
		G.addEdge(12, 9);
		G.display();

		KosarajuSCC<Integer> kscc = new KosarajuSCC<>(G);
		System.out.println(kscc.components());

		System.out.println(kscc.areStronglyConnected(2, 5));
		System.out.println(kscc.areStronglyConnected(2, 12));

	}
}