package Arrays.LocalMax;

import java.util.Arrays;
public class LocalMaxORMin {

    private static void find(int[] a) {
        if(a==null||a.length==0){
            System.out.println("No Local maximum or minimum");
            return;
        }
        int size = a.length;
        int first_element = a[0];
        int last_element = a[size-1];
        if(first_element+size-1==last_element || first_element-size+1==last_element){
            System.out.println("No Local maximum or minimum");
            return;
        }
        if(first_element<a[1]){
            //lets find local maximum
            int last_should_be = first_element+(size-1);
            int local_max = (last_should_be+last_element)/2;
            System.out.println("local maximum: " + local_max);
        }else{
            //lets find local maximum
            int last_should_be = first_element-(size-1);
            int local_min = (last_should_be+last_element)/2;
            System.out.println("local minimum: " + local_min);
        }

    }
    public static void main(String[] args) {
        int a []  = {3,4,5,4,3,2,1,0,-1};
        System.out.print(Arrays.toString(a));
        find(a);
        int b []  = {-4,-5,-6,-5,-4,-3};
        System.out.print(Arrays.toString(b));
        find(b);
    }
}
