package Published.JavaConcept.Pair.Pair;

import javafx.util.Pair;
import java.util.ArrayList;

public class PairExample {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("apple",1);
        Pair<String, Integer> pair2 = new Pair<>("apple",1);
        Pair<String, Integer> pair3 = new Pair<>("banana",2);
        Pair<String, Integer> pair4 = new Pair<>("pineapple",4);

        ArrayList<Pair<String,Integer>> list = new ArrayList<>();
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);
        list.add(pair4);

        //toString function
        System.out.println("--------toString function--------");
        for(Pair p: list){
            System.out.println(p.toString());
        }

        //equals function
        System.out.println("--------equals function--------");
        System.out.println("pair1 and pair2 are equal: " + pair1.equals(pair2));
        System.out.println("pair1 and pair3 are equal: " + pair1.equals(pair3));
        System.out.println("pair3 and pair4 are equal: " + pair3.equals(pair4));

        //getKey and getValue function
        System.out.println("--------getKey and getValue function--------");
        for (Pair p: list){
            System.out.println("key: " + p.getKey() + " and its value: " + p.getValue());
        }

        //hashCode function
        System.out.println("--------hashCode function--------");
        for (Pair p: list){
            System.out.println("Pair: " + p.toString() + " and hashCode: " + p.hashCode());
        }
        System.out.println(" As you can see that hashcode for pair1 and pair2" +
                " are same since key and values are equal");
    }
}
