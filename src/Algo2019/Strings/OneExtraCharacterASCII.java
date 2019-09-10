package Algo2019.Strings;

public class OneExtraCharacterASCII {

    public void getExtraCharacter(String firstString, String secondString){

        int ascii_firstString = 0;
        int ascii_secondString = 0;

        for (int i = 0; i <firstString.length() ; i++) {
            char c = firstString.charAt(i);
            ascii_firstString +=c;
        }

        for (int i = 0; i <secondString.length() ; i++) {
            char c = secondString.charAt(i);
            ascii_secondString +=c;
        }

        int diff = Math.abs(ascii_firstString-ascii_secondString);

        System.out.println("String 1: " +  firstString + ", String 2: " + secondString);
        System.out.println("Extra character is: " + (char)(diff));
    }

    public static void main(String[] args) {

        OneExtraCharacterASCII o = new OneExtraCharacterASCII();

        String input1 = "tutorial&horizon";
        String input2 = "tutorialhorizon";
        o.getExtraCharacter(input1, input2);
        System.out.println("--------------------------------------");
        input1 = "abcdef";
        input2 = "fgabdec";
        o.getExtraCharacter(input1, input2);
    }
}
