package com.pan.leetcode.剑指offerII.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_剑指Offer_II_033变位词组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            int n = str.length();
            for (int i = 0; i < n; i++) {
                cnt[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(cnt[i]!=0)
                    sb.append((char)i+'a').append(cnt[i]);
            }
            String key = sb.toString();
            List<String> ans = map.getOrDefault(key, null);
            if(ans == null){
                ans = new ArrayList<>();
                ans.add(str);
                map.put(key, ans);
            }else
                ans.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
