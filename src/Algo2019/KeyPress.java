package Algo2019;

import java.util.ArrayList;
import java.util.List;

public class KeyPress {

    public static void findKeyAndDuration(List<Integer[]> keyTimes){

        int chaASCII = keyTimes.get(0)[0]+65;
        int duration  = keyTimes.get(0)[1];
        int max_duration = duration;
        char c = (char)(chaASCII);
        for (int i = 1; i <keyTimes.size() ; i++) {
            Integer [] keyPress = keyTimes.get(i);
            Integer [] old_keyPress = keyTimes.get(i-1);
            int chaASCII_new = keyPress[0]+65;
            int duration_current  = keyPress[1]-old_keyPress[1];
            if(duration_current>duration) {
                c = (char) (chaASCII_new);
                max_duration = duration_current;
            }
            duration = duration_current;
        }
        System.out.println("Longest keypressed: '" + c + "' for duration: " + max_duration);
    }

    public static void main(String[] args) {
        Integer [] firstEntry = {0, 2};
        Integer [] secondEntry = {1, 4};
        Integer [] thirdEntry = {6, 5};
        Integer [] fourthEntry = {9, 12};
        Integer [] fifthEntry = {0, 16};

        List<Integer[]> keyTimes = new ArrayList<>();
        keyTimes.add(firstEntry);
        keyTimes.add(secondEntry);
        keyTimes.add(thirdEntry);
        keyTimes.add(fourthEntry);
        keyTimes.add(fifthEntry);

        findKeyAndDuration(keyTimes);
    }
}
