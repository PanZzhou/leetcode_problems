package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer62圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        int ret = 0;
        for (int i = 2; i <= n; i++) {
            ret = (ret + m)%i;
        }
        return ret;
    }
}
