package Published.Arrays.MaxRepeaingElement;

import java.util.Arrays;

public class MaxRepeatingElement {
    public void MaxRepeatingElementInPlace(int [] arrA){
        int size = arrA.length;
        int maxCount=0;
        int maxIndex=0;
        for (int i = 0; i <size ; i++) {
            //get the index to be updated
            int index = arrA[i]% size;
            arrA[index] = arrA[index] + size;
        }
        System.out.println(Arrays.toString(arrA));
        for (int i = 0; i <size ; i++) {
            if(arrA[i]/size>maxCount){
                maxCount=arrA[i]/size;
                maxIndex=i;
            }
        }
        System.out.println("Element repeating maximum no of times: " + maxIndex + ", maximum count: " + maxCount);
    }
    public static void main(String[] args) {
        int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
        int arr [] = {4, 1, 7, 2, 7, 5, 9, 8, 6, 1, 7, 2, 4, 7};
        MaxRepeatingElement m = new MaxRepeatingElement();
        m.MaxRepeatingElementInPlace(arr);
    }
}
