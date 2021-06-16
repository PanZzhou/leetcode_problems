package com.pan.leetcode.stack;

import java.util.Arrays;

public class P_316去除重复字母 {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        boolean[] visited = new boolean[26];//记录字符是否已经加入栈中
        int[] counts = new int[26];//记录当前循环位置之后还有多少个当前位置同类型的字符。
        Arrays.fill(counts,0);
        for (int i = 0; i < len; i++)
            counts[s.charAt(i)-'a'] += 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(!visited[ch-'a']){
                while(sb.length()>0&&sb.charAt(sb.length()-1)>ch){
                    if(counts[sb.charAt(sb.length()-1)-'a']>0){
                        visited[sb.charAt(sb.length()-1)-'a'] =false;
                        sb.deleteCharAt(sb.length()-1);
                    }else
                        break;
                }
                sb.append(ch);
                visited[ch-'a']=true;
            }
            counts[ch-'a'] -= 1;
        }
        return sb.toString();
    }
}
