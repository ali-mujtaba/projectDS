package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class EdgeWeightedDigraph<T> {
	private int V, E;
	private HashMap<T, ArrayList<DirectedEdge<T>>> adjList;
	public EdgeWeightedDigraph() {
		adjList = new HashMap<>();
	}

	public int V() {
		return this.V;
	}

	public int E() {
		return this.E;
	}

	public boolean addEdge(DirectedEdge<T> e) {
		if (this.adjList.containsKey(e.from()) && this.adjList.containsKey(e.to())) {
			this.adjList.get(e.from()).add(e);
			(this.E)++;
			return true;
		}

		return false;
	}

	public Iterable<T> getVertices() {
		return this.adjList.keySet();
	}

	public boolean addVertex(T v) {
		if (!this.adjList.containsKey(v)) {
			this.adjList.put(v, new ArrayList<DirectedEdge<T>>());
			(this.V)++;
			return true;
		}

		return false;
	}

	public boolean hasVertex(T v) {
		return this.adjList.containsKey(v);
	}

	Iterable<DirectedEdge<T>> adjVertices(T v) {
		return this.adjList.get(v);
	}

	Iterable<DirectedEdge<T>> edges() {
		HashSet<DirectedEdge<T>> edgeSet = new HashSet<>();
		for (ArrayList<DirectedEdge<T>> edgeList : this.adjList.values()) {
			for (DirectedEdge<T> e : edgeList) {
				edgeSet.add(e);
			}
		}

		return edgeSet;
	}

	public void display() {
		this.adjList.forEach((vertex, adjVertices) -> {
			System.out.println(vertex + "\t=> " + adjVertices);
		});
	}


	public static void main(String[] args) {
		EdgeWeightedDigraph<Integer> G = new EdgeWeightedDigraph<>();
		for (int i = 0; i < 8; i++) {
			G.addVertex(i);
		}

		G.addEdge(new DirectedEdge<Integer>(4, 5, .35));
		G.addEdge(new DirectedEdge<Integer>(4, 7, .37));
		G.addEdge(new DirectedEdge<Integer>(5, 7, .28));
		G.addEdge(new DirectedEdge<Integer>(0, 7, .16));
		G.addEdge(new DirectedEdge<Integer>(1, 5, .32));
		G.addEdge(new DirectedEdge<Integer>(0, 4, .38));
		G.addEdge(new DirectedEdge<Integer>(2, 3, .17));
		G.addEdge(new DirectedEdge<Integer>(1, 7, .19));
		G.addEdge(new DirectedEdge<Integer>(0, 2, .26));
		G.addEdge(new DirectedEdge<Integer>(1, 2, .36));
		G.addEdge(new DirectedEdge<Integer>(1, 3, .29));
		G.addEdge(new DirectedEdge<Integer>(2, 7, .34));
		G.addEdge(new DirectedEdge<Integer>(6, 2, .40));
		G.addEdge(new DirectedEdge<Integer>(3, 6, .52));
		G.addEdge(new DirectedEdge<Integer>(6, 0, .58));
		G.addEdge(new DirectedEdge<Integer>(6, 4, .93));

		G.display();

		System.out.println("\nEDGES:- \n");
		for (DirectedEdge<Integer> edge : G.edges()) {
			System.out.println(edge);
		}
	}
}
