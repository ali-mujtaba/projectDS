package com.practice.tree;

import java.util.ArrayList;
public class BSTFromArray {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		// int N = 100;
		int N = 101;
		for (int i = 1; i < N; i++) {
			list.add(i * 5);
		}
		BTNode BSTroot = getBST(list);
		System.out.println("In-order:- ");
		BinaryTree.inorderTraversal(BSTroot);
		System.out.println("\n\nPre-order:- ");
		BinaryTree.preorderTraversal(BSTroot);
		System.out.println();
	}

	static BTNode getBST(ArrayList<Integer> list) {
		return buildBST(list, -1, list.size());
	}

	static BTNode buildBST(ArrayList<Integer> list, int left, int right) {
		if (list.isEmpty()) {
			return null;
		}

		int e = (left + right) / 2;
		// System.out.println(e);
		BTNode node = new BTNode(list.get(e));

		if (Math.abs(left - e) > 1) {
			node.left = buildBST(list, left, e);
		}

		if (Math.abs(e - right) > 1) {
			node.right = buildBST(list, e, right);
		}

		return node;
	}

}