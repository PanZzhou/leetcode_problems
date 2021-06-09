package com.pan.leetcode.string;

public class P_8字符串转成整数 {

    public int myAtoi(String s) {
        s = s.trim();
        int len = s.length();
        if(len==0)
            return 0;
        char a = s.charAt(0);
        if(a!='+'&&a!='-'&&!Character.isDigit(a))
            return 0;
        boolean neg = (a=='-');
        int index = (Character.isDigit(a)?0:1);
        int res = 0;
        while(index<len&&Character.isDigit(s.charAt(index))){
            a = s.charAt(index++);
            int temp = ((neg?Integer.MIN_VALUE:Integer.MIN_VALUE+1)+(a-'0'))/10;
            if(temp>res)
                return neg? Integer.MIN_VALUE: Integer.MAX_VALUE;
            res = res * 10 - (a - '0');
        }
        return neg? res:-res;
    }
}
