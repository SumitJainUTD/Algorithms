package ThirdLot.Graph.MISC;

/**
 * Created by sumi1 on 5/15/2018.
 */
public class ConvertToBase3 {

    public static String convertToBase3(int N){
        String result = "";
        while(N>0){
            int rem = N%3;
            N = N/3;
            result = rem + result;
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 35;
        System.out.println("Base 3 representation of " + N + ": " + convertToBase3(N));
        N = 50;
        System.out.println("Base 3 representation of " + N + ": " + convertToBase3(N));
    }
}
