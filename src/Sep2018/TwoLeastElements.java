package Sep2018;

/**
 * Created by sumi1 on 12/2/2018.
 */
public class TwoLeastElements {

    public static void leastTwoElements(int [] arrA){

        if(arrA.length<2){
            System.out.println("Invalid Input, array size is less than 2");
        }

        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;

        for (int i = 0; i <arrA.length ; i++) {
            int current = arrA[i];
            if(first>current){
                second = first;
                first = current;
            }else if(second>current){
                second = current;
            }
        }
        System.out.println("Smallest and 2nd smallest elements are: " + first + " " + second);
    }

    public static void main(String[] args) {
        int [] arrA = new int [] { 6, 8, 9, 2, 1, 10};
        leastTwoElements(arrA);
    }
}