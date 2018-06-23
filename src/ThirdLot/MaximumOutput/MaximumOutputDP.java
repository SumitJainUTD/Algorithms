package ThirdLot.MaximumOutput;

/**
 * Created by sumi1 on 12/29/2017.
 */
public class MaximumOutputDP {

    public int print(int n){
        int [] DP = new int[n+1];
        //base cases
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 3;

        for (int i = 4; i <=n ; i++) {
            //try printing one character and recursively solve for n-1
            int x = DP[i-1] + 1;
            //try select copy paste
            int y = DP[i-3]*2;

            DP[i] = Math.max(x, y);
        }
        //To print the keys sequence

        //1. looking for a particular index, if its previous index is 1 less than index's value
        //then it means the character press has taken place
        //2. looking for a particular index, if its previous index is more than 1 less than index's value
        //then it means the Select, copy and paste keys were pressed in sequence,
        //jump to index = index-3
        String sequence="";
        for (int i = n; i>=1 ;) {
            if(DP[i]-DP[i-1]==1){
                sequence = "char key pressed\n" + sequence;
                i--;
            }else{
                sequence = "Paste\n" + sequence;;
                sequence = "Copy\n" + sequence;;
                sequence = "Select\n" + sequence;;
                i = i-3;
            }
        }
        System.out.println(sequence);
        return DP[n];
    }
    public static void main(String[] args) {
        int n = 8;
        MaximumOutputDP m= new MaximumOutputDP();
        long startTime  = System.currentTimeMillis();
        System.out.println("Maximum Output: " + m.print(n));
        long end  = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-startTime)/1000 + " seconds");
    }
}

