package com.pan.leetcode.剑指offerII.easy;

public class P_剑指Offer_II_018有效的回文 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right){
            char a = s.charAt(left);
            if(!isChar(a)){
                left++;
                continue;
            }
            char c = s.charAt(right);
            if(!isChar(c)){
                right--;
                continue;
            }
            if(!equalChar(a,c))
                return false;
            left++;
            right--;
        }
        return true;
    }
    private boolean isChar(char a){
        return a>='a' && a<='z' || a>='A' && a<='Z' || a>='0' && a<='9';
    }
    private boolean equalChar(char a, char c){
        if(a>='A' && a<='Z')
            a = (char)(a+32);
        if(c>='A' && c<='Z')
            c = (char)(c+32);
        return a==c;
    }
}
