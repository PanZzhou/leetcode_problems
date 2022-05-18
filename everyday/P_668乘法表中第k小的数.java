package com.pan.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class P_668乘法表中第k小的数 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m*n, x;
        while(left<right){
            x = (left+right)>>1;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; i++) {
                count += x / i;
            }
            if(count >= k)
                right = x;
            else
                left = x + 1;
        }
        return left;
    }
}
