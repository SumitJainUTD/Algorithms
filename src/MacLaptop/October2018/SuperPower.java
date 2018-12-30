package MacLaptop.October2018;

/**
 * Created by sjain on 10/20/18.
 */
public class SuperPower {
    public int superPow(int a, int[] b) {
        return superPowerSub(a, b, b.length-1);
    }

    public int superPowerSub(int a, int[] b, int index) {
        if (index == 0)
            return power(a, b[index]) % 1337;
        int pre = superPowerSub(a, b, index-1);
        return (power(pre, 10) * power(a, b[index])) % 1337;
    }

    public int power(int a, int n){
        if(n==0)
            return 1;
        if(n==1)
            return a%1337;

        int x = power(a, n/2);
        if(n%2==0)
            return (x*x)%1337;
        else
            return (x*x*a)%1337;
    }

    public static void main(String[] args) {
        SuperPower s = new SuperPower();
        System.out.println(s. superPow(2, new int [] {1,6}));
    }
}
