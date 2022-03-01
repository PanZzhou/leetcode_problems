package com.pan.leetcode.dp.字符串编辑;

public class P_72编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(m*n == 0)
            return m+n;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
}
