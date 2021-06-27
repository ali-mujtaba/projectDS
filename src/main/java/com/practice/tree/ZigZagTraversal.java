/* 
    Given a binary tree, print its traversal in zig-zag fashion
*/

// TO BE TESTED. NOT EVEN WORKING CORRECT
package com.practice.tree;

import java.util.*;
public class ZigZagTraversal {
    public static void main(String[] args){
        Integer[] nodesData = {3,9,20,null,null,15,7};
        BTNode root = BinaryTree.buildTree(nodesData);
        for(BTNode node: zigzagLevelOrder(root)){
            System.out.println(node.data);
        }
    }

    public static List<BTNode> zigzagLevelOrder(BTNode root) {
        List<BTNode> zigzagTraversal = new ArrayList<>();
	    
	    if(root == null){
	        return zigzagTraversal;
	    }
        
        boolean useStack = false;
        Stack<BTNode> toReverse = new Stack<>();
        Queue<BTNode> queuedNodes = new LinkedList<>();
        queuedNodes.offer(root);
        queuedNodes.offer(null);

        while(!queuedNodes.isEmpty()){
            BTNode current = queuedNodes.poll();
            if(current==null){
                queuedNodes.offer(null);
                useStack = !useStack;
                while(!toReverse.isEmpty()){
                    zigzagTraversal.add(toReverse.pop());
                }
                
                if(queuedNodes.size()<=1){
                    // to identify the last null node
                    break;
                }
                continue;
            }
            
            if(current.left!=null){
                queuedNodes.offer(current.left);
            }
            if(current.right!=null){
                queuedNodes.offer(current.right);
            }
            
            if(useStack){
                toReverse.push(current);
            }else{
                zigzagTraversal.add(current);    
            }
            
        }
            
       return zigzagTraversal;
    }
}
