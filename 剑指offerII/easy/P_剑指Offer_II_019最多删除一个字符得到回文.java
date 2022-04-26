package com.pan.leetcode.剑指offerII.easy;

public class P_剑指Offer_II_019最多删除一个字符得到回文 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right){
            char a = s.charAt(left);
            char c = s.charAt(right);
            if(a==c){
                left++;
                right--;
            }else{
                return ishuiwen(s, left, right-1) || ishuiwen(s, left+1, right);
            }
        }
        return true;
    }
    private boolean ishuiwen(String s, int left, int right){
        while(left<right){
            char a = s.charAt(left), c = s.charAt(right);
            if(a!=c) return false;
            left++;
            right--;
        }
        return true;
    }
}
