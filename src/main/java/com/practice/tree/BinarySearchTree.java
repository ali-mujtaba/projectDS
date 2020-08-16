package com.practice.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree extends BinaryTree {
	BTNode root;
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		BTNode node1 = new BTNode(50);
		BTNode node2 = new BTNode(25);
		BTNode node3 = new BTNode(75);
		BTNode node4 = new BTNode(15);
		BTNode node5 = new BTNode(35);
		BTNode node6 = new BTNode(65);
		BTNode node7 = new BTNode(85);

		bst.root = node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		// System.out.println(node1.left.data);
		// System.out.println(node1.right.left.data);

		System.out.print("In-order Traversal: ");
		inorderTraversal(bst.root);
		System.out.println();

		System.out.print("Pre-order Traversal: ");
		preorderTraversal(bst.root);
		System.out.println();

		System.out.print("Post-order Traversal: ");
		postorderTraversal(bst.root);
		System.out.println();

		System.out.print("Level-order Traversal: ");
		levelorderTraversal(bst.root);
		System.out.println();

		System.out.println("35: " + bst.find(35));
		System.out.println("37: " + bst.find(37));
		System.out.println("delete 75");
		bst.delete(75);
		inorderTraversal(bst.root);
		System.out.println();
	}

	public void add(int element) {

		BTNode node = new BTNode(element);

		if (root == null) {
			root = node;
		} else {
			BTNode current = root;
			while (true) {
				if (node.data <= current.data) {
					if (current.left == null) {
						current.left = node;
						break;
					}
					current = current.left;
				} else {
					if (current.right == null) {
						current.right = node;
						break;
					}
					current = current.right;
				}
			}
		}
	}

	public BTNode find(int element) {
		BTNode current = root;
		while (current != null) {
			if (element == current.data) {
				return current;
			} else if (element < current.data) {
				current = current.left;
			} else if (element > current.data) {
				current = current.right;
			}
		}
		return null;
	}

	public void delete(int element) {
		BTNode key = this.root;
		BTNode parent = null;
		while (key != null) {
			if (key.data == element) {
				break;
			} else {
				parent = key;
				if (key.data > element) {
					key = key.left;
				} else {
					key = key.right;
				}
			}
		}

		if (key == null) {
			System.out.println("Element not found! ");
			return;
		}

		if (key.left == null && key.right == null) {

			// when key has no child
			if (key == parent.left) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (key.left != null && key.right != null) {

			// when key has no child
			BTNode successor = getMin(key.right);
			if (successor == null) {
				successor = getMax(key.left);
			}

			int temp = successor.data;
			delete(successor.data);
			key.data = temp;
		} else {

			// when key has 1 child
			if (key.left == null) {
				key.data = key.right.data;
				key.left = key.right.left;
				key.right = key.right.right;
			} else {
				key.data = key.left.data;
				key.right = key.left.right;
				key.left = key.left.left;
			}
		}
	}

	public static BTNode getMin(BTNode current) {
		BTNode minNode = null;
		while (current != null) {
			minNode = current;
			current = current.left;
		}
		return minNode;
	}

	public static BTNode getMax(BTNode current) {
		BTNode maxNode = null;
		while (current != null) {
			maxNode = current;
			current = current.right;
		}
		return maxNode;
	}
}
