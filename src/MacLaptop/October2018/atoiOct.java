package MacLaptop.October2018;

/**
 * Created by sjain on 10/14/18.
 */
public class atoiOct {

    public static int convert(String x){

        if(x==null || x.length()==0)
            return 0;

        int output=0;
        for (int i = 0; i <x.length() ; i++) {
            int c = x.charAt(i)-'0';
            if(c>=0 && c<=7){
               output = output*8 + c;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String x = "0123";
        System.out.println(convert(x));
    }
}
