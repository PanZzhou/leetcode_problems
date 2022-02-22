package com.pan.leetcode.dp.子序列问题;

public class P_300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0 )
            return 0;
        int ret = 1;
        int[] dp = new int[nums.length + 1];
        dp[ret] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>dp[ret])
                dp[++ret] = nums[i];
            else{
                int low = 1, high = ret, pos=0;
                while(low<=high){
                    int mid = (low+high)>>1;
                    if(dp[mid]<nums[i]){
                        low = mid + 1;
                        pos = mid;
                    }else
                        high = mid-1;
                }
                dp[pos+1] = nums[i];
            }
        }
        return ret;
    }
}
