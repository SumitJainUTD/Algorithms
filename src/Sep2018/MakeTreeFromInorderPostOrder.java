package Sep2018;

/**
 * Created by sumi1 on 9/28/2018.
 */
public class MakeTreeFromInorderPostOrder {

    public Node makeBTree(int[] inOrder, int[] postOrder, int start, int end) {
        if (start > end ) {
            return null;
        }

        int rootValue = postOrder[end];
        Node root = new Node(rootValue);

        if (start == end) {
            return root;
        }

        int index = getInorderIndex(inOrder, start, end, root.data);

        root.left = makeBTree(inOrder, postOrder, start, index - 1);
        root.right = makeBTree(inOrder, postOrder, index+1, end);

        return root;

    }

    public int getInorderIndex(int[] inOrder, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public void printINORDER(Node root) {
        if (root != null) {
            printINORDER(root.left);
            System.out.print("  " + root.data);
            printINORDER(root.right);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] postOrder = { 4, 5, 2, 6, 7, 3, 1 };
        MakeTreeFromInorderPostOrder i = new MakeTreeFromInorderPostOrder();
        Node x = i.makeBTree(inOrder, postOrder, 0, inOrder.length - 1);
        System.out.println("inorder traversal of constructed tree : ");
        i.printINORDER(x);

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