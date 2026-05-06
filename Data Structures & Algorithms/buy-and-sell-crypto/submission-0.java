class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        int currentProfit = 0;
        if(prices.length == 0) {
            return maxProfit;
        }

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]); //7, 1, 1/5
            currentProfit = prices[i] - min; // 0, 0, 
            maxProfit = Math.max(currentProfit, maxProfit); //0, 0 
        }

        return maxProfit;
    }
}
