package com.pan.leetcode.剑指offerII.easy;

public class P_剑指Offer_II_012左右两边子数组的和相等 {
    public int pivotIndex(int[] nums) {
        int all = 0,cur = 0;
        for (int num : nums) {
            all += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if(all-nums[i] == cur * 2) return i;
            cur += nums[i];
        }
        return -1;
    }
}
