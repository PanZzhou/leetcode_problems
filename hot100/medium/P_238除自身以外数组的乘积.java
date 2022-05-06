package com.pan.leetcode.hot100.medium;

public class P_238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[]{};
        int[] ret = new int[nums.length];
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i-1]*nums[i-1];
        }
        int pre = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            pre *= nums[i+1];
            ret[i] *= pre;
        }
        return ret;
    }
}
