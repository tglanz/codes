package best_time_to_buy_and_sell_stock;

// naive approach
public class Solution1 implements ISolution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int buydex = 0; buydex < prices.length - 1; ++buydex){
            for (int selldex = buydex + 1; selldex < prices.length; ++selldex){
                int profit = prices[selldex] - prices[buydex];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}