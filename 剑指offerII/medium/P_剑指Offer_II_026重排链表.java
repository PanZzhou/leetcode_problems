package com.pan.leetcode.剑指offerII.medium;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer_II_026重排链表 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode first = head,second = head, fstNext, sedNext;
        int cnt = cntList(first), precnt = (cnt+1)/2;
        if(cnt == 2) return;
        while(precnt-- > 0){
            first = second;
            second = second.next;
        }
        first.next = null;
        first = head;
        second = reverseList(second);
        while(second != null){
            fstNext = first.next;
            sedNext = second.next;
            first.next = second;
            second.next = fstNext;
            first = fstNext;
            second = sedNext;
        }
    }
    private int cntList(ListNode root){
        int cnt = 0;
        while(root != null){
            cnt++;
            root = root.next;
        }
        return cnt;
    }
    private ListNode reverseList(ListNode root){
        ListNode pre = null, cur = root,temp;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
