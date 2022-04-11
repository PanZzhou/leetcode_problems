package com.pan.leetcode.剑指offer.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_剑指Offer41数据流中的中位数 {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private int size;
    public P_剑指Offer41数据流中的中位数() {
        minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        size = 0;
    }

    public void addNum(int num) {
        int target = num;
        if(size % 2 == 0){
            if(!minHeap.isEmpty() && num > minHeap.peek()){
                target = minHeap.poll();
                minHeap.offer(num);
            }
            maxHeap.offer(target);
        }else{
            if(!maxHeap.isEmpty() && num <maxHeap.peek()){
                target = maxHeap.poll();
                maxHeap.offer(num);
            }
            minHeap.offer(target);
        }
        size++;
    }

    public double findMedian() {
        if(maxHeap.isEmpty())
            return 0;
        if(size % 2 == 1)
            return maxHeap.peek();
        return (double)(maxHeap.peek() + minHeap.peek()) / 2;
    }
}
