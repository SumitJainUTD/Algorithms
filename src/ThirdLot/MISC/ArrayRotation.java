package ThirdLot.MISC;

import java.util.Arrays;

public class ArrayRotation {

    static void rotate(int [] arr){
        System.out.println("Original Array: " + Arrays.toString(arr));
        if(arr==null || arr.length==0)
            return ;

        int temp = arr[0];

        for (int i = 1; i <arr.length ; i++) {
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = temp;
        System.out.println("Rotated Array: " +  Arrays.toString(arr));
        System.out.println("_______________________________");
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        rotate(arr);
        rotate(arr);
    }
}
