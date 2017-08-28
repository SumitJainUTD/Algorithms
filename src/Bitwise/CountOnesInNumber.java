package Bitwise;
//not in TH
/**
 * Created by sumi1 on 7/13/2017.
 */
public class CountOnesInNumber {

    //Method 1
    public static void count_method1(int number){
        int one = 1;
        int count = 0;
        int n = number;
        while(number>0){
            count = count + (number & 1);
            int x = number & 1;
            number >>= 1;
        }
        System.out.println("Number of 1's in the binary representation of " + n + " is: " + count);
    }

    //Method 2
    public static void count_method2(int number){
        int count = 0;
        int n = number;
        while(number>0){
            if(number%2==1)
                count++;
            number=number/2;
        }
        System.out.println("Number of 1's in the binary representation of " + n + " is: " + count);
    }

    //Method 3
    public static void count_method3(int number){
        int count = 0;
        int n = number;
        while(number>0){
            count++;
            number = number & number-1;
        }
        System.out.println("Number of 1's in the binary representation of " + n + " is: " + count);
    }

    public static void main(String[] args) {
        int number = 6;
        count_method1(number);
        count_method2(number);
        count_method3(number);
    }
}
