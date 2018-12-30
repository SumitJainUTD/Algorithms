package MacLaptop.SecondLot.PrintAllSequences;

/**
 * Created by sjain on 8/29/17.
 */
public class PrintAllSubsequences {
    String result = "";

    public void printAll(String x){
        char[] c = x.toCharArray();
        int length = c.length;
        String result = print(c,length);
        String [] temp = result.split(";");
        for (int i = 0; i <temp.length ; i++) {
            System.out.println(temp[i].trim());
        }
    }

    public String print(char[] x, int length){
        if(length>0){
            String result = print(x, length-1);
            String left = String.valueOf(x[length-1]);
            String right = " ";
            String next ="";
            String [] temp = result.split(";");
            for (int i = 0; i <temp.length ; i++) {
                if(next==""){
                    next = left + temp[i];
                }else{
                    next = next +";" + left + temp[i];
                }

                next = next + ";" +right + temp[i];
            }
            return next;
        }
        return "";
    }
    public static void main(String[] args) {
        String x = "abc";
        PrintAllSubsequences p = new PrintAllSubsequences();
        p.printAll(x);
    }
}
