package com.practice.graph;


import java.util.PriorityQueue;
import java.util.HashSet;

public class KruskalMST<T> {
	private EdgeWeightedGraph<T> mst;
	private double weight;
	public KruskalMST(EdgeWeightedGraph<T> G) {
		mst = new EdgeWeightedGraph<>();
		weight = 0;

		PriorityQueue<Edge<T>> edges = new PriorityQueue<>();
		for (Edge<T> edge : G.edges()) {
			edges.offer(edge);
		}

		while (!edges.isEmpty() && mst.E() < G.V() - 1) {
			Edge<T> edge = edges.poll();
			T v1 = edge.either();
			T v2 = edge.other(v1);
			if (mst.hasVertex(v1) && mst.hasVertex(v2)) {
				if (this.isConnected(mst, v1, v2)) {
					continue;
				}
			}

			if (!mst.hasVertex(v1)) {
				mst.addVertex(v1);
			}
			if (!mst.hasVertex(v2)) {
				mst.addVertex(v2);
			}

			mst.addEdge(edge);
			weight += edge.weight();

		}
	}

	private boolean isConnected(EdgeWeightedGraph<T> G, T v1, T v2) {
		HashSet<T> visited = new HashSet<>();
		return dfs(G, v1, v2, visited);
	}

	private boolean dfs(EdgeWeightedGraph<T> G, T v1, T v2, HashSet<T> visited) {
		visited.add(v1);
		if (v1 == v2) {
			return true;
		}
		for (Edge<T> e : G.adjVertices(v1)) {
			T neighbour = e.other(v1);
			if (!visited.contains(neighbour)) {
				if (dfs(G, neighbour, v2, visited)) {
					return true;
				}
			}
		}

		return false;
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

		KruskalMST<Integer> kmst = new KruskalMST<>(G);
		System.out.println("\n Minimum Spanning Tree:-\n");
		kmst.mst.display();
		System.out.println("Weight: " + kmst.weight());
	}

}