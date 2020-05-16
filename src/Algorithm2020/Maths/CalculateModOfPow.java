package Algorithm2020.Maths;

public class CalculateModOfPow {

    public static void calculateModOfPow(int x, int y, int z){
        int result = calculate(x, y, z);
        System.out.println("("+x+" ^ "+y+") % "+z+" = "+result);
    }

    public static int calculate(int n, int y, int z){
        if(y==0)
            return 1;

        if(y%2!=0)
            return calculate(n, y/2, z)*calculate(n, y/2, z)*n%z;
        else
            return calculate(n, y/2, z)*calculate(n, y/2, z)%z;
    }

    public static void main(String[] args) {
        int n = 2;
        int pow = 8;
        int z = 7;
        calculateModOfPow(n, pow, z);
    }
}
