package Published.Maths.Logn;

/**
 * Created by sumi1 on 6/6/2018.
 */
    public class Logn {

        static void computeLogN(int n){
            int result = 0;
            int number = n;
            while(n>0){
                n=n/2;
                if(n>=1)
                    result++;
            }
            System.out.println("Log"+number + " value: " +  result);
        }

        public static void main(String[] args) {
            int n = 64;
            computeLogN(n);
        }
    }
