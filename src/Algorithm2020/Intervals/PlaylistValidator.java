package Algorithm2020.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PlaylistValidator {

    static class Program{
        int program_id;
        int start_time;
        int end_time;

        public Program(int program_id, int start_time, int end_time){
            this.program_id = program_id;
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }

    public void validatePlaylist(Program [] playlist){

        List<String> result = new ArrayList<>();

        if(playlist==null){
            result.add("Given playlist is null");
            return;
        }

        if(playlist.length==0){
            result.add("Given playlist is null");
            return;
        }

        //sort the programs as per start time
        Arrays.sort(playlist, Comparator.comparingInt(o -> o.start_time));

        Program prevProgram = playlist[0];
        validateTimes(prevProgram, result);

        for (int i = 1; i <playlist.length ; i++) {
            Program currProgram = playlist[i];
            validateTimes(currProgram, result);

            //Checking overlapping or gap
            if(currProgram.start_time<prevProgram.end_time){
                result.add("Program Id: " + prevProgram.program_id + " and Id: " + currProgram.program_id+" are overlapping");
            }
            if(prevProgram.end_time!=currProgram.start_time){
                result.add("Program Id: " + prevProgram.program_id + " and Id: " + currProgram.program_id+" are having gap");
            }
            prevProgram = currProgram;
        }
        //check if result is empty
        if(result.size()==0)
            //means playlist is valid
            System.out.println("Given playlist is valid");
        else{
            System.out.println("Given playlist is NOT valid due to following reasons - ");
            for (int i = 0; i <result.size() ; i++) {
                System.out.println(result.get(i));
            }
        }
        System.out.println("-----------------------------------------------");
    }

    void validateTimes(Program program, List<String> result){
        //    If the duration of any program is less than 10.
        //    If the duration of any program is greater than 200.
        //    If the duration of any program is negative.
        //    If the start time or end time of any program is negative.
        if(program.start_time<0 || program.end_time<0){
            result.add("Program Id: " + program.program_id + " has negative times");
        }
        int duration = program.end_time-program.start_time;
        if(duration<0){
            result.add("Program Id: " + program.program_id + " has negative duration");
        }
        if(duration<10){
            result.add("Program Id: " + program.program_id + " has duration less than 10");
        }
        if(duration>200){
            result.add("Program Id: " + program.program_id + " has duration greater than 200");
        }
    }
    public static void main(String[] args) {
        PlaylistValidator playlistValidator = new PlaylistValidator();

        Program[] playlist_1 = new Program[5];
        playlist_1[0] = new Program(111, 0, 10);
        playlist_1[1] = new Program(222, 100, 300);
        playlist_1[2] = new Program(333, 300, 350);
        playlist_1[3] = new Program(444, 10, 30);
        playlist_1[4] = new Program(555, 30, 100);
        playlistValidator.validatePlaylist(playlist_1);
        //////////////////////////////////////////////////////////////////
        Program[] playlist_2 = new Program[6];
        playlist_2[0] = new Program(111, 0, 10);
        playlist_2[2] = new Program(444, 10, 15);
        playlist_2[4] = new Program(555, 13, 17);
        playlist_2[5] = new Program(333, 20, 100);
        playlist_2[1] = new Program(222, 150, 350);
        playlist_2[3] = new Program(666, 350, -450);
        playlistValidator.validatePlaylist(playlist_2);
    }
}
