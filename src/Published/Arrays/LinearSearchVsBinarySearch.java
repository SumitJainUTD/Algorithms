package Published.Arrays;


public class LinearSearchVsBinarySearch {

    static void linearSearch(int [] input, int x){

        System.out.print("Linear Search.....");
        for (int i = 0; i <input.length ; i++) {
            if(x==input[i]) {
                System.out.println("Element " + x + " is found at index: " + i);
                return;
            }
        }
        //if here means x is not found
        System.out.println("Element " + x + " is not found in array");
    }

    static void binarySearch(int [] input, int x){

        System.out.print("Binary Search.....");
        int low = 0;
        int high = input.length-1;
        int result = binarySearchUtil(input, low, high, x);
        if(result>0){
            System.out.println("Element " + x + " is found in array at index: " + result);
        }else{
            System.out.println("Element " + x + " is not found in array");
        }
    }
    static int binarySearchUtil(int [] input, int low,int high, int number){

        if(low>high){
            return -1;
        }
        int mid = low + ((high - low) / 2);

        if(input[mid]==number)
            return mid;
        else if (input[mid]>number){
            return binarySearchUtil(input, low,mid-1,number);
        }
        else {
            return binarySearchUtil(input, mid+1,high,number);
        }
    }

    public static void main(String[] args) {
        int input [] = {2, 4, 5, 8, 10, 14, 18, 19, 20, 40};
        int x = 14;
        linearSearch(input, x);
        binarySearch(input, x);
        linearSearch(input, 21);
        binarySearch(input, 21);
    }
}
