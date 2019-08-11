package MacLaptop.October2018;

/**
 * Created by sjain on 10/21/18.
 */
public class RoundPrices {

    public  Result round(double [] prices, int target, int index) {
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

        Result res1 = round(prices, target - ceil, index + 1);

        Result res2 = round(prices, target - floor, index + 1);

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
        double [] prices = new double[]{ 0.70,2.80, 4.90};
        int target =5;
        RoundPrices r = new RoundPrices();
        Result result = r.round(prices,target,0);
        System.out.println(result.value);

    }

}
