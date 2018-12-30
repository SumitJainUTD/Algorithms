package MacLaptop.October2018;

import java.util.ArrayList;

/**
 * Created by sjain on 10/21/18.
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <=n ; i++) {
            arrayList.add(i);
        }
        return getPermutationUtil(arrayList, k);
//        return permutate("" , arrayList, k-1);
    }

    public String getPermutationUtil(ArrayList<Integer> list, int k){
        if(list.size()==1)
            return list.get(0)+"";

        String result = "";
        int size = list.size();
        int factorial = getFactorial(size-1);
        int x = k%factorial;
        int index = k/factorial;
        if(x!=0){
            index++;
        }else{
            x = k-factorial*(index-1);
        }
        int digit = list.get(index-1);
        //remove the select digit from array list
        list.remove(Integer.valueOf(digit)); //for nth number the index will be n-1
        result = result + digit + getPermutationUtil(list, x);
        return result;
    }

    public String permutate(String ans, ArrayList<Integer> n, int k) {
        if(n.size() == 0 ) return ans;
        if(n.size() == 1){
            ans += Integer.toString(n.get(0));
            return ans;
        }

        int x =  getFactorial(n.size());
        int y = x / n.size();
        int z;
        if(y != 0) z = k/y;
        else z = 0;
        ans += Integer.toString(n.get(z));
        n.remove(z);
        return permutate(ans,n,k%y);
    }

    public int getFactorial(int n){
        int result = 1;
        for (int i = 1; i <=n ; i++) {
            result *=i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int k =13;
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(n,k));
    }
}
