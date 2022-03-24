package com.pan.leetcode.分治法;

public class P_312戳气球 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] stick = new int[len+2];
        int[][] dp = new int[len+2][len+2];
        stick[0] = stick[len+1] = 1;
        for (int i = 1; i < len+1; i++) {
            stick[i] = nums[i-1];
        }
        //类似floyd算法得写法
        //因为i到i+k的数据需要i+k-1...之类的数据，所以就从后往前推
        for (int i = len-1; i >= 0; i--) {
            for (int j = i+2; j <= len+1; j++) {
                for (int k = i+1; k < j; k++) {
                    int sum = stick[i] * stick[k] * stick[j];
                    sum+=dp[i][k]+dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][len+1];
    }
}
