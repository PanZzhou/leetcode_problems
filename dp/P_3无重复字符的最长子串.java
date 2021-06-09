package com.pan.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class P_3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> mySet = new HashSet();
        int rk = -1, n =s.length(),res=0;
        for(int i=0;i<n;++i){
            if(i>0)
                mySet.remove(s.charAt(i-1));
            while(rk+1<n && !mySet.contains(s.charAt(rk+1))){
                mySet.add(s.charAt(rk+1));
                rk++;
            }
            res = Math.max(res, rk-i+1);
        }
        return res;
    }
}
