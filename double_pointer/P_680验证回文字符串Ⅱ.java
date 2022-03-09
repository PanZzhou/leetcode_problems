package com.pan.leetcode.double_pointer;

public class P_680验证回文字符串Ⅱ {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.length() <= 2) return true;
        int low = 0, high = s.length()-1;
        int rst_low = -1, rst_high = -1;
        while(low < high){
            if(s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }else break;
        }
        rst_low = low + 1;
        rst_high = high;
        boolean ret = true;
        while (rst_low < rst_high){
            if(s.charAt(rst_low) == s.charAt(rst_high)){
                rst_low++;
                rst_high--;
            }else{
                ret = false;
                break;
            }
        }
        if(!ret){
            rst_low = low;
            rst_high = high - 1;
            while (rst_low <= rst_high){
                if(s.charAt(rst_low) == s.charAt(rst_high)){
                    if(rst_low == rst_high || rst_low == rst_high - 1)
                        ret = true;
                    rst_low++;
                    rst_high--;
                }else break;
            }
        }
        return ret;
    }
}
