package com.practice.tree;

public class InorderSuccessor {
	public static void main(String[] args) {
		modifiedBTNode node1 = new modifiedBTNode(50);
		modifiedBTNode node2 = new modifiedBTNode(25);
		modifiedBTNode node3 = new modifiedBTNode(75);
		modifiedBTNode node4 = new modifiedBTNode(15);
		modifiedBTNode node5 = new modifiedBTNode(35);
		modifiedBTNode node6 = new modifiedBTNode(65);
		modifiedBTNode node7 = new modifiedBTNode(85);
		modifiedBTNode node8 = new modifiedBTNode(95);
		modifiedBTNode node9 = new modifiedBTNode(105);
		modifiedBTNode node10 = new modifiedBTNode(30);
		modifiedBTNode node11 = new modifiedBTNode(40);

		modifiedBTNode root = node1;

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.right = node8;
		node8.right = node9;
		node5.left = node10;
		node5.right = node11;

		node2.parent = node1;
		node3.parent = node1;
		node4.parent = node2;
		node5.parent = node2;
		node6.parent = node3;
		node7.parent = node3;
		node8.parent = node7;
		node9.parent = node8;
		node10.parent = node5;
		node11.parent = node5;

		System.out.println(getInorderSuccessor(node1).data);
		System.out.println(getInorderSuccessor(node8).data);
		System.out.println(getInorderSuccessor(node11).data);
		System.out.println(getInorderSuccessor(node4).data);
		System.out.println(getInorderSuccessor(node6).data);
		System.out.println(getInorderSuccessor(node9));


	}

	public static modifiedBTNode getInorderSuccessor(modifiedBTNode current) {
		if (current == null) {
			return null;
		}

		// when there is a right child, the in-order successor will be in the right sub-tree
		if (current.right != null) {
			current = (modifiedBTNode)current.right;
			while (current.left != null) {
				current = (modifiedBTNode)current.left;
			}
			return current;
		}

		if (isLeftChild(current)) {
			return current.parent;
		}

		// if there is no right child, we roll back to parents until we find a node that is not a right child
		while (isRightChild(current)) {
			current = current.parent;

			// in the case when you reach the root node rolling back from right subtree, so there are no nodes left
			if (current.parent == null) {
				return null;
			}
		}
		return current.parent;

	}

	public static boolean isLeftChild(modifiedBTNode current) {
		if (current != null && current.parent != null && current.parent.left == current) {
			return true;
		}
		return false;
	}

	public static boolean isRightChild(modifiedBTNode current) {
		if (current != null && current.parent != null && current.parent.right == current) {
			return true;
		}
		return false;
	}
}

class modifiedBTNode extends BTNode {
	modifiedBTNode parent;

	modifiedBTNode(int data) {
		super(data);
		this.parent = null;
	}
}