/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * e.g.
 * [3,2,3,1,2] return 1
 */
public class BestTimetoBuyandSellStock {

    /**
     * Prices = [3, 2, 3, 1, 2]
     * Profit = [-1, 1, -2, 1]
     * 求最大profit求profit数组的max subarray sum，但是其实我们并不需要求出profit数组
     * 其实也就是最低价买入，最高价卖出盈利最多
     * @param prices
     *          Prices array
     * @return the maximum profit
     */
    public int solution(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int profit = Integer.MIN_VALUE;
        int minPrice = prices[0];

        for(int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return profit;
    }
}
