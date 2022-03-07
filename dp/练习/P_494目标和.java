package com.pan.leetcode.dp.练习;

public class P_494目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        if(n<1) return 0;
        if(n==1) return Math.abs(nums[0])==Math.abs(target)? 1:0;
        int sum = 0, neg;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum-target < 0 || (sum-target)%2 == 1) return 0;
        neg = (sum-target) / 2;
        int[][] dp = new int[n+1][neg+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1])
                    dp[i][j] +=dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][neg];
    }
}
