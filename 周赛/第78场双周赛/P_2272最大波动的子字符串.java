package com.pan.leetcode.周赛.第78场双周赛;

import java.util.Arrays;

public class P_2272最大波动的子字符串 {
    public int largestVariance(String s) {
        int n = s.length();
        int[][] diff = new int[26][26];
        int[][] diffWithb = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(diffWithb[i], -n);
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if(a == j) continue;
                ++diff[a][j];
                ++diffWithb[a][j];
                --diff[j][a];
                diffWithb[j][a] = diff[j][a];
                diff[j][a] = Math.max(0, diff[j][a]);
                ret = Math.max(ret, Math.max(diffWithb[a][j], diffWithb[j][a]));
            }
        }
        return ret;
    }
}
