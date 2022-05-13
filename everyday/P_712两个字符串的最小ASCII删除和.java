package com.pan.leetcode.everyday;

public class P_712两个字符串的最小ASCII删除和 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(m==0 || n==0) return 0;
        int[][] ret = new int[m+1][n+1];
        for (int i = 1; i <= n; i++) {
            ret[0][i] = ret[0][i-1] + s2.charAt(i-1);
        }
        for (int j = 1; j <= m; j++) {
            ret[j][0] = ret[j-1][0] + s1.charAt(j-1);
        }
        for (int i = 1; i <= m; i++) {
            char a = s1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char b = s2.charAt(j-1);
                if(a == b){//相等，就都不删除
                    ret[i][j] = ret[i-1][j-1];
                }else{//不相等，就都删、只删a、只删b
                    ret[i][j] = Math.min(ret[i-1][j-1] + a + b,Math.min(ret[i-1][j] + a, ret[i][j-1] + b));
                }
            }
        }
        return ret[m][n];
    }
}
