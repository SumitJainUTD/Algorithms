package MacLaptop.Bitwise.TwoNonRepeatingNumbers;

import java.util.Arrays;


/**
 * Created by sjain on 8/16/17.
 */
public class TwoNonRepeatingSorting {
    public void find(int [] arrA){

        Arrays.sort(arrA);
        for (int i = 0; i <arrA.length-1 ; i++) {
            if(!(arrA[i]==arrA[i+1]))
                System.out.println("Non Repeating Element: " + arrA[i]);
            else
                i++;
        }


    }

    public static void main(String[] args) {
        TwoNonRepeatingSorting t = new TwoNonRepeatingSorting();
        int [] arrA = {6,3,1,1,2,3,5,7,7,5};
        t.find(arrA);
    }
}
