package com.pan.leetcode.dp;

public class P_5最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2)
            return s;
        boolean[][] flag = new boolean[len][len];
        for(int i=0;i<len;i++)
            flag[i][i] = true;
        char[] charArray = s.toCharArray();
        int L,begin=0,maxlen=1;
        for(L=2;L<=len;++L){
            for(int i=0;i<len;++i){
                int j = i+L-1;
                if(j>=len)
                    break;
                if(charArray[i]!=charArray[j])
                    flag[i][j] = false;
                else{
                    if(L<=3)
                        flag[i][j] = true;
                    else
                        flag[i][j] = flag[i+1][j-1];
                }
                if(flag[i][j]&&j-i+1>maxlen){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
}
