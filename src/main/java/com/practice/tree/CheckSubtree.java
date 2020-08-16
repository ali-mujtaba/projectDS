package com.practice.tree;

import java.util.Queue;
import java.util.LinkedList;

public class CheckSubtree {
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
		BTNode node10 = new BTNode(30);

		BTNode T1 = node1;

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.right = node8;
		node8.right = node9;
		node5.left = node10;


		BTNode node11 = new BTNode(50);
		BTNode node12 = new BTNode(25);
		BTNode node13 = new BTNode(75);
		BTNode node14 = new BTNode(15);
		BTNode node15 = new BTNode(35);
		BTNode node16 = new BTNode(65);
		BTNode node17 = new BTNode(85);

		node11.left = node12;
		node11.right = node13;
		node12.left = node14;
		node12.right = node5;
		node13.left = node16;
		node13.right = node17;

		BTNode node21 = new BTNode(25);
		BTNode node22 = new BTNode(15);
		BTNode node23 = new BTNode(35);
		BTNode node24 = new BTNode(30);

		node21.left = node22;
		node21.right = node23;
		node23.left = node24;

		BTNode T2 = node11;
		System.out.println(isSubtree(T1, T2));

		T2 = node21;
		System.out.println(isSubtree(T1, T2));

	}

	static boolean isSubtree(BTNode T1, BTNode T2) {
		boolean flag = false;
		Queue<BTNode> T1traversal = new LinkedList<>();
		T1traversal.offer(T1);
		Queue<BTNode> T2traversal = new LinkedList<>();

		while (!T1traversal.isEmpty()) {
			BTNode currentT1 = T1traversal.poll();

			if (currentT1.data == T2.data) {
				flag = true;
				T2traversal.offer(T2);
				T1traversal.clear();
			}

			if (flag) {
				BTNode currentT2 = T2traversal.poll();
				if (currentT2.data != currentT1.data) {
					return false;
				}

				if (currentT2.left != null) {
					T2traversal.offer(currentT2.left);
				}
				if (currentT2.right != null) {
					T2traversal.offer(currentT2.right);
				}

				if (T2traversal.isEmpty()) {
					break;
				}
			}

			if (currentT1.left != null) {
				T1traversal.offer(currentT1.left);
			}
			if (currentT1.right != null) {
				T1traversal.offer(currentT1.right);
			}
		}

		if (T1traversal.isEmpty() && T2traversal.isEmpty() && flag) {
			return true;
		}

		return false;

	}
}