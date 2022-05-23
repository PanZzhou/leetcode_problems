package com.pan.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

public class P_678有效的括号字符串 {
    public boolean checkValidString(String s) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> star = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a == '*')
                star.add(i);
            else if(a == '('){
                left.add(i);
            }else{
                if(left.isEmpty())
                    right.add(i);
                else
                    left.remove(left.size()-1);
            }
        }
        System.out.println(left.size()+" "+right.size()+" "+star.size());
        int l=0, r = 0, ss = 0;
        while(ss<star.size() && r<right.size()){
            if(star.get(ss) < right.get(r)){
                ss++;
                r++;
            }else
                ss++;
        }
        if(r<right.size()) return false;
        while(ss<star.size() && l<left.size()){
            if(star.get(ss) < left.get(l))
                ss++;
            else{
                ss++;
                l++;
            }
        }
        if(l<left.size()) return false;
        return true;
    }
}
