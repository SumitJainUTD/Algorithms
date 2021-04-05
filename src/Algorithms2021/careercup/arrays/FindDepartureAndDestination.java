package Algorithms2021.careercup.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDepartureAndDestination {

    public static void find(List<List<String>> passes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<passes.size();i++){
            List<String> path = passes.get(i);
            String src = path.get(0);
            String dest = path.get(1);
            int count = map.getOrDefault(src, 0);
            map.put(src, count-1);
            count = map.getOrDefault(dest, 0);
            map.put(dest, count+1);
        }
        String source = null;
        String destination = null;
        for(String key: map.keySet()){
            if(map.get(key)==1)
                destination = key;
            if(map.get(key)==-1)
                source = key;
        }
        System.out.println("Departure: " + source + ", Destination: " + destination);
    }

    public static void main(String[] args) {
        List<List<String>> boardingPass = new ArrayList<>();
        List<String> bp1 = new ArrayList<>();
        bp1.add("Dallas");bp1.add("New York");
        boardingPass.add(bp1);
        List<String> bp2 = new ArrayList<>();
        bp2.add("Dallas");bp2.add("Austin");
        boardingPass.add(bp2);
        List<String> bp3 = new ArrayList<>();
        bp3.add("Austin");bp3.add("Dallas");
        boardingPass.add(bp3);
        List<String> bp4 = new ArrayList<>();
        bp4.add("New York");bp4.add("Seattle");
        boardingPass.add(bp4);
        List<String> bp5 = new ArrayList<>();
        bp5.add("Seattle");bp5.add("Houston");
        boardingPass.add(bp5);
        find(boardingPass);
    }
}
