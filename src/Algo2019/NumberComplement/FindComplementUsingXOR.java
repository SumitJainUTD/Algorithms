package Algo2019.NumberComplement;

public class FindComplementUsingXOR {
    public static int findComplement_MostSignificantBit(int num) {
        int msb = getMostSignificantBit(num);
        int temp = 1;
        for (int i = 0; i <msb ; i++) {
            temp = temp<<1;
            temp = temp | 1;
        }
        // Now take XOR temp with num -- to get the compliment
        return num^temp;
    }

    static int getMostSignificantBit(int n) {
        // To find the position of the
        // most significant set bit
        int k = (int)(Math.log(n) / Math.log(2));
        return k;
    }

    public static int findComplement_HighestOneBit(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("N = " + n + ", Complement: " + findComplement_MostSignificantBit(n));
        System.out.println("N = " + n + ", Complement: " + findComplement_HighestOneBit(n));
    }
}
