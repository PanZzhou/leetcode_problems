package com.pan.leetcode.dp.背包类;

import java.util.Arrays;

public class P_322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);//初始化，标记为不可能达到的数
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
               if(coins[j] <= i)
                   dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }
}
