package OtherLaptop.ArrayProblems;

/**
 * Created by sjain on 8/12/17.
 */
public class EveryElementRepeatedThriceButOne {


    public static void find(int [] a, int n){

        if(a.length==0)
            return;;
        //we know -> a XOR a = 0
        //first XOR all the elements in array. it will give the XOR of all elements repeated thrice
        int xor =a[0];
        //element appears twice will be removed
        for (int i = 1; i <a.length ; i++) {
            xor ^= a[i];
        }

        //Now XOR it will all elements from 1  to n range.
        //this will separate out the element appear twice
        for (int i = 1; i <=n ; i++) {
            xor ^= i;
        }
        System.out.println("Element appearing twice in array is: " + xor);

    }
    public static void main(String[] args) {
        int a []  = { 2,1,3,4,3,2,1,4,1,2,3};
        int n = 4;
        find(a,n);
    }
}
