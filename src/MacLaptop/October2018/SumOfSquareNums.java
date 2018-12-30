package MacLaptop.October2018;

/**
 * Created by sjain on 10/20/18.
 */
public class SumOfSquareNums {
    public static boolean judgeSquareSum(int c) {
        if(c==1)
            return true;
        for(int i=1;i<=c/2;i++){
            int x = i*i;
            for(int j=0;j<=c/2;j++){
                if(j*j==(c-x))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(100000000));
    }
}
