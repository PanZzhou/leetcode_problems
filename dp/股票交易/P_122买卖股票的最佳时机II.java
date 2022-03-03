package com.pan.leetcode.dp.股票交易;

public class P_122买卖股票的最佳时机II {
    //在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
    //返回 你能获得的 最大 利润 。
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        int dp[][] = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }
        return dp[n-1][1];
    }
}
