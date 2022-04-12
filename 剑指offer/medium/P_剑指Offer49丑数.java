package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer49丑数 {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int mulTwo = dp[a]*2, mulThree = dp[b]*3, mulFive = dp[c]*5;
            dp[i] = Math.min(mulTwo, Math.min(mulThree, mulFive));
            if(dp[i] == mulTwo) a++;
            if(dp[i] == mulThree) b++;
            if(dp[i] == mulFive) c++;
        }
        return dp[n-1];
    }
}
