package com.pan.leetcode.string;

public class P_43字符串相乘 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        String ans = "0";
        int len1 = num1.length(), len2 = num2.length();
        for (int i = len2-1; i >=0; i--) {
            StringBuffer sb = new StringBuffer();
            int add = 0;
            for(int j=len2-1;j>i;j--)
                sb.append('0');
            int y = num2.charAt(i)-'0';
            for(int j=len1-1;j>=0;j--){
                int x = num1.charAt(j)-'0';
                add += x*y;
                sb.append(add%10);
                add /=10;
            }
            if(add!=0)
                sb.append(add);
            ans = add(ans,sb.reverse().toString());
        }
        return ans;
    }
    private String add(String str1, String str2){
        int i = str1.length()-1, j = str2.length()-1,add=0;
        StringBuffer sb = new StringBuffer();
        while(i>=0||j>=0||add!=0){
            int first = i>=0?str1.charAt(i)-'0':0;
            int second = j>=0?str2.charAt(j)-'0':0;
            add += first+second;
            sb.append(add%10);
            add /= 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
