package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer66构建乘积数组 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] ret = new int[len];
        if(len == 0) return ret;
        int product = 1;
        for (int i = 0; i < len; i++) {
            ret[i] = product;
            product *= a[i];
        }
        product = 1;
        for (int i = len-1; i >= 0; i--) {
            ret[i] *= product;
            product *= a[i];
        }
        return ret;
    }
}
