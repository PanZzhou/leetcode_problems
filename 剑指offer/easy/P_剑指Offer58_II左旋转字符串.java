package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer58_II左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        n = n%len;
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(n));
            n = (n+1)%len;
        }
        return sb.toString();
    }
}
