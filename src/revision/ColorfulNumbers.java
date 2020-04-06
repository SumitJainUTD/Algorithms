package revision;

import java.util.Arrays;
import java.util.Hashtable;

public class ColorfulNumbers {

    Hashtable<Integer, Integer> ht = new Hashtable<>();
    boolean [] used; // for creating powerset, every digit, either
    //it will be selected or not
    public int [] getdigits(int Number){
        int length = String.valueOf(Number).length();
        int A [] = new int [length];
        int counter = length-1; //start filling from the end
        while(Number>0){
            int x = Number%10;
            Number = Number/10;
            A[counter]=x;
            counter--;
        }
        return A;
    }
    public boolean getColorFul(int Number){
        ht.clear();
        int [] A = getdigits(Number);
        used = new boolean[A.length];
        return powerSet(A, used, 0);
    }
    public boolean powerSet(int [] A, boolean [] used, int x){
        if(x==used.length-1){
            used[x] = false;
            boolean b = insertInHash(A, used);
            if(b){
                used[x] = true;
                return insertInHash(A, used);
            }else{
                return false;
            }
        }
        used[x] = false;
        boolean p = powerSet(A, used, x+1);
        used[x] = true;
        return p & powerSet(A, used, x+1);
    }
    public boolean insertInHash(int [] A, boolean [] used){
        int product=0;
        for(int i = 0;i<used.length;i++){
            if(used[i]){
                if(product==0){
                    product =A[i];
                }
                else{
                    product*=A[i];
                }

            }
        }
        if(ht.containsKey(product)){
            return false;
        }else{
            ht.put(product, 1);
            return true;
        }

    }
    public static void main(String[] args) {
        ColorfulNumbers c = new ColorfulNumbers();
        System.out.println(" 326 Colorful?? " + c.getColorFul(326));
        System.out.println(" 3245 Colorful?? " + c.getColorFul(3245));

    }

}
