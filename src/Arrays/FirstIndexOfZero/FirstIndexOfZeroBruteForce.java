package Arrays.FirstIndexOfZero;

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
        //if you have reached here , means 0 is not present
        System.out.println("Array does not have a 0");
    }

    public static void main(String[] args) {
        int [] a = {1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0};
        find(a);
    }
}
