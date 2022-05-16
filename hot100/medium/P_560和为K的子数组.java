package com.pan.leetcode.hot100.medium;

import java.util.HashMap;
import java.util.Map;

public class P_560和为K的子数组 {
    //不能使用滑动窗口，因为可能会有负数存在，可以使用前缀和
    public int subarraySum(int[] nums, int k) {
        int sum = 0, ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//表示前缀和为0的有一个
        for (int num : nums) {
            sum += num;
            ret += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ret;
    }
}
