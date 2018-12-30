package MacLaptop.SixthLot;

import java.util.Arrays;

/**
 * Created by sjain on 9/27/18.
 */
public class MnimumBoats {
    public static int numRescueBoats(int[] people, int limit) {


        Arrays.sort(people);

        int boats= 0;
        int currWgt =0;

        int i =0;
        int j = people.length-1;

        while(i<=j){
            currWgt = people[i] + people[j];
            if(currWgt>limit){
                j--;
            }else{
                i++;
                j--;
            }
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        int people [] = {5,1,4,2};
        int limit = 6;
        System.out.println(numRescueBoats(people, limit));

    }
}