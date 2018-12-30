package MacLaptop.October2018;

/**
 * Created by sjain on 10/14/18.
 */
public class GreaterSumTree {

    public static int sum = 0;
    public static void GreaterSum(Node root){
        if(root==null)
            return;

        GreaterSum(root.right);
        int data = root.data;
        root.data = sum;
        sum = sum+data;
        GreaterSum(root.left);
    }

    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20	);

        GreaterSum(root);
        inorder(root);
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
