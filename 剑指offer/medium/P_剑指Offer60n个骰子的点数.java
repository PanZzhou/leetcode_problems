package com.pan.leetcode.剑指offer.medium;

import java.util.Arrays;

public class P_剑指Offer60n个骰子的点数 {
    public double[] dicesProbability(int n) {
        int len = 5*n+1;
        double[] ret = new double[len];
        for (int i = 0; i < 6; i++) {
            ret[i] = 1.0/6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = (i-1)*5; j >= 0; j--) {
                double cur = ret[j];
                ret[j] = 0.0;
                for (int k = 5; k >= 0; k--) {
                    ret[j+k] += cur/6.0;
                }
            }
        }
        return ret;
    }
}
