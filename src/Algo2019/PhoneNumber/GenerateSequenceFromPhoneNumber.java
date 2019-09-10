package Algo2019.PhoneNumber;

public class GenerateSequenceFromPhoneNumber {

    public static final String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void generateSequence(long phoneNumber) {
        sequenceUtil(keypad, "", phoneNumber + "", 0);
    }

    public void sequenceUtil(String[] keypad, String sequence, String phoneNumber, int startIndex) {

        if (sequence.length() == phoneNumber.length()) {
            System.out.print(sequence + " ");
            return;
        }

        for (int i = startIndex; i < phoneNumber.length(); i++) {
            String charOptions  = keypad[phoneNumber.charAt(i)-'0'];
            for (int j = 0; j < charOptions.length(); j++) {
                sequenceUtil(keypad, sequence + charOptions.charAt(j), phoneNumber, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        long phoneNumber = 234;
        GenerateSequenceFromPhoneNumber g = new GenerateSequenceFromPhoneNumber();
        g.generateSequence(phoneNumber);
    }
}
