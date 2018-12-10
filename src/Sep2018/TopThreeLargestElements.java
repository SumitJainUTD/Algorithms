package Sep2018;


/**
 * Created by sumi1 on 12/1/2018.
 */
public class TopThreeLargestElements {

    public static void topThreeElements(int [] arrA){

        if(arrA.length<3){
            System.out.println("Invalid Input, array size is less than 3");
        }

        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i <arrA.length ; i++) {
            int current = arrA[i];
            if(first<current){
                third = second;
                second = first;
                first = current;
            }else if(second<current){
                third = second;
                second = current;
            }else if(third<current){
                third=current;
            }
        }
        System.out.println("top three elements are: " + first + " " + second + " " + third);
    }

    public static void main(String[] args) {
        int [] arrA = new int [] { 6, 8, 1, 9, 2, 1, 10};
        topThreeElements(arrA);
    }
}
