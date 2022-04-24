package com.pan.leetcode.剑指offerII.medium;

import java.util.HashMap;

public class P_剑指Offer_II_011题0和1个数相同的子数组 {
    //与P_剑指Offer_II_010和为k的子数组题类似
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int pre = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                pre += -1;
            else
                pre += nums[i];
            if(!map.containsKey(pre))
                map.put(pre, i);
            else
                ret = Math.max(ret, i-map.getOrDefault(pre, i+1));
        }
        return ret;
    }
}
