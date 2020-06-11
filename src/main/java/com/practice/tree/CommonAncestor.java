package com.practice.tree;

public class CommonAncestor {
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

		BTNode node11 = new BTNode(90);

		BTNode root = node1;

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.right = node8;
		node8.right = node9;
		node5.left = node10;

		// System.out.println(hasNode(root, node2));
		// System.out.println(hasNode(root, node6));
		// System.out.println(hasNode(root, node11));
		System.out.println(getAncestor(root, node5, node10).data);
	}

	static BTNode getAncestor(BTNode current, BTNode node1, BTNode node2) {
		if (hasNode(current.left, node1) && hasNode(current.left, node2)) {
			if (node1 == current.left || node2 == current.left) {
				return current;
			}

			return getAncestor(current.left, node1, node2);
		}

		if (hasNode(current.right, node1) && hasNode(current.right, node2)) {
			if (node1 == current.right || node2 == current.right) {
				return current;
			}

			return getAncestor(current.right, node1, node2);
		}

		if ((hasNode(current.left, node1) && hasNode(current.right, node2)) || (hasNode(current.right, node1) && hasNode(current.left, node2))) {
			return current;
		}

		return null;
	}

	static boolean hasNode(BTNode current, BTNode xnode) {
		if (current == null) {
			return false;
		}
		if (current.data == xnode.data) {
			return true;
		}

		return hasNode(current.left, xnode) || hasNode(current.right, xnode);
	}
}