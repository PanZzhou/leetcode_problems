package com.pan.leetcode.dp.股票交易;

public class P_123买卖股票的最佳时机III {
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        int[][] buy = new int[n][3];
        int[][] sell = new int[n][3];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i < 3; i++) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i-1][0], sell[i-1][0] - prices[i]);
            for (int j = 1; j < 3; j++) {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j-1] + prices[i]);
                ret = Math.max(ret, sell[i][j]);
            }
        }
        return ret;
    }
}
