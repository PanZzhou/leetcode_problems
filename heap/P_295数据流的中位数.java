package com.pan.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
法一：可以用一个数组存储数据流，每一次取中位数的时候就来一次排序。
法二：维护一个有序数组，每次来数据的时候就把数据插入到合适的位置：插入排序。
法三：最大堆最小堆。
 */
public class P_295数据流的中位数 {
    PriorityQueue<Integer>  maxHeap;    //最大堆，存储小于中位数的那一半数据
    PriorityQueue<Integer>  minHeap;    //最小堆，存储大于中位数的那一半数据
    public P_295数据流的中位数() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>((a,b)->(b-a));
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if(maxHeap.size()>minHeap.size())
            minHeap.add(maxHeap.poll());
    }

    public double findMedian() {
        int x = minHeap.peek();
        if(minHeap.size()==maxHeap.size())
            return (x+maxHeap.peek())/2.0;
        return x;
    }
}
