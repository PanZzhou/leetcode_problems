package com.pan.leetcode.剑指offerII.medium;

import javax.print.DocFlavor;
import java.util.Arrays;

public class P_剑指Offer_II_008和大于等于target的最短子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int ret = nums.length+1;
        int left = 0, right = 0, sum = 0;
        while(left<nums.length){
            if(sum < target || right == left){
                if(right < nums.length)
                    sum += nums[right++];
                else break;
            }else{
                ret = Math.min(ret, right-left);
                sum -= nums[left++];
            }
        }
        if(ret>nums.length)
            return 0;
        return ret;
    }
}
