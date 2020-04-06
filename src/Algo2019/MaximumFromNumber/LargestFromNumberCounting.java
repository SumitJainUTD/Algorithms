package Algo2019.MaximumFromNumber;

public class LargestFromNumberCounting {

    public static void getLargest(int input){

        System.out.println("Given Input: " +  input);

        //negative handle here
        boolean isNegative = false;

        if(input<0){
            isNegative = true;
            input *= -1;
        }

        int [] digitCounts = new int[10];

        while (input>0){
            int n = input%10;
            input = input/10;
            digitCounts[n]++;
        }

        int result = 0;
        if(isNegative){
            for (int i = 0; i <10 ; i++) {
                while(digitCounts[i]>0) {
                    result = result * 10;
                    result +=i;
                    digitCounts[i]--;
                }
            }
        }else{
            for (int i = 9; i >=0 ; i--) {
                while (digitCounts[i]>0) {
                    result = result * 10;
                    result +=i;
                    digitCounts[i]--;
                }
            }
        }

        if(isNegative)
            result *= -1;

        System.out.println("Largest Integer can be formed: " + result);
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        getLargest(34277765);
        getLargest(-342765);
        getLargest(0);
        getLargest(2034);
    }
}
