/* 
    Given a binary tree, print its left view
*/
package com.practice.tree;

import java.util.ArrayList;
public class BinaryTreeLeftView {
    public static void main(String[] args){
        Integer[] nodesData = {1,2,3,null,5,6,null,null,null,null,null,12};
        BTNode root = BinaryTree.buildTree(nodesData);
        for(BTNode node: getLeftView(root)){
            System.out.println(node.data);
        }
    }

    public static ArrayList<BTNode> getLeftView(BTNode root)
    {
      ArrayList<BTNode> list = new ArrayList<>();
      return helper(root,list,0);
      
    }
    
    public static ArrayList<BTNode> helper(BTNode root, ArrayList<BTNode> list, int level){
        if(root==null){
            return list;
        }
        
        if(list.size()<level+1){
            list.add(root);
        }
        
        helper(root.left,list,level+1);
        helper(root.right,list,level+1);
        
        return list;
    }
}
