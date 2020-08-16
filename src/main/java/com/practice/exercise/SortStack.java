/*

Write a program to sort the stack in ascending order.
You may use at most one additional stack to hold items and not any other data structures.

*/
package com.practice.exercise;

import java.util.*;
public class SortStack {

	Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {

		SortStack obj = new SortStack();
		obj.stack.push(3);
		obj.stack.push(1);
		obj.stack.push(2);
		obj.stack.push(5);
		obj.stack.push(4);
		System.out.println("Stack: " + obj.stack);
		obj.stack = obj.sortStack();
		System.out.println("Stack: " + obj.stack);
		System.out.println("Top element: " + obj.stack.peek());

	}

	Stack<Integer> sortStack() {
		int n = 0;
		Stack<Integer> bufferStack = new Stack<>();
		while (!this.stack.isEmpty()) {
			bufferStack.push(this.stack.pop());
			n++;
		}

		for (; n > 0; n--) {
			int min = bufferStack.pop();

			for (int m = n - 1; m > 0; m--) {
				if (bufferStack.peek() < min) {
					this.stack.push(min);
					min = bufferStack.pop();
					continue;
				}
				this.stack.push(bufferStack.pop());
			}
			bufferStack.push(min);

			while (!this.stack.isEmpty()) {
				bufferStack.push(this.stack.pop());
			}
		}
		return bufferStack;
	}


}