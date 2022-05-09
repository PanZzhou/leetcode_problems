package com.pan.leetcode.hot100.medium;

public class P_647回文子串 {
    public int countSubstrings(String s) {
        int ret, n = s.length();
        if(n <= 1) return n;
        ret = n;
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            vis[i][i] = true;
        }
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n-L; i++) {
                int j = i+L-1;
                vis[i][j] = s.charAt(i) == s.charAt(j);
                if(j>i+1)
                    vis[i][j] &= vis[i+1][j-1];
                if(vis[i][j]) ret++;
            }
        }
        return ret;
    }
}
