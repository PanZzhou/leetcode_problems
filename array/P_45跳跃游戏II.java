package com.pan.leetcode.array;

public class P_45跳跃游戏II {
    public int jump(int[] nums) {
        int len = nums.length;
        int steps = 0;
        int max_index = 0;
        int end = 0;
        for (int i = 0; i < len-1; i++) {
            max_index = Math.max(max_index,i+nums[i]);
            if(end == i){
                end = max_index;
                steps++;
            }
        }
        return steps;
    }
}
