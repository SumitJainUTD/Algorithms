package Algo2019;

import java.util.ArrayList;

public class FindArmstrongNumbers {

    public void findArmStrongNumbers(int low, int high){

        //iterate through all the numbers in the range
        //check for each number it that it armstrong

        for (int i = low; i <=high ; i++) {
            if(isArmstrong(i))
                System.out.println("Armstrong number:" + i);
        }
    }

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
        int low = 100;
        int high = 1000;
        FindArmstrongNumbers f = new FindArmstrongNumbers();
        f.findArmStrongNumbers(low, high);
    }
}
