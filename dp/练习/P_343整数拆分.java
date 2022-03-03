package com.pan.leetcode.dp.练习;

public class P_343整数拆分 {
    public int integerBreak(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return 1;
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j* dp[i-j]));
            }
        }
        return dp[n];
    }
}
