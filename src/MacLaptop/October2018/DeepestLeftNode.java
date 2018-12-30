package MacLaptop.October2018;

/**
 * Created by sjain on 10/14/18.
 */
public class DeepestLeftNode {

    public Result deepLeft(Node root, boolean isLeft, int level){
        if(root==null)
            return null;

        Result left = deepLeft(root.left, true, level+1);
        Result right = deepLeft(root.right, false, level+1);

        Result result = null;

        if(left!=null){
            result = left;
        }

        if(right!=null){
            if(result==null)
                result = right;
            else if(result.level<right.level) {
                result = right;
            }
        }

        //if both left and right are null
        if(result==null && isLeft){
            return new Result(level, root);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(8);
        root.left.left.right.left = new Node(18);


        DeepestLeftNode dp = new DeepestLeftNode();
        System.out.println("Deapest Left child is: " + dp.deepLeft(root, false, 0).node.data);
    }



    static class Result{
        int level;
        Node node;

        public Result(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }

    static  class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
