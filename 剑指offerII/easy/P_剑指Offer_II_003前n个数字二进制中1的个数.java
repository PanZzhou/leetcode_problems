package com.pan.leetcode.剑指offerII.easy;

public class P_剑指Offer_II_003前n个数字二进制中1的个数 {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        ret[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i%2 == 0)
                ret[i] = ret[i/2];
            else
                ret[i] = ret[i-1]+1;
        }
        return ret;
    }
}
