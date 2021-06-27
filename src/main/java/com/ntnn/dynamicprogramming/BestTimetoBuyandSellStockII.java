package com.ntnn.dynamicprogramming;

public class BestTimetoBuyandSellStockII {
    // find sum max value
    public int maxProfit(int[] prices) {
        if(isCheckArrayIncreased(prices)) {
            return prices[prices.length-1] - prices[0];
        }
        if(isCheckArrayDecreased(prices)) {
            return 0;
        }
        int sum = 0;
        for(int i=0; i<prices.length-1;i++) {
            if(prices[i] < prices[i+1]) {
                sum += prices[i+1] - prices[i];
            }
        }
        return sum;
    }

    // find profit value of max and min value
    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else if (prices[i] > min) max = Math.max(prices[i] - min, max);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private boolean isCheckArrayIncreased(int[] prices) {
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i] > prices[i+1]) return false;
        }
        return true;
    }

    private boolean isCheckArrayDecreased(int[] prices) {
        int count = 0;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i] < prices[i+1]) return false;
        }
        return true;
    }
}
