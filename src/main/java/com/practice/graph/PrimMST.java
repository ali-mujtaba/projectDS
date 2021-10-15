package com.practice.graph;

import java.util.HashSet;
import java.util.PriorityQueue;

public class PrimMST<T> {
	EdgeWeightedGraph<T> mst;
	private HashSet<T> visited;
	private PriorityQueue<Edge<T>> edges;
	private double weight;
	public PrimMST(EdgeWeightedGraph<T> G) {
		mst = new EdgeWeightedGraph<>();
		visited = new HashSet<>();
		edges = new PriorityQueue<>();
		weight = 0;

		for (T v : G.getVertices()) {
			visit(G, v);
			while (!this.edges.isEmpty()) {
				Edge<T> min = this.edges.poll();
				T v1 = min.either();
				if (!(this.visited.contains(v1) && this.visited.contains(min.other(v1)))) {
					weight += min.weight();
					if (this.visited.contains(v1)) {
						this.visit(G, min.other(v1));
					} else {
						this.visit(G, v1);
					}
					this.mst.addEdge(min);
				}

			}
			break;
		}
	}

	private void visit(EdgeWeightedGraph<T> G, T v) {
		this.visited.add(v);
		this.mst.addVertex(v);
		for (Edge<T> e : G.adjVertices(v)) {
			if (!visited.contains(e.other(v))) {
				this.edges.offer(e);
			}
		}
	}

	public double weight() {
		return weight;
	}

	public EdgeWeightedGraph<T> mst() {
		return mst;
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

		PrimMST<Integer> pmst = new PrimMST<>(G);
		System.out.println("\n Minimum Spanning Tree:-\n");
		pmst.mst.display();
		System.out.println("Weight: " + pmst.weight());
	}
}