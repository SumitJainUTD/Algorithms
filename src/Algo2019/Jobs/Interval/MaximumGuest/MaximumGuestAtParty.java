package Algo2019.Jobs.Interval.MaximumGuest;

import java.util.Arrays;

public class MaximumGuestAtParty {

    public static void findMaximumGuest(int [] arrivals, int [] departures){

        System.out.println("Guest arrival times: " + Arrays.toString(arrivals));
        System.out.println("Guest departure times: " + Arrays.toString(departures));
        int maxGuests = 0;
        int currentGuests = 0;
        int time = -1;
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int i = 0;
        int j = 0;
        int size=arrivals.length;
        while(i< size && j < size){
            //pick minimum of  arrival[i] and departure[j] to decide whether what is happening next
            //arrival[i]<departure[j] then guest is arriving to party
            //arrival[i]>departure[j] then guest is leaving the party.
            if(arrivals[i] <= departures[j]){
                currentGuests++;
                if(maxGuests<currentGuests){
                    maxGuests = currentGuests;
                    time = arrivals[i];
                }
                i++;
            }
            else{
                currentGuests--;
                j++;
            }
        }
        System.out.println("Maximum guest at party: " + maxGuests + " at time: " + time);
    }

    public static void main(String[] args) {
        int arrivals[] = {0, 6, 1, 7, 9};
        int departures[] = {2, 7, 7, 12, 11};
        findMaximumGuest(arrivals, departures);
    }
}
