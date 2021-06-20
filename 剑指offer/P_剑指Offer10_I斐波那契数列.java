package com.pan.leetcode.剑指offer;

public class P_剑指Offer10_I斐波那契数列 {
    public int fib(int n) {
        if(n<=1)
            return n;
        int a=0,b=1,i=1,temp;
        while(i++<n){
            temp = (a+b)%1000000007;
            a=b;
            b=temp;
        }
        return b;
    }
}
