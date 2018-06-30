package ThirdLot.MISC.LargestGap;

/**
 * Created by sumi1 on 6/23/2018.
 */
public class LargestGapBetter {

    static void findGap(int [] a){
        if(a==null || a.length==0){
            System.out.println("Array is null, no solution found");
        }
        int max_so_far=a[0];
        int min_so_far=a[0];
        int max_diff = 0;
        for (int i = 1; i <a.length ; i++) {
            if(a[i]>max_so_far)
                max_so_far = a[i];
            if(a[i]<min_so_far)
                min_so_far = a[i];
        }
        max_diff = max_so_far-min_so_far;
        System.out.println("Largest Gap between any two elements is: " +  max_diff);
    }

    public static void main(String[] args) {
        int [] a = {2, 8, 1, 6, 10, 4};
        findGap(a);
        int [] b = {10, 30, 5, 16, 19};
        findGap(b);
    }
}
