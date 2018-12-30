package MacLaptop.October2018;

/**
 * Created by sjain on 10/20/18.
 */
public class SqrtRoot {
    public static int mySqrt(int x) {

        if(x==0||x==1)
            return x;
        int left = 0;
        int right = x;

        while(left<=right){
            int mid = right - (right-left)/2;
            if(x%mid==0 && mid==x/mid)
                return mid;
            else if(mid<x/mid)
                left = mid+1;
            else if(mid>x/mid)
                right = mid-1;
            else
                return mid;

        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
