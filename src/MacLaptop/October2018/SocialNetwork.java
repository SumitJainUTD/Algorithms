package MacLaptop.October2018;

import java.util.*;

/**
 * Created by sjain on 10/14/18.
 */
public class SocialNetwork {


    public static void solve(int [] input){

        int persons = input[0];

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<Integer, TreeSet<Integer>>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 1; i <input.length ; i++) {
            int grp = input[i];

            if(map.containsKey(grp)){
                TreeSet<Integer> ts = map.get(grp);
                ts.add(i-1);
                map.put(grp, ts);

            }else{
                TreeSet<Integer> ts = new TreeSet<Integer>();
                ts.add(i-1);
                map.put(grp, ts);
            }
        }

        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            int key = it.next();
            int grp = key;
            while(map.get(key).isEmpty()==false){
                for (int i = 0; i <grp ; i++) {
                    TreeSet<Integer> ts = map.get(key);
                    System.out.print(ts.first());
                    ts.remove(ts.first());
                    map.put(key, ts);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {7, 3, 3, 3, 3, 3, 1, 3};
        solve(a);
    }
}
