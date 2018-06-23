package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/14/2018.
 */
public class LargestElementInArray {

    static void findLargestElement(int [] a){
        if(a.length==0)
            return;
        int largest_element = a[0];

        for (int i = 1; i <a.length ; i++) {
            if(a[i]>largest_element)
                largest_element = a[i];
        }
        System.out.println("Largest element in array: " + largest_element);
    }
    public static void main(String[] args) {
        int [] a = {1, 5, 3, 9, 2, 8, 2};
        findLargestElement(a);
    }
}
