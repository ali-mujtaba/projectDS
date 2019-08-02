/*

Write a program to delete a middle node(not the start or end node) in a linked list, given only access to that node.

*/
package com.practice.linkedlist;

public class DeleteMiddleNode {

	public static void main(String[] args) {

		Node head = RemoveDuplicates.seedList();

		deleteNode(head.next.next);

		RemoveDuplicates.displayList(head);

	}

	public static void deleteNode(Node node) {

		if (node.next == null) {
			System.out.println("Can't delete start/end node. ");
			return;
		}

		node.data = node.next.data;
		node.next = node.next.next;

	}

}