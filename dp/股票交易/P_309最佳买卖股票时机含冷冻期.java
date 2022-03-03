package com.pan.leetcode.dp.股票交易;

public class P_309最佳买卖股票时机含冷冻期 {
    //设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        int[][] dp = new int[n][3];
        //dp[i][0]表示持有股票
//        dp[i][1]表示不持有股票并且处于冷冻
//        dp[i][2]表示不持有股票并且不处于冷冻期
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
