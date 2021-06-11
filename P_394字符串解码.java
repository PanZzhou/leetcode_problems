package com.pan.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class P_394字符串解码 {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        int i =0;
        while(i<s.length()){
            char c = s.charAt(i++);
            if(c=='[')
                stack.push("[");
            else if(Character.isLetter(c)){
                StringBuffer sb = new StringBuffer();
                sb.append(c);
                while(i<s.length()&&Character.isLetter((c=s.charAt(i)))){
                    sb.append(c);
                    i++;
                }
                if(sb.length()>0)
                    stack.push(sb.toString());
            }else if(Character.isDigit(c)){
                StringBuffer sb = new StringBuffer();
                sb.append(c);
                while(i<s.length()&&Character.isDigit((c=s.charAt(i)))){
                    sb.append(c);
                    i++;
                }
                if(sb.length()>0)
                    stack.push(sb.toString());
            }else{
                String top;
                String res = "";
                while(!(top=stack.pop()).equals("["))
                    res = top+res;
                int num = Integer.parseInt(stack.pop());
                while(num-->0)
                    stack.push(res);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty())
            sb.append(stack.pollLast());
        return sb.toString();
    }
}
