package com.pan.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for (String str : strs) {
            int[] letter = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++) {
                letter[str.charAt(i)-'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if(letter[i]!=0){
                    sb.append((char)(i+'a'));
                    sb.append(letter[i]);
                }
            }
            String key = sb.toString();
            List<String> now = res.getOrDefault(key, new ArrayList<>());
            now.add(str);
            res.put(key,now);
        }

        return new ArrayList<List<String>>(res.values());
    }
}
