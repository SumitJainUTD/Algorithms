package OtherLaptop.ArrayProblems.FindSingleElement;
public class FindSingleElement {
//http://www.geeksforgeeks.org/find-the-element-that-appears-once/
    public static void find (int [] arrA){
        int singleElement =0;
        for (int i = 0; i <32 ; i++) {
            int y = (1 << i);
            int tempSum = 0;
            for (int j = 0; j <arrA.length ; j++) {
                System.out.println(Integer.toBinaryString(y));
                System.out.println(Integer.toBinaryString(arrA[j]));
                System.out.println("++++++++++++++++++(a[j] & y)  " + (arrA[j] & y));
                if((arrA[j] & y)>=1) //if that particular bit is set for the ith position, add 1 to sum (w.r.t that bit)
                    tempSum = tempSum +1;
                System.out.println("a[j] " + arrA[j] + " tempSum  " + tempSum);
            }
            //if bits are not multiple of 3 then that bit belongs to the element appearing single time
            if((tempSum%3)==1) {
                //System.out.println(tempSum);
                singleElement = singleElement | y;
            }
            System.out.println("*****************************   " + Integer.toBinaryString(singleElement));
        }
        System.out.println(singleElement);
    }

    public static void main(String[] args) {
        int arrA [] = {1, 4, 5, 6, 1, 4, 6, 1, 4, 6};
        find(arrA);
    }
    
}
