package com.pan.leetcode.linkedlist;

import com.pan.leetcode.linkedlist.ListNode;

public class P_61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        int len=0;
        ListNode first = head,second = head;
        while(first!=null){
            len++;
            first=first.next;
        }
        if(len<=1)
            return head;
        k = k%len;
        int index=0;
        while(index++<k)
            second = second.next;
        first=head;
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        second.next=head;
        head = first.next;
        first.next=null;
        return head;
    }
}
