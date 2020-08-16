/*

Implement an algorithm that returns the node at the beginning of the loop

*/
package com.practice.linkedlist;

public class LoopDetection {

	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;

		Node head = node1;
		Node loopStartNode = detectLoop(head);

		if (loopStartNode == null) {

			System.out.println();
			return;
		}

		System.out.println(loopStartNode.data);

	}

	public static Node detectLoop(Node list) {

		Node head = list;
		while (list.next != null) {

			Node current = head;
			while (current.equals(list) == false) {

				if (list.next.equals(current)) {
					return current;
				}

				current = current.next;

			}

			list = list.next;

		}

		return null;
	}
}