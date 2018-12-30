package MacLaptop.ArrayProblems.FirstDecreasingIndex;

/**
 * Created by sjain on 8/12/17.
 */
public class FirstDecreasingBruteForce {

    public static void find(int [] a){
        for (int i = 1; i <a.length ; i++) {
            if(a[i]<a[i-1]){
                System.out.println("First Element from where elements starts decreasing: " + a[i-1]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
        find(a);
    }
}
