package Algo2019.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubsetWithSum {

    public void findSets(int [] arrA, int sum){
        System.out.println("Given Array: " + Arrays.toString(arrA) + ", required sum: " + sum);
        Arrays.sort(arrA);
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(arrA, sum, 0, 0, combinationList);
    }

    public void combinationUtil(int arrA[] , int sum, int currSum, int start, List<Integer> combinationList){

        if(currSum==sum) {
            System.out.println(combinationList);
            return;
        }

        int prevElement = -1;
        for (int i = start; i <arrA.length ; i++) {
            if(prevElement!=arrA[i]) {
                if(currSum+arrA[i]>sum) //array is sorted, no need to check further
                    break;
                combinationList.add(arrA[i]);
                combinationUtil(arrA, sum, currSum + arrA[i], i + 1, combinationList);
                combinationList.remove(combinationList.size() - 1);
                prevElement = arrA[i];
            }
        }
    }

    public static void main(String[] args) {
        int [] arrA = {6,2,7,8,2,4,1,3,7,5};
        int n = 8;
        PrintAllSubsetWithSum p = new PrintAllSubsetWithSum();
        p.findSets(arrA, n);
    }
}
