package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer24反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode cur = null , next = head, last;
        while(next != null){
            last = next.next;
            next.next = cur;
            cur = next;
            next = last;
        }
        return cur;
    }
}
