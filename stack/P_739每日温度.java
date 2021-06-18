package com.pan.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class P_739每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ret = new int[temperatures.length];
        int index = 0;
        while(index<temperatures.length){
            while(!stack.isEmpty()&&temperatures[stack.peekLast()]<temperatures[index]){
                int top = stack.pollLast();
                ret[top] = index-top;
            }
            stack.offerLast(index);
            index++;
        }
        return ret;
    }
}
