package Algorithm2020.Arrays.cycles;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwapsToSortArray {
    static class Pair{
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public void findCycles(int [] input){

        int size = input.length;

        ArrayList<Pair> pairList = new ArrayList<>();
        //create pair array
        Pair[] pairs = new Pair[size];

        for (int i = 0; i <size ; i++) {
            pairList.add(new Pair(i, input[i]));
            pairs[i] = new Pair(i, input[i]);
        }

        //sort the array as per the the value

        Arrays.sort(pairs, (o1, o2) -> o1.value - o2.value);

        //create visited array
        boolean[] visited = new boolean[size];

        int swapsRequired = 0;

        for (int i = 0; i < size; i++) {
            if (pairs[i].index != i) {
                if (!visited[i]) {
                    // pass 1 as cycle length - include the current element from which the DFS is starting
                    swapsRequired += findCycleLength(pairs, i, visited, 0);
                }
            }
        }

        System.out.println("Given Array : " + Arrays.toString(input) + " Minimum Swaps required: " + swapsRequired);
    }

    int findCycleLength (Pair[]pairs,int start, boolean[] visited, int cycle) {
        visited[start] = true;
        int next = pairs[start].index;
        if (visited[next] != true) {
            return findCycleLength(pairs, next, visited, cycle) + 1;
        }
        return cycle;
    }

    public static void main(String[] args) {
        MinimumSwapsToSortArray n = new MinimumSwapsToSortArray();
        int input [] = {13, 12, 11, 10};
        n.findCycles(input);
        int input1 [] = {12, 0, 1};
        n.findCycles(input1);
        int input2 [] = {1, 3, 4, 0, 2, 26, 15};
        n.findCycles(input2);
    }
}
