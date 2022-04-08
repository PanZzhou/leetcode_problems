package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer39数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int candidate = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if(num == 0){
                num = 1;
                candidate = nums[i];
            }else{
                if(nums[i] == candidate)
                    num++;
                else
                    num--;
            }
        }
        return candidate;
    }
}
