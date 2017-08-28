package Arrays.StockSingleSell;

/**
 * Created by sumi1 on 7/26/2017.
 */
public class StockSingleSellDandC {

    public Result maxProfit(int [] prices, int start, int end){
        if(start>=end){
            return new Result(0,0,0);
        }
        int mid = start +  (end-start)/2;
        Result leftResult = maxProfit(prices,start,mid);
        Result rightResult = maxProfit(prices,mid+1,end);
        int minLeftIndex = getMinIndex(prices, start, mid);
        int maxRightIndex = getMaxIndex(prices, mid, end);
        int centerProfit = prices[maxRightIndex] - prices[minLeftIndex];
        if(centerProfit>leftResult.profit && centerProfit>rightResult.profit){
            return new Result(centerProfit,minLeftIndex,maxRightIndex);
        }else if(leftResult.profit>centerProfit && rightResult.profit>centerProfit){
            return leftResult;
        }else{
            return rightResult;
        }
    }

    public int getMinIndex(int [] A, int i, int j){
        int min = i;
        for (int k = i+1; k <=j ; k++) {
            if(A[k]<A[min])
                min = k;
        }
        return min;
    }
    public int getMaxIndex(int [] A, int i, int j){
        int max = i;
        for (int k = i+1; k <=j ; k++) {
            if(A[k]>A[max])
                max = k;
        }
        return max;
    }

    public static void main(String[] args) {
        StockSingleSellDandC m = new StockSingleSellDandC();
        int [] prices = { 200, 500, 1000, 700, 30, 400, 900, 400, 50};
        int start = 0;
        int end = prices.length-1;
        Result result = m.maxProfit(prices,start,end);
        System.out.println("Maximum Profit(Divide & Conquer): " +result.profit + ", buy date index: " + result.buyDateIndex +
                ", sell date index: " + result.sellDateIndex);
    }
}
class Result{
    int profit=0;
    int buyDateIndex=0;
    int sellDateIndex=0;
    public Result(int profit, int buyDateIndex, int sellDateIndex){
        this.profit = profit;
        this.buyDateIndex = buyDateIndex;
        this.sellDateIndex = sellDateIndex;
    }
}
