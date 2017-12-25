package ThirdLot.SubArraysAndSubSequences.PrintArraySubSequences;

public class PrintArraySubSequences {

    public void printAllSubSequences(int [] arrInput){
        int [] temp = new int[arrInput.length];
        int index = 0;
        solve(arrInput, index, temp);
    }

    private void solve(int [] arrInput, int index, int [] temp){
        if(index==arrInput.length){
            print(arrInput,temp);
            return;
        }
        //set the current index bit and solve it recursively
        temp[index] = 1;
        solve(arrInput,index+1,temp);
        //unset the current index bit and solve it recursively
        temp[index] = 0;
        solve(arrInput,index+1,temp);
    }

    private void print(int [] arrInput, int [] temp){
        String result = "";
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]==1)
                result += arrInput[i]+" ";
        }
        if(result=="")
            result = "{Empty Set}";
        System.out.println(result);
    }

    public static void main(String[] args) {
        int [] arrInput = {1, 2, 3};
        new PrintArraySubSequences().printAllSubSequences(arrInput);
    }
}
