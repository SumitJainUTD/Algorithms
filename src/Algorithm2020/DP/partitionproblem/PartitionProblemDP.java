package Algorithm2020.DP.partitionproblem;

import java.util.Arrays;

public class PartitionProblemDP {

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
        if(partitionUtil(input, sum/2)){
            System.out.println("Array can be partitioned into two equal halves with sum " + sum/2);
            return true;
        } else{
            System.out.println("Array cannot be partitioned into two equal halves");
            return false;
        }
    }

    private boolean partitionUtil(int[] input, int requiredSum) {

        boolean [][] partition = new boolean[input.length+1][requiredSum+1];

        //if required sum is 0 we can make the empty subset to make sum 0
        for(int i=0;i<=input.length;i++)
            partition[i][0]=true;

        //if given set is empty then we cannot make any sum
        for(int i=1;i<=requiredSum;i++)
            partition[0][i]=false;

        //solve for rest of the sums

        for (int i = 1; i<=input.length ; i++) {
            for (int j = 1; j <=requiredSum ; j++) {

                //first copy the data from the top
                partition[i][j] = partition[i-1][j];

                //If partition[i][j]==false check if can be made
                if(partition[i][j]==false && j>=input[i-1])
                    partition[i][j] = partition[i][j] || partition[i-1][j-input[i-1]];
            }
        }

        return partition[input.length][requiredSum];
    }

    public static void main(String[] args) {
        PartitionProblemDP p = new PartitionProblemDP();
        int input[] = {1, 3, 4, 19, 15, 2};
        p.partition(input);
    }
}