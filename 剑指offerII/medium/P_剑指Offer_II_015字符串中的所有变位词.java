package com.pan.leetcode.剑指offerII.medium;

import java.util.ArrayList;
import java.util.List;

public class P_剑指Offer_II_015字符串中的所有变位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int m = p.length(), n = s.length();
        if(m>n) return ret;
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[p.charAt(i)-'a']++;
            cnt[s.charAt(i)-'a']--;
        }
        int diff = 0;
        for (int i : cnt) {
            if(i!=0)
                diff++;
        }
        if(diff == 0) ret.add(0);
        for (int i = m; i < n; i++) {
            int x = s.charAt(i-m) - 'a', y = s.charAt(i)-'a';
            if(cnt[x] == 0)
                diff++;
            ++cnt[x];
            if(cnt[x]==0)
                diff--;
            if(cnt[y]==0)
                diff++;
            --cnt[y];
            if(cnt[y]==0)
                diff--;
            if(diff == 0) ret.add(i-m+1);
        }
        return ret;
    }
}
