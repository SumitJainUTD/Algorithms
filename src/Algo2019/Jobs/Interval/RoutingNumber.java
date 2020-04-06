package Algo2019.Jobs.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RoutingNumber {

    static class RoutingRange{
        int start;
        int end;
        String bank;

        public RoutingRange(int start, int end, String bank) {
            this.start = start;
            this.end = end;
            this.bank = bank;
        }

        @Override
        public String toString(){
            return "["+this.start+","+this.end+ ", "+ this.bank+"]";
        }
    }

    static TreeMap<Integer, RoutingRange> map = new TreeMap<>();

    public static void findRoutingNumber(int routingNumber) {

        Map.Entry<Integer, RoutingRange> entry = map.floorEntry(routingNumber);
        RoutingRange range = entry.getValue();
        if (range.end >= routingNumber) {
            System.out.println("Given routing number: " +  routingNumber + " belongs to bank " + range.bank);
            return;
        }
        System.out.println("Given routing number: " +  routingNumber + " does not belong to any bank.");
    }

    public static void constructMap(List<RoutingRange> routingRanges){
        for(RoutingRange routingRange: routingRanges){
            map.put(routingRange.start, routingRange);
        }
    }
    public static void main(String[] args) {
        List<RoutingRange> routingRanges = new ArrayList<>();
        routingRanges.add(new RoutingRange(123400, 123500, "BOFA"));
        routingRanges.add(new RoutingRange(123600, 123700, "WELLS FARGO"));
        routingRanges.add(new RoutingRange(12538, 125480, "GCU"));
        routingRanges.add(new RoutingRange(126100, 126500, "CHASE"));
        System.out.println("Input: " + routingRanges);
        constructMap(routingRanges);

        int routingNumber = 123650;
        findRoutingNumber(routingNumber);
        routingNumber = 12540;
        findRoutingNumber(routingNumber);
        routingNumber = 126050;
        findRoutingNumber(routingNumber);
    }
}
