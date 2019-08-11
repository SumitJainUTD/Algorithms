package Algo2019.CollatzConjecture.CollatzConjectureProblem;

import java.util.HashMap;

public class CollatzConjectureMaxStepsDP {

    public int maxSteps(int N) {
        int maxSteps = 0;
        HashMap<Integer, Integer> stepsMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int steps = getSteps(i, stepsMap);
            maxSteps = Math.max(maxSteps, steps);
        }
        return maxSteps;
    }


    public int getSteps(int k, HashMap<Integer, Integer> stepsMap) {
        //base case
        if (k == 1) {
            return 0;
        }
        if(stepsMap.containsKey(k)){
            return stepsMap.get(k);
        }
        if (k % 2 == 0) {
            int steps = getSteps(k / 2, stepsMap) + 1;
            stepsMap.put(k, steps);
            return steps;
        } else {
            int steps = getSteps(3 * k + 1, stepsMap) + 1;
            stepsMap.put(k, steps);
            return steps;
        }
    }

    public static void main(String[] args) {
        CollatzConjectureMaxStepsDP c = new CollatzConjectureMaxStepsDP();
        int N = 7;
        int steps = c.maxSteps(N);
        System.out.println();
        System.out.println("Max Steps needed to transform (1, " + N + " ) to 1: " + steps);
        N = 6;
        steps = c.maxSteps(N);
        System.out.println();
        System.out.println("Max Steps needed to transform (1, " + N + " ) to 1: " + steps);
    }
}
