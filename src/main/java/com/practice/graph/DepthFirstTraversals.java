package com.practice.graph;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class DepthFirstTraversals<T> {
	private HashSet<T> visited;
	private Queue<T> pre;
	private Queue<T> post;
	DepthFirstTraversals(Digraph<T> G) {
		visited = new HashSet<>(G.V());
		pre = new LinkedList<T>();
		post = new LinkedList<T>();
		for (T vertex : G.getVertices()) {
			if (!this.visited.contains(vertex)) {
				dfs(G, vertex);
			}
		}
	}

	void dfs(Digraph<T> G, T source) {
		this.visited.add(source);
		this.pre.offer(source);
		for (T neighbour : G.adjVertices(source)) {
			if (!this.visited.contains(neighbour)) {
				dfs(G, neighbour);
			}
		}

		this.post.offer(source);
	}

	Iterable<T> preOrder() {
		return pre;
	}

	Iterable<T> postOrder() {
		return post;
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

		DepthFirstTraversals<Integer> traversals = new DepthFirstTraversals<>(G);
		System.out.println("Pre-order: " + traversals.preOrder());
		System.out.println("Post-order: " + traversals.postOrder());
	}
}