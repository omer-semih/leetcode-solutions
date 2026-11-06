// LeetCode 121: Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minBuy = prices[0];

        // Single pass: track the cheapest price seen so far and the best profit against it
        for(int i=0;i<prices.length;i++) {
            // Sell today, having bought at the cheapest earlier day
            if(prices[i]-minBuy > maxProfit) {
                maxProfit = prices[i]-minBuy;
            }
            // New cheapest buy for the following days
            if(prices[i] < minBuy) {
                minBuy = prices[i];
            }
        }

        return maxProfit;
    }
}