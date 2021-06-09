package com.pan.leetcode.number;

//n的二进制位中，为1的地方就是要乘的地方
public class P_50Pow_x_n {
    public double myPow(double x, int n) {
        return n>=0?mypow1(x,n):1.0/mypow1(x,-n);
    }
    private double mypow1(double x,int n){
        double contribute = x;
        double res = 1.0;
        while(n>0){
            if(n%2==1)
                res *= contribute;
            contribute *= contribute;
            n /= 2;
        }
        return res;
    }
}
