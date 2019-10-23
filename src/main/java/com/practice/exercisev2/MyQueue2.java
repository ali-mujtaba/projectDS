package com.practice.exercisev2;

import java.util.*;

public class MyQueue2<T> {
	Stack<T> stackNew = new Stack<>();
	Stack<T> stackOld = new Stack<>();

	public static void main(String[] args) {
		MyQueue2<Integer> q1 = new MyQueue2<>();
		// System.out.println("Removed: " + q1.remove());
		System.out.println("Add: 5" );
		q1.add(5);
		System.out.println("Add: 3");
		q1.add(3);
		System.out.println("Add: 10");
		q1.add(10);
		System.out.println("Removed: " + q1.remove());
		System.out.println("Peek: " + q1.peek());

	}

	void add(T x) {
		stackNew.push(x);
	}

	T peek() {
		if (stackOld.isEmpty()) {
			shiftOldToNew();
		}
		return stackOld.peek();
	}

	T remove() {
		if (stackOld.isEmpty()) {
			shiftOldToNew();
		}
		return stackOld.pop();
	}
	void shiftOldToNew() {
		while (!stackNew.isEmpty()) {
			stackOld.push(stackNew.pop());
		}
	}

	int size() {
		return (stackOld.size() + stackNew.size());
	}
}