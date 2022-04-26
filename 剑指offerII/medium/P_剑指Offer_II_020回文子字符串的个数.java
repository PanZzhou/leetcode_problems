package com.pan.leetcode.剑指offerII.medium;

public class P_剑指Offer_II_020回文子字符串的个数 {
    //最长公共子串：dp
    //最长回文子串  dp，manacher算法
    //最长公共子序列
    //最长回文子序列
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ret = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            ret++;
        }
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i+L-1;//有边界
                if(j>=len) break;
                char a = s.charAt(i);
                char c = s.charAt(j);
                if(j == i+1 && a == c){
                    dp[i][j] = true;
                    ret++;
                    continue;
                }
                if(a==c && dp[i+1][j-1]){
                    dp[i][j] = true;
                    ret++;
                }
            }
        }
        return ret;
    }
}
