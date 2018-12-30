package MacLaptop.October2018;

import java.util.Arrays;

/**
 * Created by sjain on 10/17/18.
 */
public class CountingSort {

    public void sort(int [] arrA, int n){

        int [] Result = new int [arrA.length+1];
        int [] count = new int [n+1];

        //count all the elements

        for (int i = 0; i <arrA.length ; i++) {
            int num = arrA[i];

            //put it at the right place in count array
            int x = count[num];
            count[num]=x+1;
        }

        //in count array do count[x+1] = count [x]+count[x+1]

        for (int i = 1; i <count.length ; i++) {
            count[i] = count[i] + count[i-1];
        }

        //traverse the input array and check its position in count array and place it in diff array

        for (int i = 0; i <arrA.length ; i++) {
            int num = arrA[i];

            int x = count[num];

            Result[x] = num;

            count[num] = --x;
        }

        System.out.println(Arrays.toString(Result));

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int input[] = { 2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4 };
        System.out.println("Orginal Array " + Arrays.toString(input));
        CountingSort c = new CountingSort();
        c.sort(input, 15);


    }
}
