package com.pan.leetcode.dp.分割类;

import java.util.Arrays;
import java.util.List;

public class P_139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word))
                    dp[i] = dp[i] || dp[i - len];
            }
        }
        return dp[n];
    }
}
