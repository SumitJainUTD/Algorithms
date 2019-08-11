package Algo2019.CollatzConjecture;

public class CollatzConjectureRecursion {

    public int Step(int N){
        System.out.print("->"+ N);
        //base case
        if(N==1){
            return 0;
        }
        if(N%2==0){
            return Step(N/2) + 1;
        }
        else
            return Step(3*N+1) + 1;
    }

    public static void main(String[] args) {
        CollatzConjectureRecursion c = new CollatzConjectureRecursion();
        int N = 7;
        int steps = c.Step(N);
        System.out.println();
        System.out.println("Total Steps to transform N = " + N  +" to 1: " + steps);
        N = 6;
        steps = c.Step(N);
        System.out.println();
        System.out.println("Total Steps to transform N = " + N  +" to 1: " + steps);

        System.out.println("////////////////////////////////////////");

        for (int i = 1; i <=8 ; i++) {
            steps = c.Step(i);
            System.out.println();
            System.out.println("Total Steps to transform N = " + i  +" to 1: " + steps);
        }
    }
}
