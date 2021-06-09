package com.pan.leetcode.double_pointer;

public class P_34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binary(nums, target, true);
        int rightIndex = binary(nums, target, false);
        return new int[]{leftIndex,rightIndex};
    }

    private int binary(int[] nums, int target, boolean lower){
        int low = 0, high = nums.length - 1,mid,ans=-1;
        while(low<=high){
            mid = (low+high)>>1;
            if(nums[mid]>target || (lower && nums[mid]==target)){
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
                ans = low;
            }
        }
        if(lower)
            return ans>=0&&ans<nums.length&&nums[ans]==target?ans:-1;
        else
            return ans>0&&ans<=nums.length&&nums[ans-1]==target?ans-1:-1;
    }
}
