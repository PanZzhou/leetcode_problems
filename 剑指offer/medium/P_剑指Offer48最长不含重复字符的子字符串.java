package com.pan.leetcode.剑指offer.medium;

import java.util.HashSet;
import java.util.Set;

public class P_剑指Offer48最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ret = 0;
        Set<Character> set = new HashSet<>();
        while(r<s.length()){
            char a = s.charAt(r);
            if(!set.contains(a)){
                set.add(a);
                r++;
                ret = Math.max(ret, r-l);
            }else{
                char c = s.charAt(l);
                set.remove(c);
                if(l<r)
                    l++;
            }
        }
        return ret;
    }
}
