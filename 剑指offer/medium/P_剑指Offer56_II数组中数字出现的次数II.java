package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer56_II数组中数字出现的次数II {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
