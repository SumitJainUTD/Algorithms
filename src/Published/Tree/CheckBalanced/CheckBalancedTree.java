package Published.Tree.CheckBalanced;

/**
 * Created by sjain on 11/8/17.
 */
public class CheckBalancedTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left= new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(6);
        node.right.right = new Node(8);
        node.left.right.left = new Node(7);
        node.left.right.left.left = new Node(9);

        System.out.println(new CheckBalancedTree().isBalanced(node));
    }

    private int isBalanced(Node node) {
        if(node==null)
            return 0;

        int a = isBalanced(node.left);
        if(a<0)
            return -1;
        int b = isBalanced(node.right);
        if(b<0)
            return -1;

        int diff = Math.abs(a-b);
        if(diff>1)
            return -1;
        else
            return Math.max(a,b)+1;
    }
}

class Node{
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}