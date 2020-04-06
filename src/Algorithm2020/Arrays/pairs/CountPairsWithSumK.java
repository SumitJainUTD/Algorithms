package Algorithm2020.Arrays.pairs;

import java.util.Arrays;

public class CountPairsWithSumK {

    public static void findPairsCount(int [] input, int K){
        if(input.length==0)
            return;

        Arrays.sort(input);
        int pairs = 0;
        int  i = 0;
        int j = input.length-1;
        while(i<j){
            int sum = input[i] + input[j];
            if(sum>K)
                j--;
            else if(sum<K)
                i++;
            else{
                // count all occurrences of input[i]
                int value_i = input[i];
                int startIndex_i = i;
                while(i<j && input[i]==value_i){
                    i++;
                }

                // count all occurrences of input[j]
                int value_j = input[j];
                int endIndex_j = j;
                while(i<=j && input[j]==value_j){
                    j--;
                }

                //count the pairs
                if(value_i!=value_j){
                    int n = (i-startIndex_i)*(endIndex_j-j);
                    pairs += n;
                } else{
                    //if here means both values are same then number of pairs would be
                    //choose 2 elements among n elements = nC2 = n(n+1)/2
                    int n = (i-startIndex_i)+(endIndex_j-j-1);
                    pairs += n*(n+1)/2;
                }
            }
        }
        System.out.println("Number of pairs with sum = " + K + " is/are: " + pairs);
    }

    public static void main(String[] args) {
        int input [] = {6, 3, 2, 9, 2, 2, 2, 1};
        findPairsCount(input, 4);
    }
}
