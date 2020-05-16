package Algorithm2020;

import java.util.*;

public class SortHashMap {

    public static void sort(Map<String, Integer> employeeMap){

        System.out.println("Given Map: ");
        printMap(employeeMap);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(employeeMap.entrySet());

        //sort in reverse order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        //clear the map
        employeeMap= new LinkedHashMap<>();

        //refill the map
        for (int i = 0; i <list.size(); i++)
            employeeMap.put(list.get(i).getKey(), list.get(i).getValue());

        System.out.println("\nSorted Map: ");
        printMap(employeeMap);
    }

    public static void printMap(Map<String, Integer> employeeMap){
        for(String key:employeeMap.keySet())
            System.out.print(key + " : " + employeeMap.get(key)+ "  ");
        System.out.println();
    }

    public static void main(String[] args) {
        Map<String, Integer> employeeMap = new HashMap<>();
        employeeMap.put("Joe", 1000);
        employeeMap.put("Brad", 1510);
        employeeMap.put("Carl", 2000);
        employeeMap.put("Dow", 500);
        employeeMap.put("Earl", 1200);
        sort(employeeMap);
    }
}
