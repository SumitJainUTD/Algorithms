package Sep2018;

/**
 * Created by sumi1 on 9/30/2018.
 */
public class LongestPalindromicSubstring {

    public static int palin(String x){
        int len =0;
        if(x==null||(len=x.length())==0)
            return 0;
        if(len==1)
            return 1;
        if(len==2 && x.charAt(0)==x.charAt(1))
            return 2;

        int result = 0;
        int i = 0;
        int j = len-1;
        int y =0;
        while(i<j && x.charAt(i)==x.charAt(j)){
            result += 2;
            i++;
            j--;
        }
        if(i==j){
            result++;
            return result;
        }else if(i<j){
            y = Math.max(palin(x.substring(i, j)), palin(x.substring(i+1, j+1)));
            return y;
        }else{
            return result;
        }
    }

    public static void main(String[] args) {
        String x = "forgeeksskeegfor";
        System.out.println(palin(x));
    }
}
