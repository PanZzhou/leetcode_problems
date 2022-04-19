package com.pan.leetcode.剑指offer.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_剑指Offer59_I滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return new int[0];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        int[] ret = new int[n-k+1];
        ret[0] = maxHeap.peek()[0];
        for (int i = k; i < n; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            while(maxHeap.peek()[1]<=i-k)
                maxHeap.poll();
            ret[i-k+1] = maxHeap.peek()[0];
        }
        return ret;
    }
}
