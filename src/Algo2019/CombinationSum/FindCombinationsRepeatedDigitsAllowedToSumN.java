package Algo2019.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCombinationsRepeatedDigitsAllowedToSumN {

    public void findSets(int [] arrA, int sum){
        System.out.println("Given Array: " + Arrays.toString(arrA) + ", required sum: " + sum);
        Arrays.sort(arrA);
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(arrA, sum, 0, 0, combinationList);
    }

    public void combinationUtil(int arrA[] , int sum, int currSum, int startIndex, List<Integer> combinationList){

        if(currSum==sum) {
            System.out.println(combinationList);
            return;
        }

        for (int i = startIndex; i <arrA.length ; i++) {
            if(currSum+arrA[i]>sum) //array is sorted, no need to check further
                break;
            combinationList.add(arrA[i]);
            combinationUtil(arrA, sum, currSum + arrA[i], i, combinationList);
            combinationList.remove(combinationList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] arrA={2,6,3,5};
        int n =8;
        FindCombinationsRepeatedDigitsAllowedToSumN f = new FindCombinationsRepeatedDigitsAllowedToSumN();
        f.findSets(arrA, n);
    }
}

