package com.practice.graph;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Dijkstra<T> {
	EdgeWeightedDigraph<T> shortestPath;
	HashMap<T, Double> distance;
	HashMap<T, DirectedEdge<T>> edgeTo;
	Queue<T> toVisit;

	public Dijkstra(EdgeWeightedDigraph<T> G, T source) {
		shortestPath = new EdgeWeightedDigraph<>();
		distance = new HashMap<>();
		edgeTo = new HashMap<>();
		toVisit = new LinkedList<>();

		distance.put(source, 0.0);
		toVisit.offer(source);
		while (!toVisit.isEmpty()) {
			T v = getMin();
			shortestPath.addVertex(v);
			if (v != source) {
				shortestPath.addEdge(edgeTo.get(v));
			}

			for (DirectedEdge<T> e : G.adjVertices(v)) {
				if (!shortestPath.hasVertex(e.to())) {
					relax(e);
					if (!toVisit.contains(e.to())) {
						toVisit.offer(e.to());
					}
				}
			}
		}
	}

	private boolean relax(DirectedEdge<T> edge) {
		if (!distance.containsKey(edge.to()) || distance.get(edge.from()) + edge.weight() < distance.get(edge.to())) {
			distance.put(edge.to(), distance.get(edge.from()) + edge.weight());
			edgeTo.put(edge.to(), edge);
			return true;
		}
		return false;
	}

	private T getMin() {
		T closestV = null;
		for (T v : toVisit) {
			if (closestV == null) {
				closestV = v;
				continue;
			}

			if (distance.get(v) < distance.get(closestV)) {
				closestV = v;
			}
		}

		toVisit.remove(closestV);

		return closestV;
	}

	public double distTo(T v) {
		if (distance.containsKey(v)) {
			return distance.get(v);
		}

		return Double.POSITIVE_INFINITY;
	}

	public boolean hasPathTo(T v) {
		return edgeTo.containsKey(v);
	}

	public Iterable<DirectedEdge<T>> pathTo(T v) {
		if (hasPathTo(v)) {
			LinkedList<DirectedEdge<T>> path = new LinkedList<>();
			while (edgeTo.containsKey(v)) {
				DirectedEdge<T> e = edgeTo.get(v);
				path.addFirst(e);
				v = e.from();
			}
			return path;
		}
		return null;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph<Integer> G = new EdgeWeightedDigraph<>();
		for (int i = 1; i < 7; i++) {
			G.addVertex(i);
		}

		G.addEdge(new DirectedEdge<Integer>(1, 2, 50));
		G.addEdge(new DirectedEdge<Integer>(1, 3, 45));
		G.addEdge(new DirectedEdge<Integer>(1, 4, 10));
		G.addEdge(new DirectedEdge<Integer>(2, 3, 10));
		G.addEdge(new DirectedEdge<Integer>(2, 4, 15));
		G.addEdge(new DirectedEdge<Integer>(3, 5, 30));
		G.addEdge(new DirectedEdge<Integer>(4, 1, 10));
		G.addEdge(new DirectedEdge<Integer>(4, 5, 15));
		G.addEdge(new DirectedEdge<Integer>(5, 2, 20));
		G.addEdge(new DirectedEdge<Integer>(5, 3, 35));
		G.addEdge(new DirectedEdge<Integer>(6, 5, 3));

		Dijkstra<Integer> d = new Dijkstra<>(G, 1);
		d.shortestPath.display();
		System.out.println(d.hasPathTo(6));
		System.out.println(d.hasPathTo(3));
		System.out.println(d.pathTo(2));
		System.out.println(d.distTo(2));

	}
}