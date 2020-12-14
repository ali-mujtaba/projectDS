package com.practice.tree;

import java.util.ArrayList;
public class CheckBST {
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

		System.out.println();
		System.out.println("v1: Is Binary Search Tree? " + isBST(root));
		System.out.println("v2: Is Binary Search Tree? " + isBST2(root));
		System.out.println("v3: Is Binary Search Tree? " + isBST3(root));

		node7.left = node8;
		node7.right = null;
		System.out.println();
		System.out.println("v1: Is Binary Search Tree? " + isBST(root));
		System.out.println("v2: Is Binary Search Tree? " + isBST2(root));
		System.out.println("v3: Is Binary Search Tree? " + isBST3(root));

		node8.data = 70;
		System.out.println();
		System.out.println("v1: Is Binary Search Tree? " + isBST(root));
		System.out.println("v2: Is Binary Search Tree? " + isBST2(root));
		System.out.println("v3: Is Binary Search Tree? " + isBST3(root));

		root = null;
		System.out.println();
		System.out.println("v1: Is Binary Search Tree? " + isBST(root));
		System.out.println("v2: Is Binary Search Tree? " + isBST2(root));
		System.out.println("v3: Is Binary Search Tree? " + isBST3(root));

	}

	public static boolean isBST(BTNode current) {
		if (current == null) {
			return true;
		}

		if (current.left != null) {
			if (current.data < current.left.data) {
				return false;
			}
		}

		if (current.right != null) {
			if (current.data >= current.right.data) {
				return false;
			}
		}

		return isBST(current.left) && isBST(current.right);
	}

	public static boolean isBST2(BTNode current) {
		if (current == null) {
			return true;
		}

		ArrayList<Integer> inorderArray = new ArrayList<>();
		inorderArray = getInorderArray(current, inorderArray);

		for (int i = 1; i < inorderArray.size(); i++) {
			if (inorderArray.get(i) < inorderArray.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> getInorderArray(BTNode current, ArrayList<Integer> inorderArray) {
		if (current == null) {
			return inorderArray;
		}

		inorderArray = getInorderArray(current.left, inorderArray);
		inorderArray.add(current.data);
		inorderArray = getInorderArray(current.right, inorderArray);

		return inorderArray;
	}

	public static boolean isBST3(BTNode current) {

		return isBST3Helper(current, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	public static boolean isBST3Helper(BTNode current, int min, int max) {
		if (current == null) {
			return true;
		}

		if (current.data < min) {
			return false;
		}
		if (current.data >= max) {
			return false;
		}

		return isBST3Helper(current.left, min, current.data) && isBST3Helper(current.right, current.data, max);
	}
}