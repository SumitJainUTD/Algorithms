package MacLaptop.SecondLot.DP.RemovesBoxes;

import java.util.HashMap;

/**
 * Created by sjain on 8/24/17.
 */
public class RemovesBoxRecusion {

    public int removeBox(String input) {
        int profit =0;
        //System.out.println(input);
        if (input == null || input.length() == 0) {
            return 0;
        }
        if(input.length()==1){
            return 1;
        }
        int start_index = 0;
        int end_index = 0;

        while (start_index < input.length()) {
            char c = input.charAt(start_index);
            int count = 0;
            while (end_index<input.length() && c == input.charAt(end_index)) {
                end_index++;
                count++;
            }
            //now we have choice to select that chunk or not
            if(end_index>=input.length()){
                profit = Math.max(profit,count*count);
            }else{
                profit = Math.max(profit, removeBox(input.substring(0, start_index) + input.substring(end_index, input.length())) + count * count);
            }
            start_index=end_index;
        }
        return profit;
    }

    public static void main(String[] args) {
        RemovesBoxRecusion r = new RemovesBoxRecusion();
        long startTime  = System.currentTimeMillis();
        String input = "1122";
        System.out.println("Max Profit: " + r.removeBox(input));
        long end  = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-startTime)/1000 + " seconds");
    }
}
