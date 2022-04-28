package com.pan.leetcode.hot100.medium;

public class P_33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1,mid,ret = -1;
        while(left<=right){
            mid = (left+right)>>1;
            if(nums[mid] == target) return mid;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;
            }else if(nums[mid]>=nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else
                    left = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else
                    right = mid -1;
            }
        }
        return ret;
    }
}
