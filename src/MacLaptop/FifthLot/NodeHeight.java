package MacLaptop.FifthLot;

/**
 * Created by sjain on 11/8/17.
 */
public class NodeHeight {

    public int getDepth(int x, Node root){
        if(root==null)
            return 0;
        if(root.data==x)
            return 1;

        int a = getDepth(x,root.left);
        if(a>0)
            return a+1;
        int b = getDepth(x,root.right);
        if(b>0)
            return b+1;
        return 0;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left= new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(7);

        System.out.println(new NodeHeight().getDepth(7,node));
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