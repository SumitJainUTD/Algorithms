package Algo2019.Jobs.activityselection.meetingRooms;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumRoomsForMeetings {
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "["+this.start+","+this.end+"]" ;
        }
    }
    static class Time{
        int time;
        String type;

        public Time(int time, String type) {
            this.time = time;
            this.type = type;
        }
    }

    public static void minimumRooms(ArrayList<Meeting> meetings){

        System.out.println("Given Meetings: " + meetings.toString());

        //insert all times into list
        ArrayList<Time> allTimesList = new ArrayList<>();
        for (int i = 0; i < meetings.size() ; i++) {
            allTimesList.add(new Time(meetings.get(i).start, "start"));
            allTimesList.add(new Time(meetings.get(i).end, "end"));
        }

        Collections.sort(allTimesList, (o1, o2) -> o1.time-o2.time);

        int roomsRequired = 0;
        int counter = 0;
        for (int i = 0; i <allTimesList.size() ; i++) {
            Time time = allTimesList.get(i);
            if (time.type.equals("start"))
                counter++;
            else
                counter--;
            if(counter>roomsRequired)
                roomsRequired = counter;
        }
        System.out.println("Minimum meeting rooms required: " +  roomsRequired);
    }

    public static void main(String[] args) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(0,2));
        meetings.add(new Meeting(3,8));
        meetings.add(new Meeting(1,6));
        meetings.add(new Meeting(8,9));
        minimumRooms(meetings);
    }
}
