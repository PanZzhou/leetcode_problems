package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer53_I在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left = binary(nums, target, true);
        int right = binary(nums, target, false);
        if(left == -1 || right == -1 || left>right) return 0;
        return right - left + 1;
    }
    private int binary(int[] nums, int target, boolean lower){
        int low = 0, high = nums.length - 1, mid = 0, ret = -1;
        while(low <= high){//在快排里通常是low<high
            mid = (low+high)>>1;
            if(lower){
                if(nums[mid]>=target){
                    ret = mid;//利用ret记录不小于target的下标
                    high = mid - 1;
                }else
                    low = mid + 1;
            }else{
                if(nums[mid]<=target){
                    ret = mid;//利用ret记录不大于target的下标
                    low = mid + 1;
                }else
                    high = mid - 1;
            }
        }
        return ret;
    }
}
