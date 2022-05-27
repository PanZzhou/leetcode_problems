package com.pan.leetcode.周赛.第78场双周赛;

public class P_2269找到一个数字的K美丽值 {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int ret = 0;
        int n = str.length();
        if(n<k) return ret;
        if(n==k && num!=0) return 1;
        for (int i = k-1; i < n; i++) {
            int temp = Integer.parseInt(str.substring(i-k+1, i+1));
            if(temp!=0 && num%temp==0)
                ret++;
        }
        return ret;
    }
}
