package com.pan.leetcode.dp.背包类;

public class P_416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[target];
    }
}
