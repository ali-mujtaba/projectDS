/*

Design a stack which, in addition to push and pop, also has a function min which returns the minimum element.
Push, pop and min should all operate in O(1) time.

*/
package com.practice.exercise;

public class MyStack {
	Node top, min;

	public static void main(String[] args) {
		MyStack stack1 = new MyStack();
		stack1.push(4);
		stack1.push(5);
		System.out.println(stack1.getMin());
		stack1.push(3);
		stack1.push(1);
		stack1.push(2);
		System.out.println(stack1.getMin());

		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());
		stack1.push(1);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());

	}

	void push(int x) {
		Node X = new Node(x);
		if (top == null) {
			top = X;
			updateMin();
			return;
		}

		X.next = top;
		top = X;
		updateMin();
	}

	Integer pop() {
		if (top == null) {
			System.out.println("Stack empty!");
			return null;
		}

		Integer temp = new Integer(top.data);
		top = top.next;
		if (temp == min.data) {
			if (top == null) {
				min = null;
				return temp;
			}
			min = top;
			Node current = top.next;
			while (current != null) {
				if (current.data < min.data) {
					min = current;
				}
				current = current.next;
			}
		}
		return temp;
	}

	void updateMin() {
		if (min == null) {
			min = top;
			return;
		}

		if (top.data < min.data) {
			min = top;
		}
	}

	Integer getMin() {
		if (min == null) {
			return null;
		}

		return min.data;
	}
}

class Node {
	int data;
	Node next;

	Node(int d) {
		this.data = d;
		this.next = null;
	}
}