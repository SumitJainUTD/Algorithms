package Sep2018;

import java.util.*;

/**
 * Created by sumi1 on 9/23/2018.
 */
public class RemoveMinimumParenthesis {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(isWellFormed(s)){
            result.add(s);
            return result;
        }
        getAnswer(s, result);
        return result;
    }

    public boolean getAnswer(String s, List<String> result){
        int i=1;
        boolean found = false;
        //i represents the no of changes will be made in the string
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(' || s.charAt(j)==')'){
                String temp ="";
                if(j==0)
                    temp = s.substring(j+1,s.length());
                else if(j==s.length()-1)
                    temp = s.substring(0,j);
                else
                    temp = s.substring(0,j) + s.substring(j+1,s.length());

                if(isWellFormed(temp)){
                    if(!result.contains(temp)){
                        result.add(temp);
                    }
                    found = true;
                }
            }
        }
        if(found)
            return true;
        else{
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='(' || s.charAt(j)==')'){
                    String temp ="";
                    if(j==0)
                        temp = s.substring(j+1,s.length());
                    else if(j==s.length()-1)
                        temp = s.substring(0,j);
                    else
                        temp = s.substring(0,j) + s.substring(j+1,s.length());


                    getAnswer(temp, result);
                    if(result.size()>0){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public Boolean isWellFormed(String strParentheses) {
        if (strParentheses == null) {
            return true;
        }
        int openParenCounter = 0;
        int closeParenCounter = 0;
        for (int i = 0; i < strParentheses.length(); i++) {
            char x = strParentheses.charAt(i);
            if (x == '(')
                openParenCounter++;
            else if (x == ')')
                closeParenCounter++;

            if (closeParenCounter > openParenCounter) {
                return false;
            }
        }
        if (openParenCounter == closeParenCounter)
            return true;
        else
            return false;

    }

    public List<String> removeInvalid(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isWellFormed(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RemoveMinimumParenthesis r = new RemoveMinimumParenthesis();
        String input = "())(";
        List<String> result = r.removeInvalidParentheses(input);
        System.out.println(Arrays.toString(result.toArray()));
        List<String> result1 = r.removeInvalid(input);
        System.out.println(Arrays.toString(result1.toArray()));
    }
}
