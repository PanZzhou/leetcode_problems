package com.pan.leetcode.hot100.easy;

public class P_338比特位计数 {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        ret[0] = 0;
        if(n == 0) return ret;
        ret[1] = 1;
        if(n==1) return ret;
        for (int i = 2; i <= n; i++) {
            ret[i] = ret[i/2];
            if(i%2 == 1)
                ret[i]++;
        }
        return ret;
    }
}
