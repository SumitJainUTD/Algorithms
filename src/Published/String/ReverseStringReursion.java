package Published.String;

/**
 * Created by sumi1 on 6/26/2018.
 */
public class ReverseStringReursion {

    static String reverse(String input){
        //base case
        if(input.isEmpty())
            return null;
        //take the first character out and add it to the
        // end of the result of rest of the string
        return reverse(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        String input = "tutorial horizon";
        System.out.println("Input String: " + input);
        System.out.println("Output String: " + reverse(input));
        input = "test string";
        System.out.println("Input String: " + input);
        System.out.println("Output String: " + reverse(input));
    }
}
