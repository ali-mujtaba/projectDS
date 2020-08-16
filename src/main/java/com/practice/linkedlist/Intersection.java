/*

Given two singly linked lists, determine if the two lists intersect. Return the intersecting node.

*/
package com.practice.linkedlist;

public class Intersection {

	public static void main(String[] args) {

		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node6.next = node7;
		node7.next = node8;

		node8.next = node4;

		Node list1 = node1;
		Node list2 = node6;

		RemoveDuplicates.displayList(list1);
		RemoveDuplicates.displayList(list2);

		Node intersectingNode = checkIntersection(list1, list2);
		if (intersectingNode == null) {
			System.out.println("Non-intersecting lists! ");
		} else {
			System.out.println("Lists intersecting at Node " + intersectingNode.data);
		}

	}

	/*public static Node checkIntersection(Node list1, Node list2) {
		Node intersectingNode;
		if (list1.next != null && list2.next != null) {
			intersectingNode = checkIntersection(list1.next, list2.next);
		} else if (list1.next != null) {
			intersectingNode = checkIntersection(list1.next, list2);
		} else if (list2.next != null) {
			intersectingNode = checkIntersection(list1, list2.next);
		} else {
			if (list1.equals(list2)) {
				intersectingNode = list1;
				return intersectingNode;
			} else {
				System.out.println("Non-intersecting Lists! ");
				return null;
			}
		}

		if (list1.equals(list2))
			return intersectingNode;
	}*/

	public static Node checkIntersection(Node list1, Node list2) {

		while (list1.next != null) {

			Node iterateList2 = list2;

			while (iterateList2.next != null) {
				if (list1.equals(iterateList2)) {
					return list1;
				}

				iterateList2 = iterateList2.next;
			}

			list1 = list1.next;
		}

		return null;
	}
}