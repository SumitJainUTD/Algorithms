package Algo2019.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class FindCombinationsWithSumKFromNumberN {

    public void findCombinations(int N, int K){
        System.out.println("Given Number: " + N + ", required sum K: " + K);
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(N, K, 0, 1, combinationList);
    }

    public void combinationUtil(int N , int sum, int currSum, int startNumber, List<Integer> combinationList){

        if(currSum==sum) {
            System.out.println(combinationList);
            return;
        }

        for (int i = startNumber; i <=N ; i++) {
            if(currSum+i>sum)
                break;
            combinationList.add(i);
            combinationUtil(N, sum, currSum + i, i, combinationList);
            combinationList.remove(combinationList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int N = 6;
        int K =5;
        FindCombinationsWithSumKFromNumberN f = new FindCombinationsWithSumKFromNumberN();
        f.findCombinations(N, K);
    }
}
