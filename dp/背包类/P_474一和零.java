package com.pan.leetcode.dp.背包类;

public class P_474一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length+1][m+1][n+1];
        for (int i = 1; i <= length; i++) {
            int[] num = getNum(strs[i-1]);
            int zeroNum = num[0], oneNum = num[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if(j<zeroNum || k<oneNum)
                        dp[i][j][k] = dp[i-1][j][k];
                    else
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zeroNum][k-oneNum]+1);
                }
            }
        }
        return dp[length][m][n];
    }

    private int[] getNum(String str){
        int[] num = new int[2];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='0') num[0]++;
            else num[1]++;
        }
        return num;
    }
}
