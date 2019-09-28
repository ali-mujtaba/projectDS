/*

Implement a function to check if a linked list is palindrome

*/
package com.practice.linkedlist;
import java.util.Stack;

public class Palindrome {
	public static void main(String[] args) {

		Node head = RemoveDuplicates.seedList();

		NodeContainer container = new NodeContainer(head);
		System.out.println("List is palindrome: " + checkPalindrome2(head, container));
		System.out.println("List is palindrome: " + reverseCheckPalindrome(head));
		System.out.println("List is palindrome: " + checkPalindromeWithStack(head));
		int length = listLength(head);
		System.out.println("List is palindrome: " + checkPalindromeRecursively(head, length).pal);

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

	public static boolean reverseCheckPalindrome(Node head) {
		Node current = head;
		Node reverseListHead = null;
		while (current != null) {
			Node node = new Node(current.data);
			if (reverseListHead == null) {
				reverseListHead = node;
			} else {
				node.next = reverseListHead;
				reverseListHead = node;
			}
			current = current.next;
		}

		Node fast = head;
		Node list = head;
		Node reverseList = reverseListHead;
		while (fast != null && fast.next != null) {
			if (list.data != reverseList.data) {
				return false;
			}
			fast = fast.next.next;
			list = list.next;
			reverseList = reverseList.next;
		}

		return true;
	}

	static boolean checkPalindromeWithStack(Node head) {
		Stack<Integer> listStack = new Stack<>();
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			listStack.push(slow.data);

			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.data != listStack.pop()) {
				return false;
			}
			slow = slow.next;
		}

		return true;
	}

	static AssistNode checkPalindromeRecursively(Node node, int length) {
		if (length == 0 || length == 1) {
			AssistNode anode = new AssistNode();
			anode.forwardNode = node;
			if (length == 1) {
				anode.forwardNode = anode.forwardNode.next;
				return anode;
			}
			return anode;
		}

		AssistNode anode = checkPalindromeRecursively(node.next, length - 2);

		if (anode.pal == true && node.data == anode.forwardNode.data) {
			anode.pal = true;
		} else {
			anode.pal = false;
		}

		anode.forwardNode = anode.forwardNode.next;

		return anode;
	}

	static int listLength(Node list) {
		int length = 0;
		while (list != null) {
			length++;
			list = list.next;
		}
		return length;
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

class AssistNode {
	Node forwardNode = null;
	boolean pal = true;
}