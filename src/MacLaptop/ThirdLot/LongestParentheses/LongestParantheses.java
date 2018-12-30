package MacLaptop.ThirdLot.LongestParentheses;

/**
 * Created by sjain on 9/9/17.
 */
public class LongestParantheses {

    static int countNumber = 0;
    static int findNumber = 0;

    public int count(String s){
        if(s==null||s.length()==0||s.length()==1)
            return 0;



        int openP=0;
        int closeP=0;
        int valid=0;
        int recurTemp =0;
        boolean recursionDone= false;

        for (int i = 0; i <s.length() ; i++) {
            countNumber++;
            if(s.charAt(i)=='(')
                openP++;
            if(s.charAt(i)==')')
                closeP++;
            //if openP==closeP, means valid
            if(openP==closeP){
                valid = openP+closeP;
            }
            //at any time close P > openP, means invalid
            if(closeP>openP){
                recurTemp = count(s.substring(1));
                recursionDone = true;
                break;
            }
        }
        if(recursionDone==false && openP!=closeP){
            recurTemp = count(s.substring(1));
        }
        return Math.max(recurTemp,valid);
    }

    public int find(String s){
        if(s==null||s.length()==0||s.length()==1)
            return 0;

        int openP=0;
        int closeP=0;
        int valid=0;
        int recurTemp =0;
        int validIndex =0;
        boolean recursionDone= false;

        for (int i = 0; i <s.length() ; i++) {
            findNumber++;
            if(s.charAt(i)=='(')
                openP++;
            if(s.charAt(i)==')')
                closeP++;
            //if openP==closeP, means valid
            if(openP==closeP){
                valid = openP+closeP;
                validIndex = i+1;
            }
            //at any time close P > openP, means invalid
            if(closeP>openP){
                recurTemp = find(s.substring(i+1));
                recursionDone = true;
                break;
            }
        }
        if(recursionDone==false && openP!=closeP){
            recurTemp = find(s.substring(1));
//            recurTemp = find(s.substring(validIndex));
        }
        return Math.max(recurTemp,valid);
    }



    public static void main(String[] args) {
        LongestParantheses p = new LongestParantheses();
        String s = "())())()(";
        System.out.println(p.count(s));
        System.out.println("number of timees recursion: " + countNumber);
        System.out.println("____________________________________________________");
        System.out.println(p.find(s));
        System.out.println("number of timees recursion: " + findNumber);

    }
}
