package com.pan.leetcode.dp.股票交易;

public class P_714买卖股票的最佳时机含手续费 {
    //你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    //返回获得利润的最大值。
    //注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n <= 1) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
