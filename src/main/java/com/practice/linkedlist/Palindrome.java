/*

Implement a function to check if a linked list is palindrome

*/
package com.practice.linkedlist;

public class Palindrome {
	public static void main(String[] args) {

		Node head = RemoveDuplicates.seedList();

		Node node = checkPalindrome(head, head);

		System.out.println("List is palindrome! ");

	}

	public static Node checkPalindrome(Node head, Node current) {

		if (current == null) {
			return head;
		}

		head = checkPalindrome(head, current.next);

		if (current.data != head.data) {
			System.out.println("List is NOT palindrome! ");
			System.exit(0);
		}

		return head.next;
	}

}