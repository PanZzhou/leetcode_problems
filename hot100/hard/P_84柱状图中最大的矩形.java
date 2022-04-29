package com.pan.leetcode.hot100.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P_84柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        //单调栈
        int n = heights.length;
        Deque<Integer> mono_stack = new ArrayDeque<>();
        int[] left = new int[n];
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while(!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i] ){
                int pre = mono_stack.pop();
                ret = Math.max(ret, heights[pre]*(i-left[pre]-1));
            }
            left[i] = mono_stack.isEmpty()?-1:mono_stack.peek();
            mono_stack.push(i);
        }
        if(!mono_stack.isEmpty() && mono_stack.peek() == n-1){
            while(!mono_stack.isEmpty()){
                int pre = mono_stack.pop();
                ret = Math.max(ret, heights[pre]*(n-left[pre]-1));
            }
        }
        return ret;
    }
}
