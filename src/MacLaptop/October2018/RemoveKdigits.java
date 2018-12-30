package MacLaptop.October2018;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by sjain on 10/11/18.
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        HashMap<String, String> hm = new HashMap<String, String>();
        TreeSet<Integer> hs = new TreeSet<Integer>();
        return helper(num, k, hm, hs);
    }

    public String helper(String num, int k, HashMap<String, String> hm, TreeSet<Integer> hs){
        if(num.length()==0 || k==0)
            return num;

        if(Integer.parseInt(num)==0)
            return 0+"";

        num = Integer.parseInt(num) +"";

        if(hm.containsKey(num)){
            return hm.get(num);
        }

        for(int i=0;i<num.length();i++){
            String temp = num.substring(0,i) + num.substring(i+1,num.length());
            String res = helper(temp, k-1, hm, hs);
            hm.put(temp, res);
            if(!res.equals("")){
                hs.add(Integer.parseInt(res));
            }else{
                hs.add(0);
            }

        }

        return hs.first()+"";
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKdigits().removeKdigits("9", 1));
    }
}
