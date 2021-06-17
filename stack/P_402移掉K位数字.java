package com.pan.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class P_402移掉K位数字 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        int len = num.length();
        int index=0;
        while(index<len){
            char ch = num.charAt(index);
            while(!stack.isEmpty()&&k>0&&stack.peekLast()>ch) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(ch);
            index++;
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean firstIsZero = true;
        while(!stack.isEmpty()){
            char digit = stack.pollFirst();
            if(firstIsZero&&digit=='0')
                continue;
            firstIsZero=false;
            ret.append(digit);
        }
        return ret.length()==0?"0":ret.toString();
    }
}
