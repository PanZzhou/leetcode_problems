package com.pan.leetcode.everyday;

public class P_1021删除最外层的括号 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            if(a == '('){
                cnt++;
                if(cnt > 1) sb.append(a);
            }else{
                cnt--;
                if(cnt>0) sb.append(a);
            }
        }
        return sb.toString();
    }
}
