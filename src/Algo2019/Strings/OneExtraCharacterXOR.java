package Algo2019.Strings;

public class OneExtraCharacterXOR {

    public void getExtraCharacter(String firstString, String secondString){

        int xor = 0;

        for (int i = 0; i <firstString.length() ; i++) {
            char c = firstString.charAt(i);
            xor = xor^c;
        }

        for (int i = 0; i <secondString.length() ; i++) {
            char c = secondString.charAt(i);
            xor = xor^c;
        }

        System.out.println("String 1: " +  firstString + ", String 2: " + secondString);
        System.out.println("Extra character is: " + (char)(xor));
    }

    public static void main(String[] args) {

        OneExtraCharacterXOR o = new OneExtraCharacterXOR();

        String input1 = "tutorial&horizon";
        String input2 = "tutorialhorizon";
        o.getExtraCharacter(input1, input2);
        System.out.println("--------------------------------------");
        input1 = "abcdef";
        input2 = "fgabdec";
        o.getExtraCharacter(input1, input2);
    }
}
