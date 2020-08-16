package com.practice.exercisev2;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> minStack;

	StackWithMin2() {
		minStack = new Stack<>();
	}

	public static void main(String[] args) {
		StackWithMin2 SWM2 = new StackWithMin2();
		SWM2.push(34);
		System.out.println(SWM2);
		SWM2.push(48);
		System.out.println("Min: " + SWM2.min());
		SWM2.push(30);
		System.out.println("Min: " + SWM2.min());
		SWM2.push(30);
		System.out.println("Min: " + SWM2.min());
		System.out.println("Popped: " + SWM2.pop());
		System.out.println("Popped: " + SWM2.pop());
		System.out.println("Min: " + SWM2.min());
		System.out.println("Popped: " + SWM2.pop());
		System.out.println(SWM2);
		System.out.println("Min: " + SWM2.min());

	}

	void push(int x) {
		if (x <= min()) {
			minStack.push(x);
		}
		super.push(x);
	}

	Integer min() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}

	public Integer pop() {
		int temp = super.pop();
		if (temp == min()) {
			minStack.pop();
		}
		return temp;
	}
}