package com.pan.leetcode.剑指offer;

public class P_剑指Offer17打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;
        int[] ret = new int[max];
        for (int i = 0; i < max; i++) {
            ret[i] = i+1;
        }
        return ret;
    }
}
