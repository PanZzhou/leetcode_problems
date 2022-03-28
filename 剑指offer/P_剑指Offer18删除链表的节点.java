package com.pan.leetcode.剑指offer;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer18删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        ListNode list = new ListNode();
        list.next = head;
        ListNode cur = list.next;
        head = list;
        while (cur!=null){
            if(cur.val == val){
                head.next = cur.next;
                cur.next = null;
                break;
            }
            head = cur;
            cur = cur.next;
        }
        head = list.next;
        list.next = null;
        return head;
    }
}
