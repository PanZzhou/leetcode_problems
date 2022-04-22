package com.pan.leetcode.剑指offerII.easy;

public class P_剑指Offer_II_002二进制加法 {
    public String addBinary(String a, String b) {
        int len_a = a.length(), len_b = b.length();
        int i = len_a-1, j = len_b-1;
        char flow = '0',A=' ',B=' ';
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>= 0){
            if(i>=0) A = a.charAt(i);
            else A = ' ';
            if(j>=0) B = b.charAt(j);
            else B = ' ';
            int count = 0;
            if(flow == '1') count++;
            if(A == '1') count++;
            if(B == '1') count++;
            if(count == 0){
                sb.append('0');
                flow = '0';
            }else if(count == 1){
                sb.append('1');
                flow = '0';
            }else if(count == 2){
                sb.append('0');
                flow = '1';
            }else{
                sb.append('1');
                flow = '1';
            }
            i--;j--;
        }
        if(flow == '1')
            sb.append(flow);
        return sb.reverse().toString();
    }
}
