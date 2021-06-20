package com.pan.leetcode.剑指offer;

import java.util.Deque;
import java.util.LinkedList;

public class P_剑指Offer09用两个栈实现队列 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public P_剑指Offer09用两个栈实现队列() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.offerLast(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty())
                return -1;
            while(!stack1.isEmpty())
                stack2.offerLast(stack1.pollLast());
        }
        return stack2.pollLast();
    }
}
