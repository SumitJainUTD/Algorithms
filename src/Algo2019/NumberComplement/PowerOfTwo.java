package Algo2019.NumberComplement;

public class PowerOfTwo {
    public static int findComplement(int num) {
        int sum = 1, power = 1;

        while (sum < num) {
            power *= 2;
            sum += power;
        }

        return sum - num;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("N = " + n + ", Complement: " + findComplement(n));
    }
}

