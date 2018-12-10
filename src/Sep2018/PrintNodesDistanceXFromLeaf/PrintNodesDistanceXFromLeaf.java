package Sep2018.PrintNodesDistanceXFromLeaf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sumi1 on 9/29/2018.
 */
public class PrintNodesDistanceXFromLeaf {

    public static int print(Node root, int x, HashSet<Node> hs){
        if(root==null)
            return 0;

        int left = print(root.left, x, hs);
        int right = print(root.right, x, hs);

        if(left==x)
            hs.add(root);
        if(right==x)
            hs.add(root);
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(7);
        root.right.left = new Node(6);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        root.right.left.right.right = new Node(10);
        HashSet<Node> hs = new HashSet<>();
        print(root,2,hs);

        Iterator<Node> iterator = hs.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().data + "  ");
        }
    }
}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}