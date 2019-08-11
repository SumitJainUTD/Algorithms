package Algo2019.CollatzConjecture.CollatzConjectureProblem;


public class CollatzConjectureMaxSteps {
    
    public int maxSteps(int N){
        int maxSteps = 0;

        for (int i = 1; i <=N ; i++) {
            int steps = getSteps(i);
            maxSteps = Math.max(maxSteps, steps);
        }
        return maxSteps;
    }


    public int getSteps(int k){
        //base case
        if(k==1){
            return 0;
        }
        if(k%2==0){
            return getSteps(k/2) + 1;
        }
        else
            return getSteps(3*k+1) + 1;
    }

    public static void main(String[] args) {
        CollatzConjectureMaxSteps c = new CollatzConjectureMaxSteps();
        int N = 7;
        int steps = c.maxSteps(N);
        System.out.println();
        System.out.println("Max Steps needed to  to transform (1, " + N  +" ) to 1: " + steps);
        N = 6;
        steps = c.maxSteps(N);
        System.out.println();
        System.out.println("Max Steps needed to  to transform (1, " + N  +" ) to 1: " + steps);
    }
}
