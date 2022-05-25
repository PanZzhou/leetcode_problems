package com.pan.leetcode.everyday;

import java.util.*;

public class P_467环绕字符串中唯一的子字符串 {
    //卧槽
    public int findSubstringInWraproundString(String p) {
        int[] alph = new int[26];
        int k = 1;
        for (int i = 0; i < p.length(); i++) {
            if(i>0 && ((p.charAt(i) - p.charAt(i-1)+26)%26 != 1)){
                k=1;
            }
            //要取最长的长度才行
            alph[p.charAt(i) - 'a'] = Math.max(alph[p.charAt(i) - 'a'], k);
            k++;
        }
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            ret += alph[i];
        }
        return ret;
    }
}
