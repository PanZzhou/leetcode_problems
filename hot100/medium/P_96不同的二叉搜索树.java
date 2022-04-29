package com.pan.leetcode.hot100.medium;

public class P_96不同的二叉搜索树 {
    public int numTrees(int n) {
        if(n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int low = 0, high = i-1,cnt = 0;
            while(low<high){
                cnt += dp[low]*dp[high]*2;
                low++;
                high--;
            }
            if(low == high)
                cnt += dp[low]*dp[low];
            dp[i] = cnt;
        }
        return dp[n];
    }
}
