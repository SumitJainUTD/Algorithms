package Published;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sjain on 10/11/18.
 */
public class MergeKSortedArrays {

    public void merge(int [][] arrA){


        // base cases

        ArrayList<Integer> list = new ArrayList<Integer>();

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int i = o1.data - o2.data;
                return i;
            }
        });

        //insert all the first elements
        for (int i = 0; i <arrA.length ; i++) {
            Node node = new Node(arrA[i][0],i);
            pq.add(node);
        }

        int [] ptrs = new int[arrA.length];
        for (int i = 0; i <ptrs.length ; i++) {
            ptrs[i] = 1;
        }

        while(!pq.isEmpty()){
            Node n = pq.remove();

            list.add(n.data);

            int lNo = n.listNo;

            //add the next element from this list

            if(ptrs[lNo]<arrA[lNo].length){
                pq.add(new Node(arrA[lNo][ptrs[lNo]], lNo));
                ptrs[lNo]++;
            }
        }
        //print the arrayList

        System.out.println(Arrays.toString(list.toArray()));



    }

    public static void main(String[] args) {
        int arrA [][] = new int [][]{{1,   4,   6},
                                     {2,   4,   7},
                                     {5,   9,   10, 11 , 12, 19}};

        new MergeKSortedArrays().merge(arrA);
    }

    static class Node{
        int data;
        int listNo;

        public Node(int data, int listNo){
            this.data = data;
            this.listNo = listNo;
        }

    }
}
