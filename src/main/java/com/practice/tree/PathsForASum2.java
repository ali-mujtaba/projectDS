package com.practice.tree;

import java.util.LinkedList;

public class PathsForASum2 {
	public static void main(String[] args) {
		BTNode node1 = new BTNode(3);
		BTNode node2 = new BTNode(1);
		BTNode node3 = new BTNode(4);
		BTNode node4 = new BTNode(2);
		BTNode node5 = new BTNode(7);
		BTNode node6 = new BTNode(8);
		BTNode node7 = new BTNode(5);
		BTNode node8 = new BTNode(9);
		BTNode node9 = new BTNode(10);
		BTNode node10 = new BTNode(6);

		BTNode root = node1;

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node7.left = node9;
		node7.right = node10;

		getPaths(root, 15);
	}

	static void getPaths(BTNode current, int k) {
		if (current == null) {
			return;
		}
		LinkedList<Integer> path = new LinkedList<>();
		getPath(current, current, k, path);
		getPaths(current.left, k);
		getPaths(current.right, k);

	}


	static void leftSubtreeHelper(BTNode current, int k, LinkedList<Integer> path) {
		if (current == null || k < current.data) {
			return;
		}

		if (k == current.data) {
			path.addFirst(current.data);
			System.out.println(path);
			path.removeFirst();
			return;
		}

		k -= current.data;
		path.addFirst(current.data);
		leftSubtreeHelper(current.left, k, path);
		leftSubtreeHelper(current.right, k, path);
		path.removeFirst();
		return;
	}

	static void getPath(BTNode root, BTNode current, int k, LinkedList<Integer> path) {
		if (current == null || k < current.data) {
			return;
		}
		if (k == current.data) {
			path.addLast(current.data);
			System.out.println(path);
			path.removeLast();
			return;
		}

		k -= current.data;
		path.addLast(current.data);
		leftSubtreeHelper(root.left, k, path);
		getPath(root, current.left, k, path);
		getPath(root, current.right, k, path);
		path.removeLast();
		return;
	}
}