package Published.Bitwise;

/**
 * Created by sjain on 8/29/17.
 */
public class PrintAllBinary {

    public String print(int x){
        if(x>0){
            x--;
            String combine = print(x);
            String [] s = combine.split(";");
//            for (int i = 0; i <s.length ; i++) {
//                System.out.println(s[i]);
//            }
            String left = "0";
            String right = "1";
            String next ="";
            for (int i = 0; i <s.length ; i++) {
                if(next==""){
                    next = left + s[i];
                }else{
                    next = next +";" + left + s[i];
                }

                next = next + ";" +right + s[i];
            }
            return next;
        }
        return "";
    }

    public static void main(String[] args) {
        int x = 3;
        String [] a = new PrintAllBinary().print(x).split(";");

        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
