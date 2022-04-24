package com.pan.leetcode.剑指offerII.medium;

public class P_剑指Offer_II_009乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0;
        int left = 0, right = 0, mul = 1;
        while(left<nums.length){
            if(right > left && mul < k)
                ret += right - left;
            if(right == nums.length && mul < k) break;
            if(right < nums.length && (mul < k || left == right))
                mul *= nums[right++];
            else
                mul /= nums[left++];
        }
        return ret;
    }
}
