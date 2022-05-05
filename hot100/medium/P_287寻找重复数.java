package com.pan.leetcode.hot100.medium;

public class P_287寻找重复数 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
