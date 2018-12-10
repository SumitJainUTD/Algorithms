package Sep2018;

/**
 * Created by sumi1 on 9/23/2018.
 */
//https://leetcode.com/problems/count-numbers-with-unique-digits/description/
public class UniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        int result=0;
        for(int i=0;i<=n;i++){
            if(i==0)
                result = result +1;
            else if(i==1)
                result = result +10;
            else{
                int temp=1;
                int digits = 9;
                for(int j=0;j<i;j++){
                    if(j==0||j==1){
                        temp *= digits;
                    }else {
                        digits--;
                        temp *= digits;
                    }
                }
                result = result + temp;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }

}
