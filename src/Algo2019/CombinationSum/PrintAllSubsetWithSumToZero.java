package Algo2019.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubsetWithSumToZero {

    public void findSets(int [] arrA){

        System.out.println("Given Array: " + Arrays.toString(arrA) + ", required sum: " + 0);
        Arrays.sort(arrA);
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(arrA, 0, 0, combinationList);
    }

    public void combinationUtil(int arrA[], int currSum, int start, List<Integer> combinationList) {

        if (currSum == 0 && combinationList.size() > 0) {
            System.out.println(combinationList);
            return;
        }

        for (int i = start; i < arrA.length; i++) {
            if (currSum + arrA[i] > 0) //array is sorted, no need to check further
                break;
            combinationList.add(arrA[i]);
            combinationUtil(arrA, currSum + arrA[i], i + 1, combinationList);
            combinationList.remove(combinationList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] arrA = {8,3,5,1,-4,-8};
        PrintAllSubsetWithSumToZero p = new PrintAllSubsetWithSumToZero();
        p.findSets(arrA);
    }
}
