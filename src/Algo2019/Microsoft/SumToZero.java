package Algo2019.Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SumToZero {

    public int[] getArray(int N){
        List<Integer> list = new ArrayList<>();
        getArrayUtil(list, 0, 0, N, true);
        System.out.println(Arrays.toString(list.toArray()));
       return list.stream()
               .filter(Objects::nonNull)
               .mapToInt(Integer::intValue)
               .toArray();
    }

    public List<Integer> getArrayUtil(List<Integer> list, int sum, int start, int N, boolean even){
        if(sum==0 && list.size()==N){
            return list;
        }

        if(list.size()>N)
            return null;

        for (int i = start; i <N ; i++) {
            if(i>0){
                int num = i;
                int negNum = num *-1;
                    list.add(new Integer(num));
                    list.add(new Integer(negNum));
                    if(getArrayUtil(list, sum , start + 1, N,!even)!=null)
                        return list;
                    sum = sum + negNum;
                    list.remove(new Integer(num));
                    if(getArrayUtil(list, sum , start + 1, N,!even)!=null)
                        return list;
                    sum = sum - negNum;
                    list.remove(new Integer(negNum));
                    if(getArrayUtil(list, sum , start + 1, N,!even)!=null)
                        return list;

//                num *= -1;
//                list.add(new Integer(num));
//                if(getArrayUtil(list, sum + num, start + 1, N)!=null)
//                    return list;
//                list.remove(new Integer(num));
            }else{
                list.add(0);
                if(getArrayUtil(list, sum , start + 1, N, !even)!=null)
                    return list;
                list.remove(0);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int N = 4;
        SumToZero s = new SumToZero();
        s.getArray(N);
    }
}
