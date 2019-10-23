package com.practice.exercisev2;

import java.util.*;

public class MyQueue<T> {
	Stack<T> adderStack;
	Stack<T> removerStack;

	MyQueue() {
		adderStack = new Stack<>();
		removerStack = new Stack<>();
	}

	public static void main(String[] args) {
		MyQueue<Integer> q1 = new MyQueue<>();
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
		while (!removerStack.isEmpty()) {
			adderStack.push(removerStack.pop());
		}

		adderStack.push(x);
	}

	T peek() {
		if (removerStack.isEmpty()) {
			while (!adderStack.isEmpty()) {
				removerStack.push(adderStack.pop());
			}
		}
		return removerStack.peek();
	}

	T remove() {
		if (removerStack.isEmpty()) {
			while (!adderStack.isEmpty()) {
				removerStack.push(adderStack.pop());
			}
		}

		return removerStack.pop();
	}
}