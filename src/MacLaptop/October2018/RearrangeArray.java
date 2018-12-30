package MacLaptop.October2018;

import java.util.Arrays;

/**
 * Created by sjain on 10/14/18.
 */
public class RearrangeArray {

    public static void arrange(int [] arr){

        for (int i = 0; i <arr.length ; i++) {
            int x = i;
            while(arr[x]!=-1 && arr[x] !=x){
                int y = arr[x];
                int t = arr[y];
                arr[y] = y;
                arr[x] = t;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int A[] = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2,
                14, 17, 4 };
        arrange(A);
    }
}
