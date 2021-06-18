package com.pan.leetcode.剑指offer;

public class P_剑指Offer03数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                nums[i]=nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(index==nums.length){
                index=0;
            }
            if(nums[index]>0)
                nums[index] = -nums[index];
            else
                return index;
        }
        return -1;
    }
}
