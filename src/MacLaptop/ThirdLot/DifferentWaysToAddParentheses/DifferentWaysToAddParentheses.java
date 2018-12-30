package MacLaptop.ThirdLot.DifferentWaysToAddParentheses;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sjain on 9/16/17.
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses d = new DifferentWaysToAddParentheses();
        String input = "2*4";
        List<Integer> list = d.diffWaysToCompute(input);
        System.out.println(Arrays.toString(list.toArray()));

    }
}