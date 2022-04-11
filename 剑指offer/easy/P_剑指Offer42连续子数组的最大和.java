package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer42连续子数组的最大和 {
//    public int maxSubArray(int[] nums) {
//        int ret = Integer.MIN_VALUE, left = -1, right = 0, ans = nums[right];
//        while(left<nums.length-1 || right < nums.length-1){
//            if(left != right && ans > ret)
//                ret = ans;
//            if(right<nums.length-1 && ans >= 0 || left >= right){
//                right++;
//                ans += nums[right];
//            }else{
//                left++;
//                ans -= nums[left];
//            }
//        }
//        return ret;
//    }
    public int maxSubArray(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] > 0)
                nums[i] += nums[i-1];
            if(nums[i] > ret)
                ret = nums[i];
        }
        return ret;
    }
}
