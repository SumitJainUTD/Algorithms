package Algo2019.Trees;

public class CheckFullTree {

    static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public boolean checkFull(Node root){

        //empty tree, return true
        if(root==null)
            return true;

        // if node is a leaf node, return true
        if(root.left==null && root.right==null)
            return true;

        //check if node has only one child
        if((root.left==null && root.right!=null)||(root.left!=null && root.right==null))
            return false;

        //check recursively left and right child
        boolean result = checkFull(root.left) && checkFull(root.right);

        return result;
    }

    public static void main(String[] args) {
        CheckFullTree c = new CheckFullTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Given binary is FULL tree: " + c.checkFull(root));
        //adding another node to making it not Full
        root.left.left.left = new Node(6);
        System.out.println("Given binary is FULL tree: " + c.checkFull(root));
    }
}
