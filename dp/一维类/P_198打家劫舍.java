package com.pan.leetcode.dp.一维类;

public class P_198打家劫舍 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int DP_1 = nums[0], DP_2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = DP_1;
            DP_1 = DP_2;
            DP_2 = Math.max(nums[i]+temp, DP_1);
        }
        return DP_2;
    }
}
