package com.pan.leetcode.hot100.medium;

import java.util.HashSet;
import java.util.Set;

public class P_128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int ret = 0, cur = 0, num;
        for (int i = 0; i < n; i++) {
            if(!set.contains(nums[i]-1)){
                num = nums[i]+1;
                cur++;
                while(set.contains(num)){
                    cur++;
                    num++;
                }
            }
            if(cur != 0){
                ret = Math.max(ret, cur);
                cur = 0;
            }
        }
        return ret;
    }
}
