package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class EdgeWeightedGraph<T> {
	private int V, E;
	private HashMap<T, ArrayList<Edge<T>>> adjList;
	public EdgeWeightedGraph() {
		adjList = new HashMap<>();
	}

	public int V() {
		return this.V;
	}

	public int E() {
		return this.E;
	}

	public boolean addEdge(Edge<T> e) {
		if (this.adjList.containsKey(e.either()) && this.adjList.containsKey(e.other(e.either()))) {
			this.adjList.get(e.either()).add(e);
			this.adjList.get(e.other(e.either())).add(e);
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
			this.adjList.put(v, new ArrayList<Edge<T>>());
			(this.V)++;
			return true;
		}

		return false;
	}

	public boolean hasVertex(T v) {
		return this.adjList.containsKey(v);
	}

	Iterable<Edge<T>> adjVertices(T v) {
		return this.adjList.get(v);
	}

	Iterable<Edge<T>> edges() {
		HashSet<Edge<T>> edgeSet = new HashSet<>();
		for (ArrayList<Edge<T>> edgeList : this.adjList.values()) {
			for (Edge<T> e : edgeList) {
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
		EdgeWeightedGraph<Integer> G = new EdgeWeightedGraph<>();
		for (int i = 0; i < 8; i++) {
			G.addVertex(i);
		}

		G.addEdge(new Edge<Integer>(4, 5, .35));
		G.addEdge(new Edge<Integer>(4, 7, .37));
		G.addEdge(new Edge<Integer>(5, 7, .28));
		G.addEdge(new Edge<Integer>(0, 7, .16));
		G.addEdge(new Edge<Integer>(1, 5, .32));
		G.addEdge(new Edge<Integer>(0, 4, .38));
		G.addEdge(new Edge<Integer>(2, 3, .17));
		G.addEdge(new Edge<Integer>(1, 7, .19));
		G.addEdge(new Edge<Integer>(0, 2, .26));
		G.addEdge(new Edge<Integer>(1, 2, .36));
		G.addEdge(new Edge<Integer>(1, 3, .29));
		G.addEdge(new Edge<Integer>(2, 7, .34));
		G.addEdge(new Edge<Integer>(6, 2, .40));
		G.addEdge(new Edge<Integer>(3, 6, .52));
		G.addEdge(new Edge<Integer>(6, 0, .58));
		G.addEdge(new Edge<Integer>(6, 4, .93));

		G.display();

		System.out.println(G.edges());
	}
}
