package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer46把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()+1];
        dp[0] = 1;//注意，无字符的情况也是一种译法而不是0种
        dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            num = (str.charAt(i-2)-'0')*10+str.charAt(i-1)-'0';
            if(num >= 10 && num <= 25)
                dp[i] = dp[i-2] + dp[i-1];
            else
                dp[i] = dp[i-1];
        }
        return dp[str.length()];
    }
}
