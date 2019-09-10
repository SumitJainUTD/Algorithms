package Algo2019;

import java.util.ArrayList;

public class NumberDivisibleByDigits {

    public boolean isDivisible(int num){

        ArrayList<Integer> digits = getDigits(num);

        for (int i = 0; i <digits.size() ; i++) {
            int x = digits.get(i);
            if(num % x !=0)
                return false;
        }
        return true;
    }


    ArrayList<Integer> getDigits(int num){

        ArrayList<Integer> digits = new ArrayList<>();
        while (num>0){
            int x = num%10;
            num = num/10;
            digits.add(x);
        }
        return digits;
    }

    public static void main(String[] args) {
        NumberDivisibleByDigits d = new NumberDivisibleByDigits();
        for (int i = 11; i <20 ; i++) {
            System.out.println("Number " + i + " is divisible by it digits: " + d.isDivisible(i) );
        }
    }
}
