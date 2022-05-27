package com.pan.leetcode.周赛.第78场双周赛;

public class P_2270分割数组的方案数 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        if(n<=1) return 0;
        int ret = 0;
        long post=0;
        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        for (int i = n-2; i >= 0; i--) {
            post += nums[i+1];
            if(sum[i]>=post)
                ret++;
        }
        return ret;
    }
}
