package com.practice.tree;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ListIterator;

public class ListsAtDepths {
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

		BTNode root = node1;

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.right = node8;
		node8.right = node9;

		ArrayList<LinkedList<BTNode>> listOfLists = getLists(root);
		ListIterator arrayListItr = listOfLists.listIterator(0);
		System.out.println("Lists are as follows:- ");
		for (LinkedList<BTNode> list : listOfLists) {
			for (BTNode node : list) {
				System.out.print(node.data + "  ");
			}
			System.out.println();
		}

		node5.left = node10;
		listOfLists = getLists(root);
		arrayListItr = listOfLists.listIterator(0);
		System.out.println("Lists are as follows:- ");
		for (LinkedList<BTNode> list : listOfLists) {
			for (BTNode node : list) {
				System.out.print(node.data + "  ");
			}
			System.out.println();
		}
	}
	static ArrayList<LinkedList<BTNode>> getLists(BTNode root) {
		ArrayList<LinkedList<BTNode>> lists = new ArrayList<>();
		LinkedList<BTNode> currentList = new LinkedList<>();
		currentList.add(root);
		while (true) {
			LinkedList<BTNode> nextList = new LinkedList<>();
			ListIterator<BTNode> listItr = currentList.listIterator(0);
			while (listItr.hasNext()) {
				BTNode listNode = listItr.next();
				if (listNode.left != null) {
					nextList.add(listNode.left);
				}
				if (listNode.right != null) {
					nextList.add(listNode.right);
				}
			}

			if (nextList.isEmpty()) {
				return lists;
			}

			currentList = nextList;
			lists.add(nextList);
		}
	}
}