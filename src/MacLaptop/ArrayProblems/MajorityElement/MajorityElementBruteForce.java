package MacLaptop.ArrayProblems.MajorityElement;

/**
 * Created by sjain on 8/12/17.
 */
public class MajorityElementBruteForce {

    public static void find(int [] arrA){
        boolean found = false;
        for (int i = 0; i <arrA.length ; i++) {
            int x = arrA[i];
            int count = 1;
            for (int j = i+1; j <arrA.length ; j++) {
                if(x==arrA[j])
                    count++;
            }
            if(count>arrA.length/2) {
                System.out.println("Element appearing more than n/2 times: " + x);
                found = true;
            }
        }
        if(!found)
            System.out.println("No element appearing more than n/2 times");
    }

    public static void main(String[] args) {
        int [] arrA = {1,3,5,5,5,5,4,1,5};
        find(arrA);
    }
}
