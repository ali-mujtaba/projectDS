package com.practice.graph;

import java.util.HashMap;
import java.util.ArrayList;

public class Digraph<T> {
	private int V, E;
	private HashMap<T, ArrayList<T>> adjList;

	public Digraph() {
		this.V = 0;
		this.E = 0;
		adjList = new HashMap<>();
	}

	public int V() {
		return this.V;
	}
	public int E() {
		return this.E;
	}

	public Iterable<T> getVertices() {
		return adjList.keySet();
	}

	// adds undirected edge between v1 and v2
	public boolean addEdge(T v1, T v2) {
		if (adjList.containsKey(v1) && adjList.containsKey(v2)) {
			adjList.get(v1).add(v2);
			(this.E)++;
			return true;
		}
		System.out.println("Either or both the vertices are not a part of the graph!");
		return false;
	}

	// add a new vertex
	public boolean addVertex(T v) {
		if (!adjList.containsKey(v)) {
			adjList.put(v, new ArrayList<T>());
			(this.V)++;
			return true;
		}
		return false;
	}

	// returns list of vertices adjacent to 'v'
	public Iterable<T> adjVertices(T v) {
		return adjList.get(v);
	}

	// represents the graph as Adjacency list
	public void display() {
		this.adjList.forEach((vertex, adjVertices) -> {
			System.out.println(vertex + "\t=> " + adjVertices);
		});
	}

	public Digraph<T> reverse() {
		Digraph<T> reverseG = new Digraph<T>();
		for (T v : this.getVertices()) {
			reverseG.addVertex(v);
		}

		this.adjList.forEach((vertex, neighbours)-> {
			for (T n : neighbours) {
				reverseG.addEdge(n, vertex);
			}
		});

		return reverseG;
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

		G.display();

		System.out.println("Adjacent vertices of 9: " + G.adjVertices(9));

		System.out.println("\nTranspose:- ");
		G.reverse().display();
	}
}