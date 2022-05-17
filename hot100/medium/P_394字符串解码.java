package com.pan.leetcode.hot100.medium;

public class P_394字符串解码 {
    private int inx;
    public String decodeString(String s) {
        inx = 0;
        return dfs(s);
    }
    private String dfs(String s){
        StringBuilder prefix = new StringBuilder();
        int cnt = 0;
        while(inx<s.length()){
            char a = s.charAt(inx);
            if(a>='a' && a<='z')
                prefix.append(a);
            else if(a>='0' && a<='9')
                cnt = cnt*10 + a-'0';
            else if(a == '['){
                inx++;
                String suffix = dfs(s);
                for (int i = 0; i < cnt; i++) {
                    prefix.append(suffix);
                }
                cnt = 0;
            }else{
                return prefix.toString();
            }
            inx++;
        }
        return prefix.toString();
    }
}
