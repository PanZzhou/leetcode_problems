package com.pan.leetcode.周赛.二九四场;

public class P_6074字母在字符串中的百分比 {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        if(n == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(letter == s.charAt(i))
                cnt++;
        }
        return cnt*100/n;
    }
}
