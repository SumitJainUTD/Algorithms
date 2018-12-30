package Published.Arrays;

/**
 * Created by sumi1 on 6/1/2018.
 */
public class CompareStrings {

    public static boolean compare(String x, String y){
        if(x==null || y==null){
            return false;
        }
        //compare lengths
        if(x.length()!=y.length())
            return false;

        //compare all characters
        for (int i = 0; i <x.length() ; i++) {
            if(x.charAt(i)!=y.charAt(i))
                return false;
        }
        //if here, means both strings are equal
        return true;
    }

    public static void main(String[] args) {
        String x = "tutorial";
        String  y = "tutorial";
        System.out.println("String x='" + x + "' and String y='" + y + "' are equal?? -" + compare(x, y));
        x = "tutorial";
        y = "tutorial ";
        System.out.println("String x='" + x + "' and String y='" + y + "' are equal?? -" + compare(x, y));
        x = "tutorial";
        y = " ";
        System.out.println("String x='" + x + "' and String y='" + y + "' are equal?? -" + compare(x, y));
    }
}
