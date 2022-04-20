package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer63股票的最大利润 {
    //假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票 一次 可能获得的最大利润是多少？
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = Integer.MAX_VALUE/2;
        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret = Math.max(ret, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return ret;
    }
}
