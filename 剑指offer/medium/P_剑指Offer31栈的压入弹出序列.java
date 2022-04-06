package com.pan.leetcode.剑指offer.medium;

import java.util.Stack;

public class P_剑指Offer31栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int inx = 0;
        for (int i = 0; i < popped.length; i++) {
            //相同数，则循环出栈
            if(!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
            }else{
                //不同数，则进栈
                while(inx<pushed.length && pushed[inx]!=popped[i]){
                    stack.push(pushed[inx++]);
                }
                inx++;
            }

        }
        return stack.isEmpty();
    }
}
