package Algo2019;

public class HammingDistance {

    public static int getDistance(int x, int y){

        //first get the XOR of x and y
        int xor = x^y;

        //now count all set bits in it
        int bitCount = 0;
        while(xor>0){
            if((xor&1)==1)
                bitCount++;
            xor >>= 1;
        }
        return bitCount;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        System.out.println("x="+x+", y="+y+"  Hamming distance: " + getDistance(x,y));
        x = 4;
        y = 5;
        System.out.println("x="+x+", y="+y+"  Hamming distance: " + getDistance(x,y));
        x = 7;
        y = 10;
        System.out.println("x="+x+", y="+y+"  Hamming distance: " + getDistance(x,y));
    }
}
