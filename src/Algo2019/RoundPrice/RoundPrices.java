package Algo2019.RoundPrice;

import java.util.Arrays;

public class RoundPrices {

    void roundNumbers(double [] prices){
        double sum=0;
        for (double n: prices)
            sum +=n;
        int target = (int) Math.round(sum);
        Result result = roundRecursion(prices,target,0);
        System.out.println("Rounded Prices: " + result.value);
    }

    public  Result roundRecursion(double [] prices, int target, int index) {
        if (index == prices.length && target == 0) {
            return new Result(0, "");
        }
        if (index == prices.length && target != 0) {
            return new Result(Integer.MAX_VALUE, "");
        }
        if (index < prices.length && target < 0) {
            return new Result(Integer.MAX_VALUE, "");
        }

        double price = prices[index];
        int ceil = (int) Math.ceil(price);
        int floor = (int) Math.floor(price);
        double ceilDiff = ceil - price;
        double floorDiff = price - floor;

        Result res1 = roundRecursion(prices, target - ceil, index + 1);

        Result res2 = roundRecursion(prices, target - floor, index + 1);

        if (res1.diff != Integer.MAX_VALUE) {
            res1.diff = res1.diff + ceilDiff;
            res1.value = ceil + " " + res1.value ;
        }

        if (res2.diff != Integer.MAX_VALUE) {
            res2.diff = res2.diff + floorDiff;
            res2.value = floor + " " + res2.value ;
        }

        if(res1.diff <res2.diff)
            return res1;
        else
            return res2;
    }

    class Result{
        double diff;
        String value;

        public Result(double diff, String value) {
            this.diff = diff;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        double [] prices = {30.9, 2.4, 3.9};
        System.out.println("Prices: " + Arrays.toString(prices));
        RoundPrices r = new RoundPrices();
        r.roundNumbers(prices);
    }
}
