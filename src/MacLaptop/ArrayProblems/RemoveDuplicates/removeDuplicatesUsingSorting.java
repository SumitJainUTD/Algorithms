package MacLaptop.ArrayProblems.RemoveDuplicates;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by sjain on 8/12/17.
 */
public class removeDuplicatesUsingSorting {
    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // O(nlogn)
        String sbString = new String();
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]!=chars[i-1])
                sbString +=chars[i];
        }
        //handle the first character
        if(chars[0]!=chars[1])
            sbString = chars[0] + sbString;
        return sbString;
    }

    public static void main(String[] args) {
        String s = "tutorialhorizon";
        System.out.println(removeDuplicates(s));
    }
}
