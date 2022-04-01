package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer21调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            while(low < high && isOdd(nums[low])) low++;
            while(low < high && isDou(nums[high])) high--;
            if(low < high){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }
        return nums;
    }
    private boolean isDou(int num){
        return num%2 == 0;
    }
    private boolean isOdd(int num){
        return num%2 == 1;
    }
}
