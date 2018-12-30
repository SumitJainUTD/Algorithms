package MacLaptop.ArrayProblems.ThreeNumbersSumK;

/**
 * Created by sjain on 8/11/17.
 */
public class ThreeNumbersSumKHashing {

    public static void find(int [] a, int k){
        for (int i = 0; i <a.length ; i++) {
            int x = a[i];
            //now problem is reduced to find two numbers in an array whose sum = M
            //here remainSum = k - x and array from index = 1 to end
            int M = k - x;
            int start = i + 1;
            int end = a.length - 1;
            boolean[] booleanMap = new boolean[99999]; //assume all arry elements are less than 99999

            for (int j=start; j<=end; j++)
            {
                int remain = M-a[i];

                // checking for condition
                if (remain>=0 && booleanMap[remain]==true) {
                    System.out.println("Found 3 elements whose sum is = " +k);
                    System.out.println("Elements are " + a[i] + " " + a[start]+ " " + a[end]);
                    return;
                }
                booleanMap[a[i]] = true;
            }
        }
    }
    public static void main(String[] args) {
        int a [] = { 3,1,7,4,5,9,10};
        int k = 21;
        find(a,k);
    }
}

