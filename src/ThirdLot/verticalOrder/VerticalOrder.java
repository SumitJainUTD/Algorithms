package ThirdLot.verticalOrder;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrder {
    public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();
    public ArrayList<Integer> al;

    public Node vertical(Node root, int level) {
        if (root == null) {
            return null;
        }
        if (ht.get(level) != null) {
            ArrayList x = ht.get(level);
            x.add(root.data);
            ht.put(level, x);
        } else {
            al = new ArrayList<>();
            al.add(root.data);
            ht.put(level, al);
        }
        Node y = vertical(root.left, --level);
        if (y == null) {
            level++;
        }
        return vertical(root.right, ++level);
    }

    public void printResult(TreeMap ht) {
        Set<Integer> i = ht.keySet();
        for (int keys : i) {
            System.out.println(ht.get(keys));
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        VerticalOrder p = new VerticalOrder();
        p.vertical(root, 0);
        p.printResult(ht);

    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

