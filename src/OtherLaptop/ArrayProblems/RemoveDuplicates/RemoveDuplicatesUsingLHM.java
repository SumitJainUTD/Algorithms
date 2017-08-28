package OtherLaptop.ArrayProblems.RemoveDuplicates;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by sjain on 8/12/17.
 */
public class RemoveDuplicatesUsingLHM {
    public static String removeDuplicates(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        Iterator<Character> iterator = set.iterator();
        String sbString = new String();
        while (iterator.hasNext())
            sbString += iterator.next() + "";

        return sbString;
    }

    public static void main(String[] args) {
        String s = "tutorialhorizon";
        System.out.println(removeDuplicates(s));
    }
}
