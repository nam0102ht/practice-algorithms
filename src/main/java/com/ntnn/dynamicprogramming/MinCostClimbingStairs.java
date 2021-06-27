package com.ntnn.dynamicprogramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int dp1 = 0, dp2 = 0;
        int n = cost.length;
        // traverse till N-th stair
        for (int i = 0; i < n; i++)
        {
            int dp0 = cost[i] +
                    Math.min(dp1, dp2);

            // update the last
            // two stairs value
            dp2 = dp1;
            dp1 = dp0;
        }
        return Math.min(dp1, dp2);
    }
}
