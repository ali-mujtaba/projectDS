/*

Implement a Queue using 2 stacks

*/
package com.practice.exercise;

import java.io.*;
import java.util.*;
public class MyQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {
		MyQueue myQ = new MyQueue();

		System.out.println(myQ.dequeue());
		myQ.enqueue(3);
		myQ.enqueue(1);
		myQ.enqueue(4);
		System.out.println(myQ.dequeue());
		System.out.println(myQ.peek());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());

	}

	void enqueue(int x) {
		stack1.push(x);
	}

	Integer dequeue() {
		if (stack1.isEmpty()) {
			// System.out.println("Queue is empty!");
			return null;
		}

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		Integer temp = new Integer(stack2.pop());

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return temp;
	}

	Integer peek() {
		if (stack1.isEmpty()) {
			// System.out.println("Queue is empty!");
			return null;
		}

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		Integer temp = new Integer(stack2.peek());

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return temp;
	}
}