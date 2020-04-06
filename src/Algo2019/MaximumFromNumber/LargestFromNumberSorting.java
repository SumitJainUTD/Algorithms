package Algo2019.MaximumFromNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestFromNumberSorting {

    public static void getLargest(int input){

        System.out.println("Given Input: " +  input);

        //negative handle here
        boolean isNegative = false;

        if(input<0){
            isNegative = true;
            input *= -1;
        }

        List<Integer> list = new ArrayList<>();
        while (input>0){
            int n = input%10;
            input = input/10;
            list.add(n);
        }

        if(isNegative){
            Collections.sort(list);
        }else{
            Collections.sort(list, Collections.reverseOrder());
        }

        int result = 0;

        for(int i = 0;i<list.size();i++){
            result =  result*10;
            result +=list.get(i);
        }

        if(isNegative)
            result *= -1;

        System.out.println("Largest Integer can be formed: " + result);
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        getLargest(34277765);
        getLargest(-342765);
        getLargest(0);
        getLargest(2034);
    }
}
