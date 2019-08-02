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

		list = partitionList(list, list, partitionKey);

		RemoveDuplicates.displayList(list);
	}

	public static Node partitionList(Node head, Node list, int key) {

		// System.out.println("Entry:- \nHead: " + head.data + "\tlist: " + list.data);
		if (list.next == null) {

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
			// System.out.println("Exit:- \nHead: " + head.data + "\tlist: " + list.data + "\tcurrent: " + current.data);
			// RemoveDuplicates.displayList(head);

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
}