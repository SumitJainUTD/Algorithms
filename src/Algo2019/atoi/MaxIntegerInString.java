package Algo2019.atoi;

/**
 * Created by sjain on 10/13/18.
 */
public class MaxIntegerInString {

    public int find(String x){

        System.out.println("Input: " + x);
        int current_no=0;
        int max_so_far = 0;
        if(x==null)
            return 0;

        for (int i = 0; i <x.length() ; i++) {
           char temp = x.charAt(i);
            int num = temp-'0';
            if(num>=0 && num <=9){
                if (current_no >  Integer.MAX_VALUE / 10 || (current_no == Integer.MAX_VALUE / 10) && num>7) {
                    max_so_far =  Integer.MAX_VALUE;
                    break;
                }
                current_no = current_no*10 + num ;
            }
            else{
                if(current_no>max_so_far)
                    max_so_far = current_no;
                current_no = 0;
            }
        }
        return Math.max(current_no, max_so_far);
    }

    public static void main(String[] args) {
        MaxIntegerInString a = new MaxIntegerInString();
        String input = "abcd 45, 54 and 50 are the numbers";
        System.out.println("Maximum Number- " + a.find(input));
        input = "aabb123ccdefgh54319hij";
        System.out.println("Maximum Number- " + a.find(input));
        input = "213123123and544455523412423423424234234234";
        System.out.println("Maximum Number- " + a.find(input));
        input = "abcd  cdtr";
        System.out.println("Maximum Number- " + a.find(input));
    }
}
