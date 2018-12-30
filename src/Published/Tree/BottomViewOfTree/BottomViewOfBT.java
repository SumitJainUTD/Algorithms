package Published.Tree.BottomViewOfTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomViewOfBT {
    public static TreeMap<Integer, Integer> ht = new TreeMap<Integer, Integer>();;

    public static void bottomView(Node root, int level) {
        if (root == null)
            return;
        // create a queue for level order traversal
        Queue<QueuePack> queue = new LinkedList<QueuePack>();
        // add root with level 0 (create a queue item pack)
        queue.add(new QueuePack(level, root));
        while (!queue.isEmpty()) {
            QueuePack q = queue.remove();
            // take out the items from the package
            Node tnode = q.tnode;
            int lvl = q.level;

            // keep updating the Map so that it will have the last entry from
            // each level(vertically) and that will the bottom view of the tree
            ht.put(lvl, tnode.data);

            // add the left and right children of visiting nodes to the queue
            if (tnode.left != null) {
                queue.add(new QueuePack(lvl - 1, tnode.left));
            }
            if (tnode.right != null) {
                queue.add(new QueuePack(lvl + 1, tnode.right));
            }
        }

    }

    public static void display() { // print the bottom view.
        Set<Integer> keys = ht.keySet();
        for (Integer key : keys) {
            System.out.print(ht.get(key) + " ");
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right.right = new Node(8);
        // root.right.right.left = new Node(30);

        bottomView(root, 0);
        display();
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

// this class' represents the items stored in queue (used for level order
// traversal). Objects will store the nodes and its level
class QueuePack {
    int level;
    Node tnode;

    public QueuePack(int level, Node tnode) {
        this.level = level;
        this.tnode = tnode;
    }
}
