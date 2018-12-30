package MacLaptop.SecondLot.PrintAllSequences;

/**
 * Created by sjain on 8/30/17.
 */
public class PrintAllSequences {
    String result = "";

    public void print(String x, int length){
        if(length<=0){
            System.out.println(result);
        }else{
            result = result + "";
            print(x, length-1);
            result = result + x.charAt(length-1);
            print(x,length-1);
        }
    }

    public static void main(String[] args) {
        String x = "ab";
        PrintAllSequences p = new PrintAllSequences();
        p.print(x,x.length());
    }
}
