package Published.String;

public class GenerateStringsOfNLengthFromKsize {

    int [] arr;

    public GenerateStringsOfNLengthFromKsize(int k){
        arr = new int[k];
    }

    public void generateStrings(int n, int k, int size){
        if(n<1) {
            printArray(arr, size);
            return;
        }
        //now generate all other strings
        for (int i = 0; i <k ; i++) {
            arr[n-1] = i;
            generateStrings(n-1, k, size);
        }
    }

    public void printArray(int [] arr, int size){
        String result = "";
        for (int i = 0; i <size ; i++) {
            result = result + " " + arr[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int  k = 3;
        int n = 2;
        GenerateStringsOfNLengthFromKsize a = new GenerateStringsOfNLengthFromKsize(k);
        a.generateStrings(n, k, n);
    }
}
