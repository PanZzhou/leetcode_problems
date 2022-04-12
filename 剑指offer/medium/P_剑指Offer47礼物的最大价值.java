package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer47礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j-1], dp[j]) + grid[i][j-1];
            }
        }
        return dp[n];
    }
}
