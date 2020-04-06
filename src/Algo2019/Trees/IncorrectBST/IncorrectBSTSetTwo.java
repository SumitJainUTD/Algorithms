package Algo2019.Trees.IncorrectBST;

import java.util.ArrayList;
import java.util.Arrays;

public class IncorrectBSTSetTwo {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void correctTheBST(Node root){

        ArrayList<Integer> listNodes = new ArrayList<>();

        //fill the list with the inorder traversal
        inorder(root, listNodes);
        System.out.println("Given Inorder Traversal:" + Arrays.toString(listNodes.toArray()));

        Integer [] arrNodes = listNodes.toArray(new Integer[0]);

        //do the insertion sort
        arrNodes = insertionSort(arrNodes);

        //Now traverse through list and sorted array

        for (int i = 0; i <arrNodes.length ; i++) {
            //Get the unmatched values and swap them
            if(arrNodes[i]!=listNodes.get(i)){
                int x = arrNodes[i];
                int y = listNodes.get(i);
                swapNodes(root, x, y);
                break;
            }
        }
        System.out.print("Fixed Inorder Traversal:");
        inorder(root);
    }

    private void swapNodes(Node root, int x, int y){
        if(root!=null){
            swapNodes(root.left, x, y);
            if(root.data==x)
                root.data = y;
            if(root.data==y)
                root.data = x;
            swapNodes(root.right, x, y);
        }
    }

    private Integer [] insertionSort(Integer [] arrNodes){
        for (int i = 0; i <arrNodes.length ; i++) {
            int j = i;
            int key = arrNodes[j];
            while (j > 0 && arrNodes[j] < arrNodes[j - 1]) {
                //current element is smaller than previous element
                    //swap the elements
                    int temp = arrNodes[j];
                    arrNodes[j] = arrNodes[j - 1];
                    arrNodes[j - 1] = temp;
                j--;
            }
        }
        return arrNodes;
    }

    private void inorder(Node root, ArrayList<Integer> arrayList){
        if(root!=null){
            inorder(root.left, arrayList);
            arrayList.add(root.data);
            inorder(root.right, arrayList);
        }
    }

    private void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(20);
        root.right.right = new Node(30);

        IncorrectBSTSetTwo i = new IncorrectBSTSetTwo();
        i.correctTheBST(root);
    }
}
