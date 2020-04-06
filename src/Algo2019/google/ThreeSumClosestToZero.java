package Algo2019.google;

import java.util.Arrays;

public class ThreeSumClosestToZero {

    public static int findSumClosestToZero(int [] input){
        int minSumPositive = Integer.MAX_VALUE;
        int minSumNegative = Integer.MIN_VALUE;
        if(input.length<3) {
            System.out.println("Invalid input");
            return minSumPositive;
        }
        System.out.println("Given Input: " +  Arrays.toString(input));

        //sort the array in ascending order
        Arrays.sort(input);

        for (int i = 0; i <input.length ; i++) {
            int a = input[i];
            int j = i+1;
            int k = input.length-1;
            while(j<k){
                int sum = a + input[j] + input[k];
                if(sum==0)
                    return 0;
                else if(sum>0){
                    minSumPositive = Math.min(sum, minSumPositive);
                    k--;
                }else{
                    minSumNegative = Math.max(sum, minSumNegative);
                    j++;
                }
            }
        }
        if(Math.abs(minSumNegative)<minSumPositive)
            return minSumNegative;
        return minSumPositive;
    }

    public static void main(String[] args) {
        int [] input = {-1, 4, -2, 5, 10, -5};
        System.out.println("Minimum Sum with three elements is: " +  findSumClosestToZero(input));
    }
}

//    Given a long integer, find the maximum number that can be formed from the digits.
//
//        Input 1 : 8754365
//        Output 1: 8765543
//
//        Input 2 : -7486346
//        Output 2: -3446678
//
//
//        long findMaxNumber(long input){
//
//        //base case
//        if(input==0)
//        return input;
//
//        //negative handle here
//        boolean isNegative = false;
//        String strInput = input+"";
//
//        if(strCharAt(0)=='-'){
//        isNegative = true;
//        strInput = strInput(1, strInput.length);
//        }
//        List<Integer> list = new ArrayList<>();
//
//        for(int i = 0;i<strInput.length;i++){
//        list.add(Integer.parseInt(strCharAt(i)));
//        }
//
//        //8765
//        //-12341
//        //5555
//        //check if input is already max
//        if(isNegative){
//        int current = list.get(0);
//        boolean alreadyMax = true;
//        for(int i = 1;i<list.size;i++){
//        if(current<=list.get(i)){
//        continue;
//        }else{
//        alreadyMax = false;
//        break;
//        }
//        current = list.get(i);
//        }
//        } else{
//        int current = list.get(0);
//        boolean alreadyMax = true;
//        for(int i = 1;i<list.size;i++){
//        if(current>=list.get(i)){
//        continue;
//        }else{
//        alreadyMax = false;
//        break;
//        }
//        current = list.get(i);
//        }
//        }
//        if(alreadyMax)
//        return input;
//
//
//        if(isNegative){
//        Collections.sort(list);
//        }else{
//        Collections.sort(list, Collections.reverseOrder());
//        }
//
//        Long result = 0L;
//
//        for(int i = 0;i<list.size;i++){
//        result =  result*10;
//        result +=list.get(i);
//        }
//        return result;
//
//        }
