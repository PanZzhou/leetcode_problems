package com.pan.leetcode.string;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

public class P_6Z字形变换 {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(len<=1||numRows<=1)
            return s;
        StringBuilder sb = new StringBuilder();
        int step = 2*numRows -2;   //步长
        for(int i=0;i<numRows;i++) {
            for(int j=0;j+i<len;j+=step){
                sb.append(s.charAt(i+j));
                if(i!=0&&i!=numRows-1&&j+step-i<len)
                    sb.append(s.charAt(j+step-i));
            }
        }
        return sb.toString();
    }
}
