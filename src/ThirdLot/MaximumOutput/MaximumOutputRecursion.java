package ThirdLot.MaximumOutput;

/**
 * Created by sumi1 on 12/29/2017.
 */
public class MaximumOutputRecursion {

    public int print(int n){
        if(n<3) {
            return n;
        }
        //try printing one character and recursively solve for n-1
        int x = print(n-1) + 1;

        //try select copy paste
        int y = print(n-3)*2;
        return Math.max(x, y);
    }
    public static void main(String[] args) {
        int n = 10;
        MaximumOutputRecursion m= new MaximumOutputRecursion();
        long startTime  = System.currentTimeMillis();
        System.out.println("Maximum output: " +m.print(n));
        long end  = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-startTime)/1000 + " seconds");
    }
}
