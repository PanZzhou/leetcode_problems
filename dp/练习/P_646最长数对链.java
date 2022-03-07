package com.pan.leetcode.dp.练习;

import java.util.Arrays;

public class P_646最长数对链 {
    //最长递增子序列变种
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b)-> a[1] - b[1]);//先让部分有序，题目中规定可以无顺序选取元素出来
        int n = pairs.length;
        if(n <= 1) return n;
        int[][] dp = new int[n][2];
        dp[0] = pairs[0];
        int inx = 0;
        for (int i = 1; i < n; i++) {
            if(pairs[i][0] > dp[inx][1])
                dp[++inx] = pairs[i];
            else{
                int low = 0 , high = inx, mid = inx;
                while(low <= high){
                    mid = (low + high) >> 1;
                    if(pairs[i][0] > dp[mid][1])
                        low = mid + 1;
                    else if(pairs[i][1] < dp[mid][0])
                        high = mid - 1;
//                    else if(mid-1 >= 0 && pairs[i][0] <= dp[mid-1][1] || mid+1 < n && pairs[i][1] >= dp[mid+1][0])
//                        break;
//                    else if(pairs[i][0] <= dp[mid][0] && pairs[i][1] >= dp[mid][1])
//                        break;
                    else if(pairs[i][1] < dp[mid][1] && (mid-1>=0 && pairs[i][0] > dp[mid-1][1] || mid == 0 )){
                        dp[mid] = pairs[i];
                        break;
                    }else break;
                }
            }
        }
        return inx + 1;
    }
}
