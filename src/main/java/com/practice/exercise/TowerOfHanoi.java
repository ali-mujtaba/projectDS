/*

Solution of classical problem of Tower of Hanoi using queues.

*/
package com.practice.exercise;

import java.util.*;

public class TowerOfHanoi {
	public static void main(String[] args) {
		Queue<Integer> q1 = new PriorityQueue<>();
		Queue<Integer> q2 = new PriorityQueue<>();
		Queue<Integer> q3 = new PriorityQueue<>();

		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);

		System.out.println("Queue1: " + q1);

		while (!q1.isEmpty()) {

			while (!q2.isEmpty()) {
				q3.add(q2.remove());
			}

			q2.add(q1.remove());

			while (!q3.isEmpty()) {
				q2.add(q3.remove());
			}
		}

		while (!q2.isEmpty()) {
			q3.add(q2.remove());
		}

		System.out.println("Queue1: " + q1);
		System.out.println("Queue2: " + q2);
		System.out.println("Queue3: " + q3);
	}
}