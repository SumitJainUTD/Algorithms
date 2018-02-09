package Arrays.MajorityElement;

import java.util.Arrays;

/**
 * Created by sjain on 8/12/17.
 */
public class MajorityElementSorting {
    public static void find(int [] arrA){
    if(arrA.length==0)
        return;
    boolean found = false;
    Arrays.sort(arrA);
    int count = 1;
    int x = arrA[0];
    for (int i = 1; i <arrA.length ; i++) {
        if(x==arrA[i]){
            count++;
            if(count>arrA.length/2) {
                System.out.println("(Sorting)Element appearing more than n/2 times: " + x);
                found = true;
                break;
            }
        }else{
            x = arrA[i];
            count = 1;
        }

    }
    if(!found)
        System.out.println("No element appearing more than n/2 times");
}

    public static void main(String[] args) {
        int [] arrA = {1,3,5,5,5,5,4,1,5};
        find(arrA);
    }
}
