class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int buy_price = Integer.MAX_VALUE;

        for(int i =0; i<n; i++)
        {
            if(buy_price < prices[i])
            {
                int profit = prices[i] - buy_price;
                maxProfit = Math.max(profit, maxProfit); 
            }
            else{
                buy_price = prices[i];
            }
        }
        return maxProfit;
    }
}