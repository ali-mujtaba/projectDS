package com.practice.graph;

class Edge<T> implements Comparable<Edge<T>> {
	private T v1, v2;
	private double weight;

	public Edge(T v1, T v2, double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public double weight() {
		return this.weight;
	}

	public T either() {
		return this.v1;
	}

	public T other(T v) {
		return v == v1 ? v2 : v1;
	}

	public int compareTo(Edge<T> that) {
		if (this.weight > that.weight) {
			return 1;
		}
		if (this.weight < that.weight) {
			return -1;
		}

		return 0;
	}

	public String toString() {

		return v1 + " - " + v2 + " : " + weight;
	}
}