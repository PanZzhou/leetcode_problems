package com.pan.leetcode.string;

import java.util.Stack;

public class P_71简化路径 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        for (String string : strings) {
            if(string.equals("")||string.equals(".")||(string.equals("..")&&stack.isEmpty())) continue;
            if(string.equals("..")&&!stack.isEmpty())
                stack.pop();
            else
                stack.push(string);
        }
        return "/"+String.join("/",stack);
    }
}
