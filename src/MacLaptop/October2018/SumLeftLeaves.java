package MacLaptop.October2018;

/**
 * Created by sjain on 10/13/18.
 */
public class SumLeftLeaves {

    public int sum(Node root, boolean isLeft){
        if(root==null)
            return 0;

        if(root.left==null && root.right==null && isLeft )
            return root.data;
        else if(root.left==null && root.right==null && isLeft){
            return 0;
        }

        return sum(root.left, true) + sum(root.right, false);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(10);
        root.left.right = new Node(12);
        root.left.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(5);

        System.out.println("Sum of left leaves: " + new SumLeftLeaves().sum(root, false));
    }

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
