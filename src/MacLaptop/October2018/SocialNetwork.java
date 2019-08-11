package MacLaptop.October2018;

import java.util.*;

public class SocialNetwork {

    public static void formGroups(int N, int [] input){

        int persons = N;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i <input.length ; i++) {
            int grp = input[i];

            if(map.containsKey(grp)){
                ArrayList<Integer> list = map.get(grp);
                list.add(i);
                map.put(grp, list);

            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(grp, list);
            }
        }

        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        int person = 0;
        while(it.hasNext()){
            int key = it.next();
            while(map.get(key).isEmpty()==false){
                int grp = key;
                System.out.print("Group size: " + grp + ", Persons: ");
                for (int i = 0; i <grp ; i++) {
                    ArrayList<Integer> list = map.get(key);
                    if(list.size()>0) {
                        int x = list.remove(0);
                        System.out.print(x + " ");
                        map.put(key, list);
                    } else if(person<persons){
                        key = it.next();
                        i--;
                    } else{
                        break;
                    }
                    person++;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int N = 7;
        int [] a = {3, 3, 1, 3, 2, 3};
        formGroups(N, a);
        System.out.println("______________________________________________");
        N = 9;
        int [] b = {3, 2, 3, 3, 2, 2, 3, 2, 6};
        formGroups(N, b);
    }
}
