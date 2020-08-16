package com.practice;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.PriorityQueue;

public class RouteFinder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int V = 6;
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		// addEdge(adjList, 0, 2);
		addEdge(adjList, 0, 5);
		addEdge(adjList, 1, 3);
		addEdge(adjList, 1, 5);
		addEdge(adjList, 2, 1);
		addEdge(adjList, 2, 4);
		addEdge(adjList, 3, 1);
		addEdge(adjList, 4, 3);
		addEdge(adjList, 5, 4);

		System.out.println(routeExists(adjList, 0, 5));
		System.out.println(routeExists(adjList, 0, 2));
		System.out.println(routeExists(adjList, 0, 1));
	}

	public static ArrayList<ArrayList<Integer>> addEdge(ArrayList<ArrayList<Integer>> adjList, int v1, int v2) {
		adjList.get(v1).add(v2);
		return adjList;
	}

	public static boolean routeExists(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new PriorityQueue<>();
		q.add(source);
		while (!q.isEmpty()) {
			int v = q.remove();
			if (v == destination) {
				return true;
			}
			visited.add(v);
			for (int adjVertex : adjList.get(v)) {
				if (!(visited.contains(adjVertex) || q.contains(adjVertex))) {
					q.add(adjVertex);
				}
			}
		}
		return false;
	}

}