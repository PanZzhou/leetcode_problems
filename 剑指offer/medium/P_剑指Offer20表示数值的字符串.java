package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer20表示数值的字符串 {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        boolean isNum = false;
        boolean isDot = false;
        boolean isE = false;
        int i = 0;
        for (; i < s.length(); i++) {
            if(s.charAt(i) != ' ') break;
        }
        while(i<s.length()){
            char c = s.charAt(i);
            if(c>='0' && c<='9')
                isNum = true;
            else if(c=='.' && !isDot && !isE)
                isDot = true;
            else if((c=='e'||c=='E')&&!isE && isNum){
                isNum = false;
                isE = true;
            }else if((c=='+' || c=='-')&&(i==0 || s.charAt(i-1)=='e' || s.charAt(i-1)=='E')) {
            }
            else return false;
        }
        return isNum;
    }
}
