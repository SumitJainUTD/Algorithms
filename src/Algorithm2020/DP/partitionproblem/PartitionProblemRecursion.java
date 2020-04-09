package Algorithm2020.DP.partitionproblem;

import java.util.Arrays;

public class PartitionProblemRecursion {

    public boolean partition(int [] input){
        System.out.println("Given array: " + Arrays.toString(input));
        int sum = 0;
        for (int i = 0; i <input.length ; i++) {
            sum +=input[i];
        }
        if(sum%2!=0){
            System.out.println("Array cannot be partitioned into two equal halves");
            return false;
        }
        if(partitionUtil(input, sum/2, 0)){
            System.out.println("Array can be partitioned into two equal halves with sum " + sum/2);
            return true;
        } else{
            System.out.println("Array cannot be partitioned into two equal halves");
            return false;
        }
    }

    private boolean partitionUtil(int[] input, int requiredSum, int index) {

        // base cases
        if(requiredSum==0)
            return true;

        if(index==input.length || requiredSum<0)
            return false;

        //select the element at current index OR Ignore it
            return partitionUtil(input, requiredSum-input[index], index++) ||
                    partitionUtil(input, requiredSum, index++);
    }

    public static void main(String[] args) {
        PartitionProblemRecursion p = new PartitionProblemRecursion();
        int input[] = {1, 3, 4, 19, 15, 2};
        p.partition(input);
    }
}
