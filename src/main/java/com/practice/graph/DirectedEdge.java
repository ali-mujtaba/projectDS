package com.practice.graph;

class DirectedEdge<T> implements Comparable<DirectedEdge<T>> {
	private T v1, v2;
	private double weight;

	public DirectedEdge(T v1, T v2, double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public double weight() {
		return this.weight;
	}

	public T from() {
		return this.v1;
	}

	public T to() {
		return v2;
	}

	public int compareTo(DirectedEdge<T> that) {
		if (this.weight > that.weight) {
			return 1;
		}
		if (this.weight < that.weight) {
			return -1;
		}

		return 0;
	}

	public String toString() {

		return v1 + " -> " + v2 + " : " + weight;
	}
}