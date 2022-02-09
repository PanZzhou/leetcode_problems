package com.pan.leetcode.dp.一维类;

import java.util.Arrays;

public class P_413等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2])
                dp[i] = dp[i-1]+1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += dp[i];
        }
        return res;
    }
}
