package MacLaptop.SixthLot;

import java.util.Arrays;
public class MinimumBoats {
    public static int numRescueBoats(int[] people, int limit) {


        Arrays.sort(people);

        int boats= 0;
        int currWgt =0;

        int i =0;
        int j = people.length-1;

        while(i<=j){
            currWgt = people[i] + people[j];
            if(currWgt<=limit){
                i++;
            }
            j--;
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        int people [] = {3,4,1,2};
        int limit = 4;
        System.out.println("Total Number of boats required: " + numRescueBoats(people, limit));

    }
}