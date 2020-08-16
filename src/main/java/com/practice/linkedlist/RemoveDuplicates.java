/*

Write a code to remove duplicates from an unsorted linked list.

*/
package com.practice.linkedlist;

import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicates {

	public static void main(String[] args) {

		Node head = seedList();
		removeDuplicates(head);
		removeDuplicates2(head);
		displayList(head);
	}

	public static Node seedList() {
		System.out.println("Enter the elements for linked list. Enter 'done' when you are done. ");
		String input = "";
		Node head = null;
		Scanner scanner = new Scanner(System.in);
		while (true) {

			input = scanner.next();
			if (input.equals("done")) {
				break;
			}

			int data = Integer.parseInt(input);

			Node node = new Node(data);
			if (head == null) {
				head = node;
			} else {
				Node current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = node;
			}
			displayList(head);
		}
		return head;
	}
	public static void displayList(Node current) {
		if (current == null) {
			return;
		}
		System.out.print("List: ");
		while (current.next != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}
	public static void removeDuplicates(Node current) {
		Node currentTwin;
		while (current != null) {
			currentTwin = current;
			while (currentTwin != null) {
				if (currentTwin.next != null && currentTwin.next.data == current.data) {
					currentTwin.next = currentTwin.next.next;
				}
				currentTwin = currentTwin.next;
			}
			current = current.next;
		}
	}

	public static void removeDuplicates2(Node current) {
		HashSet<Integer> charSet = new HashSet<>();
		Node previousNode = null;
		while (current != null) {
			if (charSet.contains(current.data)) {
				previousNode.next = current.next;
			}
			previousNode = current;
			current = current.next;
		}
	}
}

class Node {
	int data;
	Node next;

	public Node(int d) {
		this.data = d;
		this.next = null;
	}
}

