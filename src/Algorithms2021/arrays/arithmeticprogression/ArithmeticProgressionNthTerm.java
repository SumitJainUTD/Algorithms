package Algorithms2021.arrays.arithmeticprogression;

public class ArithmeticProgressionNthTerm {

    public static void printAPNthTerm(int a, int d, int n){
        System.out.println("a = " + a +", d = " + d + ", n = " + n);
        int term = a + (n-1)*d;
        System.out.println(n + "th term: " + term);
    }

    public static void main(String[] args) {
        printAPNthTerm(1, 2, 5);
        printAPNthTerm(2, 5, 4);
    }
}
