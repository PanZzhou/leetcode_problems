package com.pan.leetcode.剑指offer.medium;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P_剑指Offer59_II队列的最大值 {
    PriorityQueue<int[]> maxHeap;
    Deque<Integer> queue;
    int right;
    int left;
    public P_剑指Offer59_II队列的最大值() {
        maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        queue = new LinkedList<>();
        left = 1;
        right = 1;
    }

    public int max_value() {
        if(queue.isEmpty())
            return -1;
        return maxHeap.peek()[0];
    }

    public void push_back(int value) {
        queue.offer(value);
        maxHeap.offer(new int[]{value, right});
        right++;
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        while(!maxHeap.isEmpty() && maxHeap.peek()[1]<=left)
            maxHeap.poll();
        left++;
        return queue.poll();
    }
}
