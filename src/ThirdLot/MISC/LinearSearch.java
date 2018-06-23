package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/8/2018.
 */
public class LinearSearch {

    static void search(int [] input, int x){

        for (int i = 0; i <input.length ; i++) {
            if(x==input[i]) {
                System.out.println("Element " + x + " is found at index: " + i);
                return;
            }
        }
        //if here means x is not found
        System.out.println("Element " + x + " is not found in array");
    }

    public static void main(String[] args) {
        int input [] = {20, 30, 40, 10, 5, 2, 60, 73};
        int x = 10;
        search(input, x);
        x = 60;
        search(input, x);
        x = 9;
        search(input, x);
    }
}
