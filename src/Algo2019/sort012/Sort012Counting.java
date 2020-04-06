package Algo2019.sort012;

import java.util.Arrays;

public class Sort012Counting {
    
    public static void sort(int [] input){

        System.out.println("Given array: " + Arrays.toString(input));
        int count_0=0;
        int count_1=0;
        int count_2=0;
        
        //count the numbers
        for (int i = 0; i <input.length ; i++) {
            switch (input[i]){
                case 0:
                    count_0++;
                    break;
                case 1:
                    count_1++;
                    break;
                case 2:
                    count_2++;
                    break;
            }
        }

        //fill the input array with counts
        int index = 0;
        for (int i = 0; i <count_0 ; i++)
            input[index++]=0;
        for (int i = 0; i <count_1 ; i++)
            input[index++]=1;
        for (int i = 0; i <count_2 ; i++)
            input[index++]=2;

        System.out.println("Sorted Array: " + Arrays.toString(input));
    }

    public static void main(String[] args) {
        int [] input = {0, 0, 2, 0, 2, 1, 0, 1, 2};
        sort(input);
    }
}
