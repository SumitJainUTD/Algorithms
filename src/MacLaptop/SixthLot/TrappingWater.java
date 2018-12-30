package MacLaptop.SixthLot;

/**
 * Created by sjain on 9/24/18.
 */
public class TrappingWater {
    public static int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int area = 0, leftHeight = height[0], rightHeight = height[height.length - 1];
        while (left < right){
            if (height[left] < height[right]){
                left++;
                // if (leftHeight < height[left]){
                //     leftHeight = height[left];
                // }
                // else{
                //     area += leftHeight - height[left];
                // }
                leftHeight = Math.max(leftHeight, height[left]);
                area += leftHeight - height[left];
            }
            else{
                right--;
                // if (rightHeight < height[right]){
                //     rightHeight = height[right];
                // }
                // else{
                //     area += rightHeight - height[right];
                // }
                rightHeight = Math.max(rightHeight, height[right]);
                area += rightHeight - height[right];
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int height [] =  new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}

