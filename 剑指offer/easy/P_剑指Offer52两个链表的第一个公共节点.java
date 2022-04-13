package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer52两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        ListNode a = headA, b = headB;
        if(sizeA < sizeB){
            a = headB;
            b = headA;
        }
        int diff = Math.abs(sizeA - sizeB);
        while(diff-- > 0)
            a = a.next;
        while(a!=null && b!=null){
            if(a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }

    private int getSize(ListNode root){
        ListNode cur = root;
        int size = 0;
        while(cur!=null){
            size++;
            cur = cur.next;
        }
        return size;
    }
}
