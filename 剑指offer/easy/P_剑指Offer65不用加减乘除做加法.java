package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer65不用加减乘除做加法 {
    public int add(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        int overflow = 0;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int a_bit = (a>>i)&1;
            int b_bit = (b>>i)&1;
            if(overflow == 0){
                if(a_bit == 0 && b_bit == 0)
                    continue;
                else if(a_bit == 1 && b_bit == 1){
                    overflow = 1;
                }else
                    ret = ret | (1<<i);
            }else{
                if(a_bit == 0 && b_bit == 0){
                    ret = ret | (1<<i);
                    overflow = 0;
                }else if(a_bit ==1 && b_bit == 1)
                    ret = ret | (1<<i);
            }
        }
        return ret;
    }
}
