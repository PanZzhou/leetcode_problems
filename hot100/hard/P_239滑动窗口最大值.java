package com.pan.leetcode.hot100.hard;

import org.junit.experimental.max.MaxHistory;

import java.util.*;

public class P_239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums.length == 0) return new int[]{};
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] - o1[0];
//            }
//        });
//        for (int i = 0; i < k; i++) {
//            if(i>=nums.length){
//                return new int[]{maxHeap.peek()[0]};
//            }
//            maxHeap.offer(new int[]{nums[i], i});
//        }
//        int[] ret = new int[nums.length - k + 1];
//        ret[0] = maxHeap.peek()[0];
//        for (int i = k; i < nums.length; i++) {
//            maxHeap.offer(new int[]{nums[i], i});
//            while(maxHeap.peek()[1]<i-k+1) maxHeap.poll();
//            ret[i-k+1] = maxHeap.peek()[0];
//        }
//        return ret;
//        单调队列方法
        int n = nums.length;
        if(n == 0) return new int[]{};
        if(n == 1) return new int[]{nums[0]};
        Deque<Integer> monoQueue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while(!monoQueue.isEmpty() && nums[monoQueue.peekLast()] <= nums[i])
                monoQueue.pollLast();
            monoQueue.offerLast(i);
        }
        int[] ret = new int[n-k+1];
        ret[0] = nums[monoQueue.peekFirst()];
        for (int i = k; i < n; i++) {
            while(!monoQueue.isEmpty() && nums[monoQueue.peekLast()] <= nums[i])
                monoQueue.pollLast();
            monoQueue.offerLast(i);
            while(monoQueue.peekFirst() < i-k+1)
                monoQueue.pollFirst();
            ret[i-k+1] = nums[monoQueue.peekFirst()];
        }
        return ret;
    }
}
