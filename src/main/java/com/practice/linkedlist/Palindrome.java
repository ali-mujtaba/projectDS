/*

Implement a function to check if a linked list is palindrome

*/
package com.practice.linkedlist;

public class Palindrome {
	public static void main(String[] args) {

		Node head = RemoveDuplicates.seedList();

		NodeContainer container = new NodeContainer(head);
		System.out.println("List is palindrome: " + checkPalindrome2(head, container));

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

	public static boolean checkPalindrome2(Node head, NodeContainer currentContainer) {
		if (currentContainer.reverseNode == null) {
			return true;
		}

		int currentReverseNodeData = currentContainer.reverseNode.data;
		// System.out.println("current reverse node: " + currentReverseNodeData);

		currentContainer.reverseNode = currentContainer.reverseNode.next;
		if (checkPalindrome2(head, currentContainer)) {
			if (currentReverseNodeData == currentContainer.forwardNode.data) {
				// System.out.println("current forward node: " + currentContainer.forwardNode.data);
				currentContainer.forwardNode = currentContainer.forwardNode.next;
				return true;
			}
		}
		return false;
	}

}

class NodeContainer {
	Node reverseNode;
	Node forwardNode;

	NodeContainer(Node head) {
		this.reverseNode = head;
		this.forwardNode = head;
	}
}