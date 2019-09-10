package Algo2019;

import java.util.ArrayList;

public class ArmstrongNumber {

    public boolean isArmstrong(int num){
        if(num<=0)
            return false;

        ArrayList<Integer> digits = getDigits(num);
        int size = digits.size();

        int newNo=0;

        for (int i = 0; i <digits.size() ; i++) {
            newNo += Math.pow(digits.get(i), size);
        }
        return newNo==num? true:false;
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
        ArmstrongNumber a = new ArmstrongNumber();
        int num = 123;
        System.out.println("Number " + num + " is Armstrong Number: " + a.isArmstrong(num));
        num = 153;
        System.out.println("Number " + num + " is Armstrong Number: " + a.isArmstrong(num));
        num = 1634;
        System.out.println("Number " + num + " is Armstrong Number: " + a.isArmstrong(num));
        num = 2356;
        System.out.println("Number " + num + " is Armstrong Number: " + a.isArmstrong(num));
    }
}
