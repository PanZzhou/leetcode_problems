package com.pan.leetcode.剑指offer.hard;

public class P_剑指Offer19正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        //动态规划
        int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m+1][n+1];
        match[0][0] = true;
        for (int i = 1; i <= n; i++) {
            char pchar = p.charAt(i-1);
            if(pchar == '*')
                match[0][i] = match[0][i-2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pchar = p.charAt(j-1);
                char schar = s.charAt(i-1);
                if(pchar == '*'){
                    char ppre = p.charAt(j-2);
                    //匹配当前'*',不匹配当前'*'
                    match[i][j] = (charEqual(schar, ppre) & match[i-1][j]) | match[i][j-2];
                }else{
                    if(charEqual(schar, pchar))
                        match[i][j] = match[i-1][j-1];
                }
            }
        }
        return match[m][n];
    }

    private boolean charEqual(char s, char p){
        return s==p || p=='.';
    }
}
