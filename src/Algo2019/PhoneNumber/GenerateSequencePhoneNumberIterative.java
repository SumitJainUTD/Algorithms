package Algo2019.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class GenerateSequencePhoneNumberIterative {
    public static final String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> generateSequence(String phoneNumber){
        List<String> results = new ArrayList<>();
        results.add("");
        for (int i = 0; i <phoneNumber.length() ; i++) {
            ArrayList<String> temp = new ArrayList<>();
            String charOptions = keypad[phoneNumber.charAt(i)-'0'];
            for (int c = 0; c < charOptions.length();c++) {
                for (int j = 0; j < results.size(); j++) {
                    temp.add(results.get(j) + charOptions.charAt(c));
                }
            }
            results = temp;
        }

        return results;
    }

    public static void main(String[] args) {
        String phoneNumber = "234";
        GenerateSequencePhoneNumberIterative g = new GenerateSequencePhoneNumberIterative();
        List<String> results = g.generateSequence(phoneNumber);
        for (int i = 0; i <results.size() ; i++) {
            System.out.print(results.get(i) + " ");
        }
    }
}
