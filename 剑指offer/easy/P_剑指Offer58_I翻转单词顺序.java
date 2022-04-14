package com.pan.leetcode.剑指offer.easy;

import java.util.Locale;

public class P_剑指Offer58_I翻转单词顺序 {
    public String reverseWords(String s) {
        int len = s.length(), left = len-1, right=len-1;
        StringBuilder ret = new StringBuilder();
        while(right >= 0){
            if(left < 0 || s.charAt(left) == ' '){
                if(left < right){
                    ret.append(s.substring(left+1, right+1)).append(' ');
                }
                left--;
                right = left;
            }else
                left--;
        }
        if(ret.length()>1)
            ret.deleteCharAt(ret.length()-1);
        return ret.toString();
    }
}
