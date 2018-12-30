package Published.Arrays.LargestGap;

/**
 * Created by sumi1 on 6/23/2018.
 */
public class LargestGapNaive {

    static void findGap(int [] a){
        int maximum_diff = 0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 1; j <a.length ; j++) {
                int x = a[i];
                int y = a[j];
                int diff = Math.abs(x-y);
                if(maximum_diff<diff)
                    maximum_diff = diff;
            }
        }
        System.out.println("Largest Gap between any two elements is: " +  maximum_diff);
    }

    public static void main(String[] args) {
        int [] a = {2, 8, 1, 6, 10, 4};
        findGap(a);
        int [] b = {10, 30, 5, 16, 19};
        findGap(b);
    }
}
