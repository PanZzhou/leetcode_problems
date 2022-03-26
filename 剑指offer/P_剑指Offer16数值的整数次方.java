package com.pan.leetcode.剑指offer;

public class P_剑指Offer16数值的整数次方 {
    public double myPow(double x, int n) {
//        double ret = 1;
//        if(n<0){//负指数情况
//            n = -n;
//            x = 1/x;
//        }
//        //这种当指数很大时，会导致超出时间限制
//        while(n>0){
//            ret *= x;
//            n--;
//        }
//        return ret;
        if(x==0) return 0;
        if(x==1) return 1;
        long b=n;
        double res = 1.0;
        if(b<0){
            b = -b;
            x = 1/x;
        }
        while(b>0){
            if((b&1)==1) res *= x;
            x *= x;//bit从低到高是1、2、4、8、16...x的8次幂可以分解成两个x的4次幂相乘
            b >>= 1;
        }
        return res;
    }
}
