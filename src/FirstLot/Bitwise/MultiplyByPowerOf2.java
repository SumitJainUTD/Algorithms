package FirstLot.Bitwise;
//Not in TH
/**
 * Created by sumi1 on 7/11/2017.
 */
public class MultiplyByPowerOf2 {
//    Left shift the number n by k.
    public static void multiply(int n, int k){
        System.out.print("Number " + n + " Multiplied by 2^" + k +" is: ");
        System.out.println(n<<k);
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 4;
        multiply(n,k);
    }
}
