package com.pan.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;

public class P_438找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int n = s.length(), m = p.length();
        if(n<m) return ret;

        int[] vis = new int[26];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            vis[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(vis[i]!=0)
                cnt++;
        }
        int left = 0, right = 0;
        while(right < n){
            if(right - left >= m){
                int l = s.charAt(left) - 'a';
                if(vis[l] == 0)
                    cnt++;
                vis[l]++;
                if(vis[l] == 0)
                    cnt--;
                left++;
            }
            int r = s.charAt(right) - 'a';
            if(vis[r] == 0)
                cnt++;
            vis[r]--;
            if(vis[r] == 0)
                cnt--;
            right++;
            if(cnt == 0)
                ret.add(left);
        }
        return ret;
    }
}
