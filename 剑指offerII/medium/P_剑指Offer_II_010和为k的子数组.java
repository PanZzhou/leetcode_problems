package com.pan.leetcode.剑指offerII.medium;

import java.util.HashMap;

public class P_剑指Offer_II_010和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        //有负数，不能简单使用滑动窗口
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0, ret =0, temp;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            temp = map.getOrDefault(pre-k, 0);
            ret += temp;
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return ret;
    }
}
