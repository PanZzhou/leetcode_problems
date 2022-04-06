package com.pan.leetcode.剑指offer.easy;

import java.util.Stack;

public class P_剑指Offer30包含min函数的栈 {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public P_剑指Offer30包含min函数的栈() {
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        int top = minstack.peek();
        if(x <= top)
            minstack.push(x);
    }

    public void pop() {
        int top = stack.pop();
        if(top == minstack.peek())
            minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
