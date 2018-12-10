package Sep2018;

import java.util.Stack;

/**
 * Created by sumi1 on 9/20/2018.
 */
public class LargestHistogram {

    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack  = new Stack<>();
        int maxArea = 0;
        int i=0;
        for(;i<height.length;i++){
            if(stack.isEmpty()||height[i]>=height[stack.peek()]){
                stack.push(i);
            }else{
                int top = stack.pop();
                int area = 0;
                int hgt = height[top];
                if(stack.isEmpty()){
                    area = hgt*i;
                }else{
                    area = hgt*(i-stack.peek()-1);
                }
                if(maxArea<area)
                    maxArea = area;
                i--;
            }
        }

        //now iterate through rest of the elements in stack
        while(stack.isEmpty()==false){
            int top = stack.pop();
            int hgt = height[top];
            int area = 0;
            if(stack.isEmpty()){
                area = hgt*i;
            }else{
                area = hgt*(i-stack.peek()-1);
            }
            if(maxArea<area)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] height = new int [] {1,2,4};
        System.out.println(new LargestHistogram().largestRectangleArea(height));
    }
}
