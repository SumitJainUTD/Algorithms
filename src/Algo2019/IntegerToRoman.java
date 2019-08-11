package Algo2019;

/**
 * Created by sjain on 10/18/18.
 */
public class IntegerToRoman {

    public static void integerToRoman(int num) {

        System.out.println("Integer: " + num);
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        System.out.println("Roman: " + roman.toString());
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        integerToRoman(25);
        integerToRoman(36);
        integerToRoman(1023);
        integerToRoman(542);
    }
}
