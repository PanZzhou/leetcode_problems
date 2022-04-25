package com.pan.leetcode.剑指offerII.medium;

import java.util.Arrays;
import java.util.HashSet;

public class P_剑指Offer_II_014字符串中的变位词 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(m>n) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[s1.charAt(i)-'a']++;
            cnt[s2.charAt(i)-'a']--;
        }
        int diff = 0;
        for (int i : cnt) {
            if(i!=0)
                diff++;
        }
        if(diff == 0) return true;
        for (int i = m; i < n; i++) {
            int x = s2.charAt(i-m) - 'a', y = s2.charAt(i)-'a';
            if(x==y) continue;
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
            if(diff == 0) return true;
        }
        return false;
    }
}
