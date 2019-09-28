/*

Write a function that adds the two numbers and returns the sum as a linked list.

*/
package com.practice.linkedlist;

public class SumLists {
	public static void main(String[] args) {

		Node list1 = RemoveDuplicates.seedList();
		Node list2 = RemoveDuplicates.seedList();
		RemoveDuplicates.displayList(addLists(list1, list2));
		RemoveDuplicates.displayList(sumLists(list1, list2, 0));
		RemoveDuplicates.displayList(sumForwardLists(list1, list2));
		RemoveDuplicates.displayList(sumForwardLists2(list1, list2));
	}

	public static Node addLists(Node list1, Node list2) {

		Node sumList = null;
		Node current = sumList;
		int carry = 0;

		while (list1 != null || list2 != null) {
			int digitSum = carry;

			if (list1 != null) {
				digitSum += list1.data;
			}
			if (list2 != null) {
				digitSum += list2.data;
			}

			Node digit = new Node(digitSum % 10);
			if (sumList == null) {
				sumList = digit;
				current = digit;
			} else {
				current.next = digit;
				current = current.next;
			}

			carry = digitSum / 10;

			list1 = list1 == null ? null : list1.next;
			list2 = list2 == null ? null : list2.next;
		}

		return sumList;
	}

	public static Node sumLists(Node list1, Node list2, int carry) {
		if (list1 == null && list2 == null && carry == 0) {
			return null;
		}

		Node sum = new Node(carry);

		if (list1 != null) {
			sum.data += list1.data;
		}

		if (list2 != null) {
			sum.data += list2.data;
		}

		Node nextSum = sumLists(list1 == null ? null : list1.next, list2 == null ? null : list2.next, sum.data / 10);

		sum.data %= 10;
		sum.next = nextSum;

		return sum;
	}

	public static Node sumForwardLists(Node list1, Node list2) {
		int list1Count = 0, list2Count = 0;
		Node current = list1;
		while (current != null) {
			list1Count++;
			current = current.next;
		}
		current = list2;

		while (current != null) {
			list2Count++;
			current = current.next;
		}

		int carry = 0;

		Node partialSumList = null;
		Node partialSumListTail = null;

		// int limit = list1Count > list2Count ? list1Count : list2Count;
		Node longerList = list1Count > list2Count ? list1 : list2;
		Node shorterList = longerList == list1 ? list2 : list1;
		for (int i = 0 ; longerList != null ; i++) {
			Node sum;
			if (i < Math.abs(list1Count - list2Count)) {
				sum = new Node(longerList.data);
				if (partialSumList == null) {
					partialSumList = sum;
					partialSumListTail = sum;
				} else {
					partialSumListTail.next = sum;
					partialSumListTail = partialSumListTail.next;
				}
				longerList = longerList.next;
				continue;
			}

			sum = new Node(longerList.data + shorterList.data);
			if (partialSumList == null) {
				partialSumList = sum;
				partialSumListTail = sum;
			} else {
				partialSumListTail.next = sum;
				partialSumListTail = partialSumListTail.next;
			}
			longerList = longerList.next;
			shorterList = shorterList.next;
		}

		int finalCarry = patchPartialSumList(partialSumList);

		if (finalCarry > 0) {
			Node finalCarryNode = new Node(finalCarry);
			finalCarryNode.next = partialSumList;
			partialSumList = finalCarryNode;
		}

		return partialSumList;
	}

	static int patchPartialSumList(Node list) {
		if (list == null) {
			return 0;
		}

		int carry = patchPartialSumList(list.next);

		list.data += carry;
		carry = list.data / 10;
		list.data %= 10;

		return carry;
	}

	static Node sumForwardLists2(Node list1, Node list2) {
		int list1Length = lengthOfLinkedList(list1);
		int list2Length = lengthOfLinkedList(list2);

		if (list1Length > list2Length) {
			list2 = padList(list2, list1Length - list2Length);
		}

		if (list2Length > list1Length) {
			list1 = padList(list1, list2Length - list1Length);
		}

		PartialSum finalSum = intermediateSum(list1, list2);
		if (finalSum.carry > 0) {
			Node finalCarry = new Node(finalSum.carry);
			finalCarry.next = finalSum.sum;
			finalSum.sum = finalCarry;
		}

		return finalSum.sum;
	}

	static PartialSum intermediateSum(Node list1, Node list2) {
		if (list1 == null && list2 == null) {
			return new PartialSum();
		}

		PartialSum partialSum = intermediateSum(list1.next, list2.next);

		Node digitSum = new Node(list1.data + list2.data + partialSum.carry);
		partialSum.carry = digitSum.data / 10;
		digitSum.data %= 10;
		digitSum.next = partialSum.sum;
		partialSum.sum = digitSum;

		return partialSum;

	}

	static Node padList(Node list, int padding) {
		while (padding > 0) {
			Node paddingNode = new Node(0);
			paddingNode.next = list;
			list = paddingNode;
			padding--;
		}
		return list;
	}

	static int lengthOfLinkedList(Node list) {
		int length = 0;
		while (list != null) {
			length++;
			list = list.next;
		}
		return length;
	}
}

class PartialSum {
	Node sum = null;
	int carry = 0;
}