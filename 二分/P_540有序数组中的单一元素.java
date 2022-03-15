package com.pan.leetcode.二分;

public class P_540有序数组中的单一元素 {
//    public int singleNonDuplicate(int[] nums) {
//        int n = nums.length;
//        if(n==0) return -1;
//        int ret = nums[0];
//        for (int i = 1; i < n; i++) {
//            ret ^= nums[i];
//        }
//        return ret;
//    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
