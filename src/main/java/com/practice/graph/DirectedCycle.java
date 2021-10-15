package com.practice.graph;

import java.util.Stack;
import java.util.LinkedList;
import java.util.HashSet;

public class DirectedCycle<T> {
	private HashSet<T> visited;
	private LinkedList<T> cycle;

	DirectedCycle(Digraph<T> G) {
		visited = new HashSet<T>();
		for (T vertex : G.getVertices()) {
			if (!this.visited.contains(vertex) && !hasCycle()) {
				findCycle(G, vertex, new Stack<T>());

			}
		}
	}

	void findCycle(Digraph<T> G, T source, Stack<T> recursivePath) {
		this.visited.add(source);
		recursivePath.push(source);

		for (T n : G.adjVertices(source)) {
			if (!hasCycle()) {
				if (!this.visited.contains(n)) {
					findCycle(G, n, recursivePath);

				} else if (recursivePath.contains(n)) {
					this.cycle = new LinkedList<>();
					this.cycle.addFirst(n);
					for (T v = recursivePath.pop(); v != n; v = recursivePath.pop()) {
						this.cycle.addFirst(v);
					}
					this.cycle.addFirst(n);

					for (T v : cycle) {
						recursivePath.push(v);
					}
					recursivePath.pop();
				}
			}
		}

		recursivePath.pop();
	}

	boolean hasCycle() {
		return cycle != null;
	}

	Iterable<T> cycle() {
		return cycle;
	}
	public static void main(String[] args) {
		Digraph<Integer> G = new Digraph<>();
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

		// un-comment to introduce a directed cycle
		G.addEdge(3, 6);

		G.display();

		DirectedCycle<Integer> dc = new DirectedCycle<>(G);
		System.out.println("is the graph a DAG? " + !dc.hasCycle());
		if (dc.hasCycle()) {
			System.out.println("Cycle: " + dc.cycle());
		}
	}
}