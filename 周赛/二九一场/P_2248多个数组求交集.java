package com.pan.leetcode.周赛.二九一场;

import java.util.ArrayList;
import java.util.List;

public class P_2248多个数组求交集 {
    public List<Integer> intersection(int[][] nums) {
        int m = nums.length, n;
        List<Integer> ret = new ArrayList<>();
        if(m == 0) return ret;
        int[] target = new int[1000];
        for (int i = 0; i < m; i++) {
            n = nums[i].length;
            for (int j = 0; j < n; j++) {
                ++target[nums[i][j]-1];
            }
        }
        for (int i = 0; i < target.length; i++) {
            if(target[i] == m)
                ret.add(i+1);
        }
        return ret;
    }
}
