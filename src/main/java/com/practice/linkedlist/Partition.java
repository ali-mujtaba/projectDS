/*

Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.

*/
package com.practice.linkedlist;

import java.util.Scanner;
public class Partition {
	public static void main(String[] args) {

		Node list = RemoveDuplicates.seedList();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter key: ");
		int partitionKey = scanner.nextInt();

		RemoveDuplicates.displayList(partitionList(list, list, partitionKey));

		RemoveDuplicates.displayList(partitionList(list, partitionKey));
		RemoveDuplicates.displayList(partitionList2(list, partitionKey));


	}

	public static Node partitionList(Node head, Node list, int key) {

		if (list == null || list.next == null) {
			return list;
		}

		Node current = partitionList(head, list.next, key);

		if (list.equals(head)) {

			if (list.data >= key) {

				while (list.next != null) {
					list = list.next;
				}

				Node temp = head.next;
				head.next = null;
				list.next = head;
				// RemoveDuplicates.displayList(temp);

				return temp;
			}

			return head;
		}

		if (current.data < key) {

			list.next = current.next;
			current.next = head.next;
			head.next = current;
		}

		// System.out.println("Exit:- \nHead: " + head.data + "\tlist: " + list.data + "\tcurrent: " + current.data);
		// RemoveDuplicates.displayList(head);
		return list;

	}

	static Node partitionList(Node current, int key) {
		if (current == null || current.next == null) {
			return current;
		}

		Node precedingListHead = null;
		Node precedingListTail = null;
		Node followingListHead = null;
		Node followingListTail = null;

		while (current != null) {

			if (current.data < key) {
				if (precedingListHead == null) {
					precedingListHead = current;
					precedingListTail = current;
				} else {
					precedingListTail.next = current;
					precedingListTail = current;
				}
				current = current.next;
				precedingListTail.next = null;


			} else {
				if (followingListHead == null) {
					followingListHead = current;
					followingListTail = current;
				} else {
					followingListTail.next = current;
					followingListTail = current;
				}
				current = current.next;
				followingListTail.next = null;

			}


		}

		precedingListTail.next = followingListHead;

		return precedingListHead;
	}

	static Node partitionList2(Node current, int key) {
		if (current == null || current.next == null) {
			return current;
		}

		Node head = null;
		Node tail = null;

		while (current != null) {
			if (current.data < key) {
				if (head == null) {
					head = current;
					tail = current;
				} else {
					Node temp = current.next;
					current.next = head;
					head = current;
					current = temp;
				}
			} else {
				if (tail == null) {
					tail = current;
					head = current;
				} else {
					tail.next = current;
					tail = tail.next;
				}
				current = current.next;
				tail.next = null;
			}
		}

		return head;
	}
}