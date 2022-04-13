package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer56_I数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        int a = 0, b = 0;
        int pos = ret & (-ret);
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&pos) == pos)
                a ^= nums[i];
            else
                b ^= nums[i];
        }
        return new int[]{a, b};
    }
}
