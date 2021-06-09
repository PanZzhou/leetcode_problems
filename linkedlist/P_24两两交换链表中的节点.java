package com.pan.leetcode.linkedlist;

import com.pan.leetcode.linkedlist.ListNode;

public class P_24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0,head);
        ListNode temp = dummyHead;
        while(temp.next!=null&&temp.next.next!=null){
            ListNode node1 = temp.next,node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
