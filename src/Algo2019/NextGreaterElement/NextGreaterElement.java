package Algo2019.NextGreaterElement;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void find(int [] arrA){
        Stack<Integer> stack = new Stack<>();
        System.out.println("Given array: " + Arrays.toString(arrA));
        int [] result = new int[arrA.length];

        for (int i = arrA.length-1; i >=0 ; i--) {
            int current = arrA[i];
            while(!stack.isEmpty() && stack.peek()<current)
                stack.pop();

            int greater = (stack.isEmpty()==false)?stack.peek():0;
            result[i] = greater;
            stack.push(current);
        }
        System.out.println("Greater Array: " +  Arrays.toString(result));
    }

    public static void main(String[] args) {
        int [] arrA = {6, 2, 4, 3, 5, 10, 6};
        find(arrA);
    }
}
