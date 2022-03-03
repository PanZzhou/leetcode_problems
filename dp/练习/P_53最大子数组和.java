package com.pan.leetcode.dp.练习;

public class P_53最大子数组和 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n  == 0) return 0;
        if(n == 1) return nums[0];
        int ret = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = ret + nums[i];
            ret = Math.max(ret + nums[i], nums[i]);
            max = Math.max(max, ret);
        }
        return max;
    }
}
