package Arrays.StockSingleSell;

/**
 * Created by sumi1 on 7/26/2017.
 */
public class StockSingleSellBruteForce {

    public static void maxProfit(int [] prices){
        int profit = -1;
        int buyDateIndex = prices[0];
        int sellDateIndex = prices[0];
        for (int i = 0; i <prices.length ; i++) {
            for (int j = i; j <prices.length ; j++) {
                if(prices[j]>prices[i] && (prices[j]-prices[i]>profit)) {
                    profit = prices[j] - prices[i];
                    buyDateIndex = i;
                    sellDateIndex = j;
                }
            }
        }
        System.out.println("Maximum Profit: " + profit + ", buy date index: " + buyDateIndex +
                ", sell date index: " + sellDateIndex);
    }

    public static void main(String[] args) {
        int [] prices = { 200, 500, 1000, 700, 30, 400, 900, 400, 50};
        maxProfit(prices);
    }
}
