package SecondLot.ArrayProblems.Median;

import java.util.Arrays;

/**
 * Created by sjain on 8/22/17.
 */
public class MedianBruteForce {

    public static void find(int [] a, int [] b){
        int [] c = new int [a.length+b.length];
        int index =0;
        int i=0,j = 0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                c[index]=a[i];
                i++;
            }else{
                c[index]=b[j];
                j++;
            }
            index++;
        }
        if(i>=a.length){
            //a[] is over, copy the rest of the elements of b
            while(j<b.length){
                c[index]=b[j];
                index++;
                j++;
            }
        }

        if(j>=b.length){
            //a[] is over, copy the rest of the elements of b
            while(i<a.length){
                c[index]=a[i];
                index++;
                i++;
            }
        }
        // we have a combined array, now we can find the median
        System.out.println(Arrays.toString(c));
        double median;
        int newLength = c.length;
        if(newLength%2==0){
            float x = c[(newLength-1)/2];
            float y = c[(newLength)/2];
            median = (x+y)/2;
        }else{
            median = c[(newLength-1)/2];
        }
        System.out.println("Median of combined sorted array is: " + median);

    }

    public static void main(String[] args) {
        int [] a = {2,6,9};
        int [] b = {1,5,7};
        find(a,b);
    }
}
