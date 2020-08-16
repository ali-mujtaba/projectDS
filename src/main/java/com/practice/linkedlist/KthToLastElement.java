/*
Implement an algorithm to find the kth to last element of a singly linked list.
*/

package com.practice.linkedlist;

import java.util.Scanner;
public class KthToLastElement {
	public static void main(String[] args) {

		Node head = RemoveDuplicates.seedList();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter k: ");
		int k = scanner.nextInt();

		Node element = getKthToLastElement(head, k);
		System.out.println("k-th element from last: " + element.data);

		getKthToLastElementRecursively(head, k);
		IntegerWrapper integer = new IntegerWrapper();
		System.out.println("k-th element from last: " + getKthToLastElementRecursively2(head, k, integer).data);

	}

	public static Node getKthToLastElement(Node lead, int k) {
		Node trail = lead;

		while (lead != null) {
			lead = lead.next;
			if (k > 0) {
				k--;
				continue;
			}
			trail = trail.next;
		}


		if (k > 0) {
			System.out.println("List does not have 'k' elements! ");
			return null;
		}

		return trail;
	}

	public static int getKthToLastElementRecursively(Node current, int k) {
		// k=1 means the last element

		if (current == null) {
			return 0;
		}

		int n = 1 + getKthToLastElementRecursively(current.next, k);

		if (n == k) {
			System.out.println("k-th element from last: " + current.data);
		}

		return n;
	}

	public static Node getKthToLastElementRecursively2(Node current, int k, IntegerWrapper integer) {
		if (current == null) {
			return null;
		}


		Node node = getKthToLastElementRecursively2(current.next, k, integer);

		integer.value = integer.value + 1;

		if (integer.value == k) {
			return current;
		}

		return node;

	}

}

class IntegerWrapper {
	public int value = 0;
}