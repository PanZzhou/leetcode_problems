package com.pan.leetcode.dp.练习;

public class P_583两个字符串的删除操作 {
    //类似最长公共子序列
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if(n == 0 || m == 0) return m+n;
        int dp[][] = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return m + n - 2*dp[n][m];
    }
}
