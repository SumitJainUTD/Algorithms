package Algo2019.Trees.CompleteBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor
        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    /* Given a binary tree, return true if the tree is complete
       else false */
    static boolean isCompleteBT(Node root) {
        // Base Case: An empty tree is complete Binary Tree
        if(root == null)
            return true;

        boolean reachedToEnd = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode == null) {
                //found a node in queue which is null, it should be end,
                reachedToEnd = true;
            }
            else{
                if(reachedToEnd) {
                    //if here means found a node after end
                    return false;
                }
                // add left and right child to the tree
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /* Example of not a complete Binary Tree
                1
              /   \
             2     3
            / \     \
           4   5     6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println("Given a Binary Tree is Binary Tree: " + isCompleteBT(root));
        /* Example of not a complete Binary Tree
                1
              /   \
             2     3
            / \   /
           4   5 6
        */
        root.right.left = new Node(6);
        root.right.right = null;
        System.out.println("Given a Binary Tree is Binary Tree: " + isCompleteBT(root));
    }
}
