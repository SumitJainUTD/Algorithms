package Sep2018;

/**
 * Created by sumi1 on 9/30/2018.
 */
public class LongestCommonSubString {

    public static int common(String A, String B){
        if(A==null||B==null||A.length()==0||B.length()==0)
            return 0;

        int max =0;
        int i = A.length()-1;
        int j = B.length()-1;
        int curr =0;
        while(i>=0 && j>=0 && A.charAt(i)==B.charAt(j)){
            curr++;
            i--;
            j--;
        }
        if(max<curr)
            max = curr;

        //solve for rest of the string
        int t = 0;
        if(i>=0 && j>=0) {
            t = Math.max(common(A.substring(0, i), B.substring(0, j+1)),
                    common(A.substring(0, i+1), B.substring(0, j)));
        }

        return Math.max(max,t);
    }

    public static void main(String[] args) {
        String A ="ZMBBBABCDR";
        String B = "ZBBBXABCDG";
        System.out.println(common(A,B));
    }
}
