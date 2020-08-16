/*

Implement 3 stacks in 1 array

*/
package com.practice.exercise;

public class ThreeStacks {
	int[] arr;
	int cap1, cap2, cap3, frontTop, midTop, rearTop;

	ThreeStacks(int c1, int c2, int c3) {
		this.cap1 = c1;
		this.cap2 = c2;
		this.cap3 = c3;
		this.arr = new int[this.cap1 + this.cap2 + this.cap3];
		this.frontTop = -1;
		this.rearTop = this.arr.length;
		this.midTop = this.cap1 - 1;
	}

	public static void main(String[] args) throws Exception {
		ThreeStacks obj = new ThreeStacks(4, 2, 3);

		obj.pushToStack1(2);
		obj.pushToStack1(3);
		obj.pushToStack1(4);
		obj.pushToStack1(5);
		obj.pushToStack1(6);
		// obj.pushToStack1(7);

		obj.pushToStack2(7);
		obj.pushToStack2(8);
		obj.pushToStack2(9);

		obj.pushToStack3(10);
		obj.pushToStack3(11);
		obj.pushToStack3(12);
		obj.pushToStack3(13);

		System.out.println("Stack2: " + obj.popFromStack2());
		System.out.println("Stack2: " + obj.popFromStack2());

		System.out.println("Stack1: " + obj.popFromStack1());
		System.out.println("Stack1: " + obj.popFromStack1());

		System.out.println("Stack2: " + obj.popFromStack2());
		System.out.println("Stack2: " + obj.popFromStack2());

		System.out.println("Stack3: " + obj.popFromStack3());
		System.out.println("Stack3: " + obj.popFromStack3());

		System.out.println("Stack1: " + obj.popFromStack1());
		System.out.println("Stack1: " + obj.popFromStack1());
		System.out.println("Stack1: " + obj.popFromStack1());

		System.out.println("Stack3: " + obj.popFromStack3());
		System.out.println("Stack3: " + obj.popFromStack3());






	}

	void pushToStack1(int x) {
		if (this.frontTop == cap1 - 1) {
			System.out.println("Stack1 Overflow! ");
			return;
		}
		this.frontTop++;
		arr[this.frontTop] = x;
	}

	void pushToStack2(int x) {
		if (midTop == (cap1 + cap2 - 1)) {
			System.out.println("Stack2 Overflow!");
		}
		midTop++;
		arr[midTop] = x;
	}

	void pushToStack3(int x) {
		if (rearTop == (cap1 + cap2 + 1)) {
			System.out.println("Stack3 Overflow! ");
			return;
		}
		rearTop--;
		arr[rearTop] = x;
	}

	Integer popFromStack1() {
		if (frontTop == -1) {
			System.out.println("Stack1 Underflow! ");
			return null;
		}
		Integer temp = new Integer(arr[frontTop]);
		frontTop--;
		return temp;
	}

	Integer popFromStack2() {
		if (midTop == cap1) {
			System.out.println("Stack2 Underflow! ");
			return null;
		}
		Integer temp = new Integer(arr[midTop]);
		midTop--;
		return temp;
	}

	Integer popFromStack3() {
		if (rearTop == arr.length) {
			System.out.println("Stack3 Underflow! ");
			return null;
		}
		Integer temp = new Integer(arr[rearTop]);
		rearTop--;
		return temp;
	}
}