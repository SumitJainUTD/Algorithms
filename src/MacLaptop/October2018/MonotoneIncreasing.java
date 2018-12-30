package MacLaptop.October2018;

/**
 * Created by sjain on 10/12/18.
 */
public class MonotoneIncreasing {

    public static int monotoneIncreasingDigits(int N) {


        char[] x = String.valueOf(N).toCharArray();

        int mark = x.length;
        for(int i = x.length-1;i>0;i--){
            if(x[i]<x[i-1]){
                mark = i-1;
                x[i-1]--;
            }
        }
        for(int i = mark+1;i<x.length;i++){
            x[i] = '9';
        }
        return Integer.parseInt(new String(x));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
    }
}
