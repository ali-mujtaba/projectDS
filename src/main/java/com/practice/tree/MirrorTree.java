/* 
    Given a tree, transform it into its mirror reflection
*/
package com.practice.tree;

public class MirrorTree{
    public static void main(String[] args){
        Integer[] nodesData = {1,2,3,null,5,6};
        BTNode root = BinaryTree.buildTree(nodesData);
        BinaryTree.inorderTraversal(root);
        System.out.println();
        mirror(root);
        BinaryTree.inorderTraversal(root);
        System.out.println();
    }

    public static void mirror(BTNode current){
        if(current==null){
            return;
        }

        BTNode temp = current.right;
        current.right = current.left;
        current.left = temp;

        mirror(current.right);
        mirror(current.left);

    }
}
