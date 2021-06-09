package com.pan.leetcode.array;

import java.util.Arrays;

public class P_31下一个排列 {
    public void nextPermutation(int[] nums) {
        int low = nums.length - 2;
        while (low >= 0 && nums[low] >= nums[low + 1]) low--;
        if(low>=0){
            int high = nums.length - 1;
            while(high>=0 && nums[high]<=nums[low]) high--;
            swap(nums, low, high);
        }
        reverse(nums, low+1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i){
        int low = i, high = nums.length - 1;
        while(low<high){
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}
