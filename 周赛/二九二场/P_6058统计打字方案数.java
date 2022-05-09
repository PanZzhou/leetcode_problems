package com.pan.leetcode.周赛.二九二场;

public class P_6058统计打字方案数 {
    public int countTexts(String pressedKeys) {
        //7和9有四种
        int n = pressedKeys.length();
        if(n<2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char cur = pressedKeys.charAt(i-1);
            dp[i] = (dp[i] + dp[i-1])%(1000000000 + 7);
            if(cur == pressedKeys.charAt(i-2)){
                dp[i] = (dp[i] + dp[i-2])%(1000000000 + 7);
                if(i>=3 && pressedKeys.charAt(i-3) == cur){
                    dp[i] = (dp[i] + dp[i-3])%(1000000000 + 7);
                    if(i>=4 && (cur == '7' || cur == '9') &&pressedKeys.charAt(i-4) == cur)
                        dp[i] = (dp[i] + dp[i-4])%(1000000000 + 7);
                }
            }
        }
        return dp[n];
    }
}
