package com.pan.leetcode.剑指offer;

public class P_剑指Offer10_II青蛙跳台阶问题 {
    public int numWays(int n) {
        if(n<=1)
            return 1;
        int a=1,b=1,temp,i=1;
        while(i++<n){
            temp =(a+b)%1000000008;
            a=b;
            b=temp;
        }
        return b;
    }
}
