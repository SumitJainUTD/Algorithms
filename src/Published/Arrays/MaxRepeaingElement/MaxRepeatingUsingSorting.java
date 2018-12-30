package Published.Arrays.MaxRepeaingElement;

import java.util.Arrays;

public class MaxRepeatingUsingSorting {
    public void maxRepeatingElementUsingSorting(int [] arrA){
        if(arrA.length<1){
            System.out.println("Inavlid Array");
            return;
        }
        Arrays.sort(arrA);
        int count=1;
        int maxCount=1;
        int currentElement = arrA[0];
        int maxCountElement =arrA[0];
        for (int i = 1; i <arrA.length ; i++) {
            if(currentElement==arrA[i]){
                count++;
            }else{
                if(count>maxCount){
                    maxCount = count;
                    maxCountElement = currentElement;
                }
                currentElement = arrA[i];
                count = 1;
            }
        }
        System.out.println("Element repeating maximum no of times: " + maxCountElement + ", maximum count: " + maxCount);
    }
    public static void main(String[] args) {
        int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
        MaxRepeatingUsingSorting m = new MaxRepeatingUsingSorting();
        m.maxRepeatingElementUsingSorting(arrA);
    }
}
