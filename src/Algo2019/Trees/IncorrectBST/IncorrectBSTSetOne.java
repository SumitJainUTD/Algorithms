package Algo2019.Trees.IncorrectBST;

public class IncorrectBSTSetOne {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node first, middle, last, previous;
    public void findNodesForSwapping(Node root){

        if(root!=null){
            findNodesForSwapping(root.left);
            if (previous != null && root.data < previous.data) {
                //if here means we have found a violation
                if (first == null) {
                    //if here means this is first violation.
                    //store both the nodes
                    first = previous;
                    middle = root;
                }else{
                    // If here means this is second violation
                    //no need of middle node now, store this node
                    last = root;
                }
            }
            //make the current node as previous
            previous = root;
            findNodesForSwapping(root.right);
        }
    }

    public void correctTheBST(Node root){

        first = middle = last = previous= null;

        System.out.print("InOrder Traversal :" );
        inorder(root);
        //find the nodes to swap
        findNodesForSwapping(root);

        if(first!=null){
            if(last!=null){
                //means two incorrect nodes are not adjacent nodes, swap first and last node
                swap(first, last);
            }else{
                //means two incorrect nodes are adjacent nodes, swap first and middle node
                swap(first, middle);
            }
        }else{
            System.out.println("Given tree is already in correct order, No fixing required");
            return;
        }
        System.out.println();
        System.out.print("Corrected InOrder Traversal :" );
        inorder(root);
    }

    void swap(Node x, Node y){
        int temp = x.data;
        x.data = y.data;
        y.data = temp;
    }

    private void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(20);
        root.right.right = new Node(30);

        IncorrectBSTSetOne i = new IncorrectBSTSetOne();
        i.correctTheBST(root);
    }
}
