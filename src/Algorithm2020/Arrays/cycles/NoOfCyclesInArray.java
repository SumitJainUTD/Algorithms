package Algorithm2020.Arrays.cycles;

import java.util.Arrays;

public class NoOfCyclesInArray {


    public void findCycles(int [] input){

        int size = input.length;

        //create visited array
        boolean[] visited = new boolean[size];

        int noOfCycles = 0;

        for (int i = 0; i <size ; i++) {
            if(input[i]!=i) {
                if (!visited[i]) {
                    findCyclesUtil(input, i, visited);
                    noOfCycles++;
                }
            }
        }

        System.out.println("Given Array : " + Arrays.toString(input) + " No of cycles: " + noOfCycles);
    }

    public void findCyclesUtil(int[] input, int start, boolean[] visited){
        visited[start] = true;
        int next = input[start];
        if(visited[next]!=true){
            findCyclesUtil(input, next, visited);
        }
        return;
    }

    public static void main(String[] args) {
        NoOfCyclesInArray n = new NoOfCyclesInArray();
        int input [] = {3, 2, 1, 0};
        n.findCycles(input);
        int input1 [] = {2, 0, 1};
        n.findCycles(input1);
        int input2 [] = {1, 3, 4, 0, 2, 6, 5};
        n.findCycles(input2);
    }
}
