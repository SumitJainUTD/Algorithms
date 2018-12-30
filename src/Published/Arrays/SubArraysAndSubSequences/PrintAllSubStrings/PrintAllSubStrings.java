package Published.Arrays.SubArraysAndSubSequences.PrintAllSubStrings;


public class PrintAllSubStrings {

    public void print(String input){

        int length = input.length();
        //start point
        for (int startPoint = 0; startPoint <length ; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <=length ; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                for (int j = startPoint ; j < grps ; j++) {
                    System.out.print(input.charAt(j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String input = "abcd";
        new PrintAllSubStrings().print(input);
    }
}
