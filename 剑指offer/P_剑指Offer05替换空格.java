package com.pan.leetcode.剑指offer;

public class P_剑指Offer05替换空格 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch==' ')
                sb.append("%20");
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}
