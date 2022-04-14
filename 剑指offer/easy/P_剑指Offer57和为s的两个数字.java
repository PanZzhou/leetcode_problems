package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer57和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low < high){
            int sum = nums[low] + nums[high];
            if(sum == target)
                break;
            else if(sum > target)
                high--;
            else
                low++;
        }
        if(low==high)
            return null;
        return new int[]{nums[low], nums[high]};
    }
}
