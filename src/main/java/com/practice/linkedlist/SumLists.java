/*

Write a function that adds the two numbers and returns the sum as a linked list.

*/
package com.practice.linkedlist;

public class SumLists {
	public static void main(String[] args) {

		Node list1 = RemoveDuplicates.seedList();
		Node list2 = RemoveDuplicates.seedList();
		Node sumList = addLists(list1, list2);
		RemoveDuplicates.displayList(sumList);
	}

	public static Node addLists(Node list1, Node list2) {

		Node sumList = null;
		Node current = sumList;
		int carry = 0;
		while (list1 != null && list2 != null) {

			int digitSum = list1.data + list2.data + carry;

			if (digitSum > 9) {
				carry = digitSum / 10;
				digitSum %= 10;
			}
			Node node = new Node(digitSum);

			if (sumList == null) {
				sumList = node;
				current = sumList;
			} else {
				current.next = node;
				current = current.next;
			}
			list1 = list1.next;
			list2 = list2.next;
		}

		// case when there are numbers of unequal number of digits

		while (list1 != null) {

			int digitSum = list1.data + carry;

			if (digitSum > 9) {
				carry = digitSum / 10;
				digitSum %= 10;
			}

			Node node = new Node(digitSum);
			current.next = node;
			current = current.next;
			list1 = list1.next;
		}

		while (list2 != null) {

			int digitSum = list2.data + carry;

			if (digitSum > 9) {
				carry = digitSum / 10;
				digitSum %= 10;
			}

			Node node = new Node(digitSum);
			current.next = node;
			current = current.next;
			list2 = list2.next;
		}

		// checking for leftover carry
		if (carry > 0) {
			Node node = new Node(carry);
			current.next = node;
		}

		return sumList;
	}
}