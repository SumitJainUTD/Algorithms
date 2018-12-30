package MacLaptop.FifthLot;

import java.util.HashMap;

/**
 * Created by sjain on 12/5/17.
 */
public class CoinChange {

    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

    public int change(int [] value, int amount){

        if(amount==0)
            return 0;

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <value.length ; i++) {
            if(amount>=value[i]){
                result = Math.min(result, change(value,amount-value[i])+1);
            }
        }
        return result;
    }

    public int changeDP_TopDown(int [] value, int amount){

        if(amount==0)
            return 0;

        if(map.containsKey(amount))
            return map.get(amount);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <value.length ; i++) {
            if(amount>=value[i]){
                result = Math.min(result, changeDP_TopDown(value,amount-value[i])+1);
            }
        }
        map.put(amount,result);
        return result;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int [] value = {1,2,3};
        int amount = 37;
        long startTime  = System.currentTimeMillis();
        System.out.println(coinChange.change(value,amount));
        long end  = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-startTime)/1000 + " seconds");

        startTime  = System.currentTimeMillis();
        System.out.println(coinChange.changeDP_TopDown(value,amount));
        end  = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-startTime)/1000 + " seconds");

    }
}
