package Algo2019.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class FindCombinationsSumToN {

    public void findCombinations(int n){
        System.out.println("N = " +n);
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(n, 0, 1, combinationList);
    }

    public void combinationUtil(int n, int sum, int start, List<Integer> combinationList){

        if(sum==n) {
            System.out.println(combinationList);
            return;
        }

        for (int i = start; i <=9 ; i++) {
            combinationList.add(i);
            combinationUtil(n, sum + i, i + 1, combinationList);
            combinationList.remove(combinationList.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 12;
        FindCombinationsSumToN c = new FindCombinationsSumToN();
        c.findCombinations(n);
    }
}
