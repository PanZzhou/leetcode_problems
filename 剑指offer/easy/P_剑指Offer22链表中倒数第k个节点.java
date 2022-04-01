package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer22链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return head;
        ListNode pre = head, cur = head;
        while(k>0){
            if(pre == null && k>0)
                return null;
            pre = pre.next;
            k--;
        }
        while(pre!=null){
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }
}
