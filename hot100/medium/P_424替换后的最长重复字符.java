package com.pan.leetcode.hot100.medium;

public class P_424替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n<=1) return n;
        int[] cnt = new int[26];
        int left = 0, right = 0, max = 0;
        while(right<n){
            cnt[s.charAt(right)-'A']++;
            max = Math.max(max, cnt[s.charAt(right)-'A']);
            if(right - left + 1 - max > k){
                cnt[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
