package Algorithm2020.Arrays.cycles;

import java.util.Arrays;

public class LongestCycleInArray {

        public void findCyclesLength(int[] input){

        int size = input.length;

        //create visited array
        boolean[] visited = new boolean[size];

        int maxCycleLength = 0;

        for (int i = 0; i < size; i++) {
            if (input[i] != i) {
                if (!visited[i]) {
                    // pass 1 as cycle length - include the current element from which the DFS is starting
                    maxCycleLength = Math.max(maxCycleLength, findCycleLength(input, i, visited, 1));
                }
            }
        }

        System.out.println("Given Array : " + Arrays.toString(input) + " longest cycle: " + maxCycleLength);
    }

        int findCycleLength (int [] input, int start, boolean[] visited, int cycle) {
            visited[start] = true;
            int next = input[start];
            if (visited[next] != true) {
                return findCycleLength(input, next, visited, cycle) + 1;
            }
            return cycle;
        }

        public static void main (String[]args){
        LongestCycleInArray n = new LongestCycleInArray();
        int input[] = {3, 2, 1, 0};
        n.findCyclesLength(input);
        int input1[] = {3, 0, 1, 2};
        n.findCyclesLength(input1);
        int input2[] = {1, 3, 4, 0, 2, 6, 5};
        n.findCyclesLength(input2);
    }
}

