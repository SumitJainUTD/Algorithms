package MacLaptop.ArrayProblems.RemoveDuplicates;

/**
 * Created by sjain on 8/12/17.
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String s){
        char[] chrArr = s.toCharArray();
        boolean[] asciiChrSet = new boolean[256];
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<chrArr.length;i++){
            if(asciiChrSet[chrArr[i]]){
                continue;
            }
            asciiChrSet[chrArr[i]] = true;
            stb.append(chrArr[i]);
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        String s = "tutorialhorizon";
        System.out.println(removeDuplicates(s));
    }

}
