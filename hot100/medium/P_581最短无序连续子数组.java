package com.pan.leetcode.hot100.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_581最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length, right = -1;
        Deque<Integer> minStack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums.length;
            while(!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) min = minStack.pop();
            if(min < left) left = min;
            minStack.push(i);
            if(nums[max] > nums[i])
                max = i;
            else
                right = i;

        }
        if(right == -1)
            return 0;
        return right - left + 1;
    }
}
