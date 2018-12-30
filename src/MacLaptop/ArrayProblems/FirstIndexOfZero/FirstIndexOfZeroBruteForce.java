package MacLaptop.ArrayProblems.FirstIndexOfZero;

/**
 * Created by sjain on 8/12/17.
 */
public class FirstIndexOfZeroBruteForce {

    public static void find(int [] a){
        for (int i = 0; i <a.length ; i++) {
            if(a[i]==0){
                System.out.println("First Index from where 0 starts: " + i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        find(a);
    }
}
