package com.pan.leetcode.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P_503下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2*len-1; i++) {
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i%len])
                res[stack.pop()] = nums[i%len];
            stack.push(i%len);
        }
        return res;
    }
}
