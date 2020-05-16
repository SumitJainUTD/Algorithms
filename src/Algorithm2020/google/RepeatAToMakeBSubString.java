package Algorithm2020.google;

public class RepeatAToMakeBSubString {

    public static int solve(String A, String B){

        System.out.println("String A: "+ A + ", B: " + B);

        int count = 0;
        StringBuffer repeatedA = new StringBuffer(A);
        while(repeatedA.length()<B.length()){
            repeatedA.append(A);
            count++;
        }

        //now check if B is already a substring of A
        if(repeatedA.toString().contains(B))
            return count;

        //append one last time
        repeatedA.append(A);
        count++;
        //now check if B is already a substring of A
        if(repeatedA.toString().contains(B))
            return count;
        else
            return -1;
    }

    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
        System.out.println("Minimum repetition of A to make B as substring: " + solve(A, B));
        A = "abcde";
        B = "cdeabcdeabf";
        System.out.println("Minimum repetition of A to make B as substring: " + solve(A, B));
    }
}
