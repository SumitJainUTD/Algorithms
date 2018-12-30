package MacLaptop.October2018.PerfectSquare;

/**
 * Created by sjain on 10/20/18.
 */
public class PerfectSquareBinary {
    public static boolean isPerfectSquare(int num) {
        if(num==0||num==1)
            return true;
        int left = 0;
        int right = num;

        while(left<=right){
            int mid = right - (right-left)/2;
            if(num%mid==0 && mid==num/mid)
                return true;
            else if(mid<num/mid)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
}
