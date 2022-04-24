package com.pan.leetcode.剑指offerII.medium;

public class P_剑指Offer_II_004只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int a = 0, b=0;
        for (int i = 0; i < nums.length; i++) {
            a = a^nums[i]&(~b);
            b = b^nums[i]&(~a);
        }
        return a;
    }
}
