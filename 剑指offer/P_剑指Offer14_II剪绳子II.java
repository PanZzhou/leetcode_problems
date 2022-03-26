package com.pan.leetcode.剑指offer;

public class P_剑指Offer14_II剪绳子II {
    public int cuttingRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){//到最后的2m、3m和4m都直接乘上res即可
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }
}
