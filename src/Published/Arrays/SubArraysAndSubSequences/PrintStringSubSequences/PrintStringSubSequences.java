package Published.Arrays.SubArraysAndSubSequences.PrintStringSubSequences;

/**
 * Created by sumi1 on 12/23/2017.
 */
public class PrintStringSubSequences {

    public void printAllSubSequences(String input){
        int [] temp = new int[input.length()];
        int index = 0;
        solve(input, index, temp);
    }

    private void solve(String input, int index, int [] temp){
        if(index==input.length()){
            print(input,temp);
            return;
        }
        //set the current index bit and solve it recursively
        temp[index] = 1;
        solve(input,index+1,temp);
        //unset the current index bit and solve it recursively
        temp[index] = 0;
        solve(input,index+1,temp);
    }

    private void print(String input, int [] temp){
        String result = "";
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]==1)
                result += input.charAt(i)+" ";
        }
        if(result=="")
            result = "{Empty Set}";
        System.out.println(result);
    }

    public static void main(String[] args) {
        String input = "abc";
        new PrintStringSubSequences().printAllSubSequences(input);
    }
}
