package com.practice.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
	public static void main(String[] args) {
		BTNode node1 = new BTNode(50);
		BTNode node2 = new BTNode(25);
		BTNode node3 = new BTNode(75);
		BTNode node4 = new BTNode(15);
		BTNode node5 = new BTNode(35);
		BTNode node6 = new BTNode(65);
		BTNode node7 = new BTNode(85);
		BTNode node8 = new BTNode(95);
		BTNode node9 = new BTNode(105);

		BTNode root = node1;

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.right = node8;
		node8.right = node9;


		System.out.print("\nIn-order: ");
		inorderTraversal(root);
		System.out.println();
		System.out.print("Pre-order: ");
		preorderTraversal(root);
		System.out.println();
		System.out.print("Post-order: ");
		postorderTraversal(root);
		System.out.println();
		System.out.print("Level-order: ");
		levelorderTraversal(root);
		System.out.println();

	}

	public static void inorderTraversal(BTNode current) {

		if (current == null) {
			return;
		}

		inorderTraversal(current.left);
		System.out.print(current.data + " ");
		inorderTraversal(current.right);
	}

	public static void preorderTraversal(BTNode current) {

		if (current == null) {
			return;
		}

		System.out.print(current.data + " ");
		preorderTraversal(current.left);
		preorderTraversal(current.right);
	}

	public static void postorderTraversal(BTNode current) {

		if (current == null) {
			return;
		}
		postorderTraversal(current.left);
		postorderTraversal(current.right);
		System.out.print(current.data + " ");
	}

	public static void levelorderTraversal(BTNode current) {
		Queue<BTNode> queuedNodes = new LinkedList<>();
		queuedNodes.add(current);
		while (!queuedNodes.isEmpty()) {
			BTNode topNode = queuedNodes.remove();
			if (topNode.left != null) {
				queuedNodes.add(topNode.left);
			}
			if (topNode.right != null) {
				queuedNodes.add(topNode.right);
			}

			System.out.print(topNode.data + " ");
		}
		System.out.println();
	}
}

class BTNode {
	int data;
	BTNode left;
	BTNode right;

	BTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
