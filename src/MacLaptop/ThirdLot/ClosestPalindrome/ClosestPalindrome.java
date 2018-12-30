package MacLaptop.ThirdLot.ClosestPalindrome;

/**
 * Created by sjain on 9/10/17.
 */
public class ClosestPalindrome {

    private String convert(String input) {

        if(input.length()==0||input.length()==1){
            return input;
        }
        int start = 0;
        int end = input.length();
        int i = start;
        int j = end-1;
        while(i<=j){
            int left = Integer.parseInt(String.valueOf(input.charAt(i)));
            int right = Integer.parseInt(String.valueOf(input.charAt(j)));
            if(left>right){
                //update the left one
                input = input.substring(start,i) + right + input.substring(i+1,end);
            }else if(right>left && j<end) {
                input = input.substring(start, j) + left + input.substring(j + 1, end);
            }else if(right>left) {
                input = input.substring(start, j) + left;
            }
            i++;
            j--;
        }
        return input;
    }

    public static void main(String[] args) {
        ClosestPalindrome c = new ClosestPalindrome();
        String input = "91846533";
        System.out.println(c.convert(input));

    }
}
