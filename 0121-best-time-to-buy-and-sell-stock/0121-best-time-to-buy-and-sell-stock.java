class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE; 
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buy > prices[i]) { // Update minimum buying price
                buy = prices[i];
            } else { // Calculate and update potential profit
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}