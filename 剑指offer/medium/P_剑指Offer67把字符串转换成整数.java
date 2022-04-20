package com.pan.leetcode.剑指offer.medium;

import javax.print.DocFlavor;

public class P_剑指Offer67把字符串转换成整数 {
    public int strToInt(String str) {
        int start = 0, n = str.length(),ret=0;
        boolean isPositive = true;
        char a;
        while(start<n){
            a = str.charAt(start);
            if(a=='-' || a=='+' || Character.isDigit(a))
                break;
            if(a!=' ')
                return 0;
            start++;
        }
        if (start >= n) return 0;
        int max = Integer.MAX_VALUE/10;
        int appen = Integer.MAX_VALUE%10;
        int more;
        a = str.charAt(start);
        if(a == '-'){
            start++;
            isPositive = false;
            max = -(Integer.MIN_VALUE/10);
            appen = -(Integer.MIN_VALUE%10);
        }else if(a=='+')
            start++;
        while(start<n){
            a =  str.charAt(start);
            if(!Character.isDigit(a))
                break;
            more = a-'0';
            if(ret>max || ret==max && more>appen)
                return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            ret = ret*10+more;
            start++;
        }
        if(isPositive)
            return ret;
        return -ret;
    }
}
