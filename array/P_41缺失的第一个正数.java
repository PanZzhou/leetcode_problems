package com.pan.leetcode.array;

import java.util.Arrays;

public class P_41缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]<=0)
                nums[i] = len + 1;
        }
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i])-1;
            if(index<len && nums[index]>0)
                nums[index] = - nums[index];    //做标记
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0)
                return i+1;
        }
        return len+1;
    }
}
