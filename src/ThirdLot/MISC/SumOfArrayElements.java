package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/9/2018.
 */
public class SumOfArrayElements {

    static void getSum(int [] input){
        int sum = 0;
        for (int i = 0; i <input.length ; i++) {
            sum += input[i];
        }

        System.out.println("Sum of all array elements: " + sum);
    }

    public static void main(String[] args) {
        int input [] = {20, 30, 40, 10, 5, 2, 60, 73};
        getSum(input);
    }
}
