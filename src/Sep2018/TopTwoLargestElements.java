package Sep2018;

/**
 * Created by sumi1 on 11/21/2018.
 */
public class TopTwoLargestElements {

    public static void topTwoElements(int [] arrA){

        if(arrA.length<2){
            System.out.println("Invalid Input, array size is less than 2");
        }

        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;

        for (int i = 0; i <arrA.length ; i++) {
            int current = arrA[i];
            if(first<current){
                second = first;
                first = current;
            }else if(second<current){
                second = current;
            }
        }
        System.out.println("top two elements are: " + first + " " + second);
    }

    public static void main(String[] args) {
        int [] arrA = new int [] { 6, 8, 1, 9, 2, 1, 10};
        topTwoElements(arrA);
    }
}
