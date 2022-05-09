package com.pan.leetcode.hot100.hard;

import javax.print.DocFlavor;
import java.util.*;

public class P_629K个逆序对数组 {
    public int kInversePairs(int n, int k) {
        if(n<2) return k==0?1:0;
        if(n == 2) return k==1 || k==0 ?1:0;
        if(k==0) return 1;
        int len = 1 + n*(n-1)/2;
        if(len-1 < k) return 0;
        int[] ret = new int[k+1];
        int[] other = new int[k+1],temp;
        ret[0] = 1;
        int preLen = 1, curLen, left, right, cur, sum, win, mod = 1000000007;
        for (int i = 1; i < n; i++) {
            curLen = preLen + i;
            win = i+1;
            left = 0;
            right = 0;
            cur = 0;
            sum = 0;
            while(cur<curLen && cur<=k){
                if(right - left >= win){
                    sum -= ret[left++];
                }
                sum += ret[right++];
                if(sum >= mod)
                    sum -= mod;
                else if(sum < 0)
                    sum += mod;
                other[cur] = sum;
                if(curLen - cur -1 <= k)
                    other[curLen - cur -1] = sum;
                cur++;
            }
            temp = other;
            other = ret;
            ret = temp;
            preLen = curLen;
        }
        return ret[k];
    }
}
