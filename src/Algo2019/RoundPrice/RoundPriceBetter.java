package Algo2019.RoundPrice;

import java.util.Arrays;
import java.util.Comparator;

public class RoundPriceBetter {

    public int[] roundUp(double[] prices) {
        int n = prices.length;
        PriceWithDiff[] priceWithDiff = new PriceWithDiff[n];
        double sum = 0.0;
        int floorSum = 0;
        for (int i = 0; i < n; i++) {
            int floor = (int) prices[i];
            int ceil = (int) Math.ceil(prices[i]);
            floorSum += floor;
            sum += prices[i];
            priceWithDiff[i] = new PriceWithDiff(ceil, floor, ceil - prices[i]);
        }

        int target = (int) Math.round(sum);
        int d = target - floorSum;
        Arrays.sort(priceWithDiff, new Comparator<PriceWithDiff>() {
            @Override
            public int compare(PriceWithDiff n1, PriceWithDiff n2) {
                if (n1.diffWithCeil <= n2.diffWithCeil) return -1;
                else return 1;
            }
        });

        int[] res = new int[n];
        int i = 0;
        // pick first d ceil values from array
        for (; i < d; i++) {
            res[i] = priceWithDiff[i].ceilPrice; //ceil
        }
        // Now target will be reached just by taking floor prices
        for (; i < n; i++) {
            res[i] = priceWithDiff[i].floorPrice; //floor
        }
        return res;
    }

    class PriceWithDiff {
        int ceilPrice;
        int floorPrice;
        double diffWithCeil;

        public PriceWithDiff(int ceil, int floor, double c) {
            this.ceilPrice = ceil;
            this.floorPrice = floor;
            this.diffWithCeil = c;
        }
    }

    public static void main(String[] args) {
        double [] prices = {30.9, 2.4, 3.9};
        System.out.println("Prices: " + Arrays.toString(prices));
        RoundPriceBetter r = new RoundPriceBetter();
        System.out.println("Rounded Prices: " + Arrays.toString(r.roundUp(prices)));
    }
}
