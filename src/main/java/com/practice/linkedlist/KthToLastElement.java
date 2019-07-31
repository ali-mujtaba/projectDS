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
			System.exit(0);
		}

		return trail;
	}
}