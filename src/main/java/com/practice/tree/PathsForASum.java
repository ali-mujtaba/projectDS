package com.practice.tree;

import java.util.Stack;

public class PathsForASum {
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
		Stack<Integer> path = new Stack<>();
		getPath(current, k, path);
		getPaths(current.left, k);
		getPaths(current.right, k);

	}
	static void getPath(BTNode current, int k, Stack<Integer> path) {
		if (current == null || k < current.data) {
			return;
		}

		if (k == current.data) {
			path.push(current.data);
			System.out.println(path);
			path.pop();
			return;
		}

		k -= current.data;
		path.push(current.data);
		getPath(current.left, k, path);
		getPath(current.right, k, path);
		path.pop();
		return;
	}
}