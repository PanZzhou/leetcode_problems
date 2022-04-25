package com.pan.leetcode.剑指offerII.medium;

import javax.print.DocFlavor;
import java.util.HashMap;

public class P_剑指Offer_II_016不含重复字符的最长子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return len;
        int left = 0, right = 0, ret = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        while(left<len){
            if(right < len && (map.getOrDefault(s.charAt(right), 0) == 0 || left >= right)){
                char a = s.charAt(right++);
                map.put(a, 1);
            }else{
                char a = s.charAt(left++);
                int cnt = map.getOrDefault(a, 0);
                if(cnt > 0){
                    map.put(a, cnt-1);
                }
            }
            ret = Math.max(ret, right-left);
        }
        return ret;
    }
}
