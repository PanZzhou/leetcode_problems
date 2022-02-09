package com.pan.leetcode.dp.二维类;

public class P_64最小路径和 {
    public int minPathSum(int[][] grid) {
        int n = grid.length,m=grid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0&&j==0)
                    dp[j]=grid[i][j];
                else if(i==0)
                    dp[j] = dp[j-1]+grid[i][j];
                else if(j==0)
                    dp[j] += grid[i][j];
                else
                    dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];

            }
        }
        return dp[m-1];
    }
}
