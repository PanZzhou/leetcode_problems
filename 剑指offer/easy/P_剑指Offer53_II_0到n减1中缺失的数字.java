package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer53_II_0到n减1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length-1, mid, ret = -1;
        while (i<=j){
            mid = (i+j)>>1;
            if(mid != nums[mid]){
                ret = mid;
                j = mid - 1;
            }else
                i = mid + 1;
        }
        if(i >= nums.length)
            ret = i;
        return ret;
    }
}
