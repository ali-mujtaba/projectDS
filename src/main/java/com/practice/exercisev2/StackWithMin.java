package com.practice.exercisev2;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
	public static void main(String[] args) {
		StackWithMin SWM1 = new StackWithMin();
		SWM1.push(34);
		System.out.println(SWM1);
		SWM1.push(48);
		System.out.println("Min: " + SWM1.min());
		SWM1.push(30);
		System.out.println("Min: " + SWM1.min());
		System.out.println("Popped: " + SWM1.pop().data);
		System.out.println("Min: " + SWM1.min());
		System.out.println("Popped: " + SWM1.pop().data);
		System.out.println(SWM1);
		System.out.println("Min: " + SWM1.min());


	}

	void push(int x) {
		int minimum = Math.min(x, min());

		super.push(new NodeWithMin(x, minimum));
	}

	int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return peek().min;
	}
}

class NodeWithMin {
	int data;
	int min;

	NodeWithMin(int d, int m) {
		this.data = d;
		this.min = m;
	}
}