package com.pan.leetcode.everyday;

import java.util.List;

public class 华为5月11笔试第三题 {
    //第三题，n个格子放元件，设总的元件种类是K=2^k-1+1=2^k, 第一个格子可以放K种，受前一个格子元件的种类限制，第二个格子只能放K-1种了，第三个、第四个、...、第n个格子都只能放K-1种。代码如下：
    public int geaAllArrange(int n, int k){
        k = (int)Math.pow(2, k);
        int ret = k, mod = 100000007;
        for (int i = 2; i <= n; i++) {
            if(n%2 == 0 || i < 4 || i < n)
                ret = (k-1)*ret % mod;
            else
                ret = (k-2)*ret % mod;
        }
        return ret;
    }
}
