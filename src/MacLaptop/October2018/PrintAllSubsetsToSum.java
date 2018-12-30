package MacLaptop.October2018;

/**
 * Created by sjain on 10/13/18.
 */
public class PrintAllSubsetsToSum {

    public void printSubSets(int N, int curr, String res){
        if(curr==0){
            System.out.println(res);
            return;
        }

        for (int i = 1; i <=N ; i++) {
            if(i<=curr){
                printSubSets(N, curr-i, res+i);
            }
        }
    }

    public static void main(String[] args) {
        new PrintAllSubsetsToSum().printSubSets(4,4,"");
    }
}
