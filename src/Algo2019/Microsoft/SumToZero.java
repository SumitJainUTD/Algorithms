package Algo2019.Microsoft;

import java.util.Arrays;

public class SumToZero {

    public void findSets(int N){

        int [] arrA = new int[N];

        int size = N;

        for (int i = 0; i <size/2 ; i++) {
            arrA[i] = (i+1)*-1;
        }

        if(N%2!=0) {
            for (int i = size / 2; i < size; i++) {
                arrA[i] = i - (size / 2);
            }
        }else{
            for (int i = size / 2; i < size; i++) {
                arrA[i] = i - ((size / 2)-1);
            }
        }
        System.out.println("Given N = " + N+ " Constructed Array: " + Arrays.toString(arrA) + ", required sum: " + 0);
    }

    public static void main(String[] args) {
        int N = 4;
        SumToZero s = new SumToZero();
        s.findSets(N);
    }
}
