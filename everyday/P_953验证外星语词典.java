package com.pan.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

public class P_953验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length <= 1) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            while(j<words[i].length() && j<words[i-1].length()){
                int a = map.get(words[i].charAt(j)), b = map.get(words[i-1].charAt(j));
                if(a < b)
                    return false;
                else if(a > b)
                    break;
                j++;
            }
            if(j == words[i].length() && j < words[i-1].length())
                return false;
        }
        return true;
    }
}
