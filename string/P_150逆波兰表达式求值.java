package com.pan.leetcode.string;

import sun.rmi.server.InactiveGroupException;

import java.util.Stack;

public class P_150逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        int len = tokens.length,i=0;
        Stack<Integer> stack = new Stack<>();
        while(i<len){
            String token = tokens[i];
            if(isNumber(token))
                stack.push(Integer.parseInt(token));
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token){
                    case "+":stack.push(num1+num2);break;
                    case "-":stack.push(num1-num2);break;
                    case "*":stack.push(num1*num2);break;
                    case "/":stack.push(num1/num2);break;
                    default:
                }
            }
            i++;
        }
        return stack.pop();
    }

    private boolean isNumber(String token){
        return !("+".equals(token)||"-".equals(token)||"*".equals(token)||"/".equals(token));
    }
}
