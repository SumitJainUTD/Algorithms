package MacLaptop.ArrayProblems.ThreeNumbersSumK;

/**
 * Created by sjain on 8/11/17.
 */
public class ThreeNumbersSumKBruteForce {

    public static void find(int [] a, int k){
        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                for (int l = j+1; l <a.length ; l++) {
                    if(a[i]+a[j]+a[l]==k){
                        System.out.println("Found 3 elements whose sum is = " +k);
                        System.out.println("Elements are " + a[i] + " " + a[j]+ " " + a[l]);
                        return;
                    }
                }
            }
        }
        System.out.println("Did not find 3 elements whose sum is = " +k);
    }
    public static void main(String[] args) {
        int a [] = { 3,1,7,4,5,9,10};
        int k = 21;
        find(a,k);
    }
}
