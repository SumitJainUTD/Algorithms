package Published.Number;

import java.util.HashMap;

public class IntegerReplacement {

    public int integerReplacement(int n){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return integerReplacementUtil(n, map);
    }

    public int integerReplacementUtil(int n, HashMap<Integer, Integer> map) {
        if(n==1)
            return 0;
        if(map.containsKey(n))
            return map.get(n);

        int steps =-1;
        if(n%2==0){
            steps = 1 + integerReplacementUtil(n/2, map);
        }else {
            int opt1 = 2 + integerReplacementUtil(1 + (n - 1) / 2, map);
            int opt2 = 1 + integerReplacementUtil(n - 1, map);

            steps = Math.min(opt1, opt2);
        }
        map.put(n, steps);
        return steps;
    }

    public static void main(String[] args) {
        IntegerReplacement i = new IntegerReplacement();
        int N = 11;
        System.out.println("N = " + N + ", Minimum replacements required : " + i.integerReplacement(N));
    }
}
