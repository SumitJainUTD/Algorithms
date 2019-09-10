package Algo2019.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class FindAllPossibleCombinationsOfSizeKFromNumberN {

    public void findCombinations(int N, int K) {

        System.out.println("Given Number: " + N + ", subset size K: " + K);
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(N, K, 1, combinationList);
    }

    public void combinationUtil(int N, int K, int startNumber, List<Integer> combinationList) {

        if (K == 0) {
            System.out.println(combinationList);
            return;
        }

        for (int i = startNumber; i <= N; i++) {
            combinationList.add(i);
            combinationUtil(N, K-1, i + 1, combinationList);
            combinationList.remove(combinationList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int N = 6;
        int K = 5;
        FindAllPossibleCombinationsOfSizeKFromNumberN f = new FindAllPossibleCombinationsOfSizeKFromNumberN();
        f.findCombinations(N, K);
    }
}
