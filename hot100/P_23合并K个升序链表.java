package com.pan.leetcode.hot100;

import com.pan.leetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_23合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode root : lists) {
            if(root != null)
                minHeap.offer(root);
        }
        ListNode root = minHeap.peek(), cur=null,temp;
        while (!minHeap.isEmpty()){
            temp = minHeap.poll();
            if(temp.next != null)
                minHeap.offer(temp.next);
            if(cur != null)
                cur.next = temp;
            cur = temp;
            cur.next = null;
        }
        return root;
    }
}
