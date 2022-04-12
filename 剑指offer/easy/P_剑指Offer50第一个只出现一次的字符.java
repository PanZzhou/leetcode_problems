package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer50第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        int[] vis = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            vis[a-'a']++;
        }
        char ret = ' ';
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(vis[a-'a'] == 1){
                ret = a;
                break;
            }
        }
        return ret;
    }
}
