package com.pan.leetcode.周赛.二九二场;

public class P_6056字符串中最大的3位相同数字 {
    public String largestGoodInteger(String num) {
        int size = num.length();
        if(size < 3) return "";
        int start = -1;
        char target = '0', pre = num.charAt(1), ppre = num.charAt(0), cur;
        for (int i = 2; i < size; i++) {
            cur = num.charAt(i);
            if(cur == pre && cur == ppre){
                if(cur >= target){
                    start = i;
                    target = cur;
                }
            }
            ppre = pre;
            pre = cur;
        }
        if(start == -1)
            return "";
        return num.substring(start-2, start+1);
    }
}
