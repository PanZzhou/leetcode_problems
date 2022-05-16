package com.pan.leetcode.hot100.easy;

import java.util.ArrayList;
import java.util.List;

public class P_448找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums[i]);
            if(nums[cur-1] > 0)
                nums[cur-1] = -nums[cur - 1];//取反标记
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) ret.add(i+1);
        }
        return ret;
    }
}
