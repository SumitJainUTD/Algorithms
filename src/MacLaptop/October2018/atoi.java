package MacLaptop.October2018;

/**
 * Created by sjain on 10/13/18.
 */
public class atoi {


    public static int convert(String x){
        int result=0;
        int maxSoFar = 0;
        if(x==null)
            return 0;

        for (int i = 0; i <x.length() ; i++) {
           char temp = x.charAt(i);
            int num = temp-'0';
            if(num>=0 && num <=9)
                result = result*10 + num ;
            else{
                if(result>maxSoFar)
                    maxSoFar = result;
                result = 0;
            }
        }
        Integer.parseInt("1");
        return Math.max(result, maxSoFar);
    }

    public static void main(String[] args) {
        System.out.println(convert("12a3bbbb12344"));
    }
}
