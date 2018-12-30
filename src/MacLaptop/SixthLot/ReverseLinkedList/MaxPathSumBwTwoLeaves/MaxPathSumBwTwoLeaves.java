package MacLaptop.SixthLot.ReverseLinkedList.MaxPathSumBwTwoLeaves;

/**
 * Created by sjain on 9/27/18.
 */
public class MaxPathSumBwTwoLeaves {

    static int  result = 0;

    public int maxPathSum(Node root) {
        if(root==null)
            return 0;
        int leftM = maxPathSum(root.left);
        int rightM = maxPathSum((root.right));



        int temp =  root.data + Math.max(leftM, rightM);
        if(temp>result)
            result = temp;

        return temp;
    }

    public static void main(String args[]){
        Node root = new Node(-5);
        root.left = new Node(1);
        root.right = new Node(4);
//        root.left.left = new Node(-6);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(-2);
//        root.left.right.right = new Node(3);
//        root.left.left.left = new Node(9);
//        root.left.left.right = new Node(10);
        root.right.left = new Node(11);
        root.right.right = new Node(-2);
        root.right.right.right = new Node(-8);
        root.right.right.left = new Node(7);
        root.right.right.right.left = new Node(1);
        root.right.right.right.right = new Node(7);
        root.right.right.right.right.left = new Node(12);

        MaxPathSumBwTwoLeaves m = new MaxPathSumBwTwoLeaves();
        m.maxPathSum(root);
        System.out.println("Max Path Sum Between Two Leaves is " + result);
        //m.inorder(root);
    }
}
class Node{
    int data;
    Node left;
    Node right;
    public Node (int data){
        this.data = data;
        left = null;
        right = null;
    }
}
