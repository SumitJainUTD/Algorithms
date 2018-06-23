package ThirdLot.MISC;

/**
 * Created by sumi1 on 5/31/2018.
 */
public class PrintNumbersWithOutLoop {

    static void printNumbers(int number){
        if(number<=0)
            return;
        //else make a recursive call
        printNumbers(number-1);
        //print number in tail recursive
        System.out.print(number + " ");
    }

    public static void main(String[] args) {
        int n = 20;
        printNumbers(n);
    }
}
