package com.pan.leetcode.剑指offer.hard;

public class P_剑指Offer43_1到n整数中1出现的次数 {
    public int countDigitOne(int n) {
        int ret = 0, high = n/10, cur = n%10, low = 0, digit = 1;
        while(high != 0 || cur != 0){
            if(cur == 0){
                ret += high * digit;
            }else if(cur == 1){
                ret += high * digit + low + 1;
            }else
                ret += (high + 1)*digit;
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high /= 10;
        }
        return ret;
    }
}
