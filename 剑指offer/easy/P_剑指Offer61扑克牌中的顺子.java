package com.pan.leetcode.剑指offer.easy;

import java.util.Arrays;

public class P_剑指Offer61扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                zeros++;
            else if(i>0 && nums[i-1] == nums[i])
                return false;
            else if(i>0 && nums[i-1]!=0){
                zeros -= nums[i] - nums[i-1] - 1;
                if(nums[i]<min)
                    min = nums[i];
                if(nums[i]>max)
                    max = nums[i];
            }
        }
        if(zeros < 0 || zeros > 0 && !(max+zeros<=13 || min-zeros>=1))
            return false;
        return true;
    }
}
