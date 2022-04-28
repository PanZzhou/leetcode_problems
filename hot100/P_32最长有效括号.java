package com.pan.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class P_32最长有效括号 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int ret = 0;
        Deque<Integer> stack = new LinkedList<>();
        boolean filled = true;
        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);
            if(a == '(') stack.push(i);
            else{
                if(stack.isEmpty() || s.charAt(stack.peek()) == ')')
                    stack.push(i);
                else
                    stack.pop();
            }
        }
        if(stack.isEmpty()) return len;
        int pre = len,left = 0;
        while(!stack.isEmpty()){
            left = stack.pop();
            ret = Math.max(ret, pre-left-1);
            pre = left;
        }
        ret = Math.max(ret, left);
        return ret;
    }
}
