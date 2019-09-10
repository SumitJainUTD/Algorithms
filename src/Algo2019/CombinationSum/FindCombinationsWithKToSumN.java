package Algo2019.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class FindCombinationsWithKToSumN {

    public void findCombinations(int n, int k){
        System.out.println("N = " +n + " K = " +k);
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(k, n, 0, 1, combinationList);
    }

    public void combinationUtil(int k, int n, int sum, int start, List<Integer> combinationList){

        if(k==0) {
            if(sum==n) {
                System.out.println(combinationList);
            }
            return;
        }

        for (int i = start; i <=9 ; i++) {
            combinationList.add(i);
            combinationUtil(k - 1, n, sum + i, i + 1, combinationList);
            combinationList.remove(combinationList.size()-1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 12;
        FindCombinationsWithKToSumN c = new FindCombinationsWithKToSumN();
        c.findCombinations(n,k);
    }
}