package Algo2019.Jobs.Interval.MaximumGuest;

import java.util.Arrays;

public class MaximumGuestAtPartyOofN {

    public static void findMaxGuests(int [] arrivals , int [] departures ) {

        System.out.println("Guest arrival times: " + Arrays.toString(arrivals));
        System.out.println("Guest departure times: " + Arrays.toString(departures));

        int size = arrivals.length;
        // Find the time when the last guest left the part
        int last_time = Arrays.stream(departures).max().getAsInt();

        int []count = new int[last_time+2];

        //fill the count array
        for(int i = 0; i < size; i++) {
            //When guest comes in, do +1 at the arrival time index
            ++count[arrivals [i]];
            // guest leaves the party, do -1  at the departure time index
            --count[departures[i]+1];
        }

        int currentGuest=0;
        int time=0;
        int maxGuest=0;

        for(int i = 0; i < last_time; i++) {
            currentGuest += count[i];
            if(maxGuest < currentGuest) {
                maxGuest = currentGuest;
                time = i;
            }
        }
        System.out.println("Maximum Guests at party are: "+ maxGuest+ " at time: " +time);
    }

    public static void main(String[] args) {
        int arrivals[] = {0, 6, 1, 7, 9};
        int departures[] = {2, 7, 7, 12, 11};
        findMaxGuests(arrivals,departures);
    }
}
