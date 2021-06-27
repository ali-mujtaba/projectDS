/* 
    Implementation of Morris Traversal algorithm for in-order traversal of a binary tree.
*/
package com.practice.tree;

public class MorrisTraversal {
    public static void main(String[] args) {
        int N = 15;
        Integer[] nodesData = new Integer[N];
        for (int i = 0; i < N; i++) {
            nodesData[i] = i + 1;
        }
        BTNode root = BinaryTree.buildTree(nodesData);
        traversal(root);

        Integer[] nodesData1 = {1,null,2,null,null,null,3};
        root = BinaryTree.buildTree(nodesData1);
        traversal(root);
    
        Integer[] nodesData2 = {1,2,null,3};
        root = BinaryTree.buildTree(nodesData2);

        traversal(root);
    }

    public static void traversal(BTNode current) {
        while (current != null) {
            BTNode inOrderPredecessor = getInOrderPredecessor(current);
            if (inOrderPredecessor != null) {
                if (inOrderPredecessor.right == null) {
                    inOrderPredecessor.right = current;
                    current = current.left;
                } else {
                    inOrderPredecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            } else {
                System.out.print(current.data + " ");
                current = current.right;
            }
        }

        System.out.println();

    }

    private static BTNode getInOrderPredecessor(BTNode node) {
        if (node.left == null) {
            return null;
        }
        BTNode root = node;
        node = node.left;
        while (node.right != null && node.right != root) {
            node = node.right;
        }

        return node;
    }
}
