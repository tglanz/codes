package best_time_to_buy_and_sell_stock;

public class Solution2 implements ISolution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int idx = 0; idx < prices.length; ++idx){
            int price = prices[idx];

            if (price < minPrice){
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}