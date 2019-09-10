package Algo2019.Trees.CompleteBinaryTree;

public class CheckCompleteBinaryTree_NodeCount {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static int nodeCount(Node root){
        if(root==null)
            return  0;

        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }

    /* Given a binary tree, return true if the tree is complete
       else false */
    static boolean isCompleteBT(Node root) {

        //count number of nodes
        int nodesCount = nodeCount(root);

        //assign index as 0 to root node
        int node_index = 0;
        return isCompleteBT(root, node_index, nodesCount);

    }

    static boolean isCompleteBT(Node root, int node_index, int totalNodes) {
        //if root is null, return true
        if(root==null)
            return true;

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if (node_index >= totalNodes)
            return false;

        //recursively solve for left and right child
        int left_index = 2*node_index+1;
        int right_index = 2*node_index+2;
        return isCompleteBT(root.left, left_index, totalNodes)
                && isCompleteBT(root.right, right_index, totalNodes);
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
        System.out.println("Given Binary Tree is a Binary Tree: " + isCompleteBT(root));
        /* Example of not a complete Binary Tree
                1
              /   \
             2     3
            / \   /
           4   5 6
        */
        root.right.left = new Node(6);
        root.right.right = null;
        System.out.println("Given Binary Tree is a Binary Tree: " + isCompleteBT(root));
    }
}
