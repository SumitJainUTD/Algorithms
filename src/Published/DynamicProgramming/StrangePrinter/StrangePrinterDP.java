package Published.DynamicProgramming.StrangePrinter;

import java.util.HashMap;

/**
 * Created by sjain on 8/24/17.
 */
public class StrangePrinterDP {

    HashMap<String,Integer> map = new HashMap<String, Integer>();
    public int print(String input) {
        int operations = input.length();
        //base case
        if (input == null || input.length() == 0)
            return 0;
        //check if we have already solved the problem
        if(map.containsKey(input)){
//            return map.get(input);
        }

        int size = input.length();
        if (size == 1)
            return 1;

        int start_index = 0;
        int end_index = 0;
        while (start_index < size) {
            char c = input.charAt(start_index);
            while (end_index < size && c == input.charAt(end_index)) {
                end_index++;
            }
            //if end_index has reached to the end of the string means recursive call is required only for the 0 to start_index
            if (end_index >= size) {
                operations = Math.min(operations, print(input.substring(0, start_index)) + 1);
            } else {
                //else recursive call to rest of the string left
                operations = Math.min(operations, print(input.substring(0, start_index) + input.substring(end_index, size)) + 1);
            }
            //put the start_index a the current end_index for the next iteration
            start_index = end_index;
        }
        //store the result for future
        map.put(input,operations);
        return operations;
    }

    public static void main(String[] args) {
        StrangePrinterDP s = new StrangePrinterDP();
        String input = "aabbccaa";
        long startTime  = System.currentTimeMillis();
        System.out.println("Minimum Operations: " + s.print(input));
        long end  = System.currentTimeMillis();
        System.out.println("Dynamic Programming - Time taken: " + (end-startTime)/1000 + " seconds");
    }
}

