package com.pan.leetcode.hot100.medium;

public class P_152乘积最大子数组 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int min = nums[0], max = nums[0], ret = nums[0],new_max, new_min;
        for (int i = 1; i < nums.length; i++) {
            new_max = max*nums[i];
            new_min = min*nums[i];
            max = Math.max(new_max, Math.max(new_min, nums[i]));
            min = Math.min(new_max, Math.min(new_min, nums[i]));
            ret = Math.max(max, ret);
        }
        return ret;
    }
}
