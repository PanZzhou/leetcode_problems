package com.pan.leetcode.hot100.hard;

import java.util.ArrayList;
import java.util.List;

public class P_301删除无效的括号 {
    private List<String> ret;
    public List<String> removeInvalidParentheses(String s) {
        ret = new ArrayList<>();
        int lremove = 0, rremove = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a == '('){
                lremove ++;
            }else if(a == ')'){
                if(lremove==0)
                    rremove++;
                else
                    lremove--;
            }
        }
        helper(s, 0, lremove, rremove);
        return ret;
    }
    private void helper(String s, int start, int lremove, int rremove){
        if(lremove == 0 && rremove == 0){
            if(isValid(s)){
                ret.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(i>start && s.charAt(i) == s.charAt(i-1))
                continue;
            if(lremove + rremove > s.length() - i)
                return;
            String s1 = s.substring(0, i) + s.substring(i + 1);
            if(lremove>0 && s.charAt(i) == '(')
                helper(s1, i, lremove-1, rremove);
            if(rremove>0 && s.charAt(i) == ')')
                helper(s1, i, lremove, rremove-1);
        }
    }
    private boolean isValid(String s){
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a=='(')
                cnt++;
            else if(a==')'){
                cnt--;
                if(cnt<0)
                    return false;
            }
        }
        return cnt == 0;
    }
}
