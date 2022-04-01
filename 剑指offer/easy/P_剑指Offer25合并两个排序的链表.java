package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer25合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), cur = head;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null &&l1.val <= l2.val || l2==null) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
                cur.next = null;
            }else{
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
                cur.next = null;
            }
        }
        return head.next;
    }
}
