package com.pan.leetcode.周赛.新的;

public class P_6083判断一个数的数字计数是否等于数位的值 {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int cur = num.charAt(i)-'0';
            cnt[cur]++;
        }
        for (int i = 0; i < n; i++) {
            int cur = num.charAt(i)-'0';
            if(cur != cnt[i])
                return false;
        }
        return true;
    }
}
