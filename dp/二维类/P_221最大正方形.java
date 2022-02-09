package com.pan.leetcode.dp.二维类;

import java.util.Arrays;

public class P_221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == '0')
                    dp[i][j] = 0;
                else if(i==0 || j==0)
                    dp[i][j] = 1;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret*ret;
    }
}
