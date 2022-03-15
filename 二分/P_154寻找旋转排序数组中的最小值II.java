package com.pan.leetcode.二分;

public class P_154寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 0) return -1;
        if(n == 1) return nums[0];
        int low = 0, high = n-1, mid = 0, min = 6000;
        while(low <= high){
            mid = (low + high)>>1;
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low++;
                high--;
            }else if(nums[mid] >= nums[low]){
                if(nums[mid] > nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }else
                high = mid - 1;
            if(nums[mid] < min)
                min = nums[mid];
        }
        return min;
    }
}
