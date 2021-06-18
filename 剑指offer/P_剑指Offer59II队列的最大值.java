package com.pan.leetcode.剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P_剑指Offer59II队列的最大值 {
    Queue<Integer>  queue;
    Deque<Integer>  stack;
    public P_剑指Offer59II队列的最大值() {
        queue = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public int max_value() {
        if(stack.isEmpty())
            return -1;
        return stack.peekFirst();
    }

    public void push_back(int value) {
        while(!stack.isEmpty()&&stack.peekLast()<value)
            stack.pollLast();
        stack.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int value = queue.poll();
        if(value==stack.peekFirst())
            stack.pollFirst();
        return value;
    }
}
