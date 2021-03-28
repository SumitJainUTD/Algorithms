package Algorithms2021.arrays.arithmeticprogression;

public class ArithmeticProgressionSeries {

    public static void printAP(int a, int d, int n){
        System.out.println("a = " + a +", d = " + d + ", n = " + n);
        for (int i = 1; i <=n ; i++) {
            int term = a + (i-1)*d;
            System.out.print(term + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printAP(1, 2, 5);
        printAP(2, 5, 7);
    }
}
