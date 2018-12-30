package Published.Arrays.TwoRepeatedElements;

/**
 * Created by sumi1 on 7/22/2017.
 */
public class TwoRepeatingBruteForce {
    //this solution will work even if all the numbers are not in the range of 1 to n
    public static void twoRepeating(int [] A){
        System.out.println("Repeated Elements: ");
        for (int i = 0; i <A.length ; i++) {
            for (int j = i+1; j <A.length ; j++) {
                if(A[i]==A[j]){
                    System.out.print(A[i] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] A = {1,5,2,4,8,9,3,1,4,0};
        twoRepeating(A);
    }
}
