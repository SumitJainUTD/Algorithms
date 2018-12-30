package MacLaptop.SixthLot;

/**
 * Created by sjain on 9/18/18.
 */
public class PrintAllSubstring {



    public static void subStrings(String s){

        int size = s.length();

        for ( int start = 0 ;start<size ; start++) {

            for (int grp = start+1; grp<=size ; grp++) {

                System.out.println(s.substring(start, grp));
            }
        }
    }

    public static void main(String[] args) {
        String s = "123";
        subStrings(s);
    }
}
