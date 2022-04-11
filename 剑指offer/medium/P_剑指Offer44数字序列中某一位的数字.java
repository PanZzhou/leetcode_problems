package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer44数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;
        while(n>count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit) - '0';
    }
}
