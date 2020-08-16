/*

Question 3.3

*/
package com.practice.exercise;

public class SetOfStacks {
	int stacksInSet, threshold;
	SetStack[] setOfStacks;
	int currentStack;

	SetOfStacks(int n, int t) {
		this.stacksInSet = n;
		this.setOfStacks = new SetStack[n];
		for (int i = 0; i < n; i++) {
			setOfStacks[i] = new SetStack();
		}
		this.currentStack = 0;
		this.threshold = t;
	}

	public static void main(String[] args) {
		SetOfStacks set1 = new SetOfStacks(3, 3);
		// System.out.println(set1.setOfStacks.length);
		// System.out.println(set1.currentStack);
		// System.out.println(set1.threshold);

		set1.push(1);
		set1.push(2);
		set1.push(3);
		set1.push(4);
		set1.push(5);
		set1.push(6);
		set1.push(7);
		set1.push(8);
		set1.push(9);
		set1.push(10);

		System.out.println(set1.pop());
		System.out.println(set1.pop());
		System.out.println(set1.pop());
		System.out.println(set1.pop());
		System.out.println(set1.pop());
		System.out.println(set1.popAt(0));
		System.out.println(set1.popAt(0));
		System.out.println(set1.popAt(0));
		System.out.println(set1.pop());
		System.out.println(set1.pop());

		set1.push(1);
		set1.push(2);
		set1.push(3);
		set1.push(4);
		set1.push(5);
		set1.push(6);
		set1.push(7);

		System.out.println(set1.popAt(1));
		System.out.println(set1.pop());
		System.out.println(set1.pop());


	}

	void push(int x) {
		if (currentStack == stacksInSet) {
			currentStack--;
			System.out.println("Set of stacks completely full!");
			return;
		}

		if (setOfStacks[currentStack].size() == threshold) {
			currentStack++;
			push(x);
			return;
		}

		setOfStacks[currentStack].push(x);
	}

	Integer pop() {
		if (currentStack == 0 && setOfStacks[currentStack].isEmpty()) {
			System.out.println("Set of stacks completely empty!");
			return null;
		}

		if (setOfStacks[currentStack].isEmpty()) {
			currentStack--;
			return pop();
		}

		return setOfStacks[currentStack].pop();
	}

	Integer popAt(int index) {
		if (setOfStacks[index].isEmpty()) {
			System.out.println("Sub-stack " + index + " is empty");
			return null;
		}

		return setOfStacks[index].pop();
	}


}

class SetStack {
	Node top;
	int size;

	void push(int x) {

		Node node = new Node(x);
		if (top == null) {
			top = node;
			size++;
			return;
		}
		node.next = top;
		top = node;
		size++;
	}

	Integer pop() {
		if (top == null) {
			System.out.println("Stack Underflow!");
			size = 0;
			return null;
		}

		Integer tmp = new Integer(top.data);
		top = top.next;
		size--;
		return tmp;
	}

	int size() {
		return this.size;
	}

	boolean isEmpty() {
		if (top == null) {
			return true;
		}
		return false;
	}
}

// class Node {
// 	int data;
// 	Node next;

// 	Node(int d) {
// 		this.data = d;
// 	}
// }