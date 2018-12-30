package Published.Arrays.CheckDuplicates;

import java.util.HashMap;

public class CheckDuplicatesUsingHashMap {

    public void hasDuplicatesUsingMap(int [] arrA){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <arrA.length ; i++) {
            if(map.containsKey(arrA[i])){
                System.out.println("Array has duplicates : " + Math.abs(arrA[i]));
            }else{
                map.put(arrA[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        int a [] = {1, 6, 5, 2, 3, 3, 2};
        new CheckDuplicatesUsingHashMap().hasDuplicatesUsingMap(a);
    }

}
