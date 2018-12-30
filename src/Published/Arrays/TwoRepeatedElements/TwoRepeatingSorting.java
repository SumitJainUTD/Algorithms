package Published.Arrays.TwoRepeatedElements;


import java.util.Arrays;

/**
 * Created by sumi1 on 7/24/2017.
 */
public class TwoRepeatingSorting {

    public static void twoRepeating(int [] A){
        Arrays.sort(A);
        System.out.print("Repeated Elements are: ");
        for (int i = 0; i <A.length-1 ; i++) {
            if(A[i]==A[i+1])
                System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        int [] A = {1,4,5,6,3,2,5,2};
        twoRepeating(A);
    }
}
