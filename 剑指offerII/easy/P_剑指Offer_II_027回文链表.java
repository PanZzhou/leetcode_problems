package com.pan.leetcode.剑指offerII.easy;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer_II_027回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode first = head,second = head;
        int cnt = cntList(first), precnt = (cnt+1)/2;
        while(precnt-- > 0){
            first = second;
            second = second.next;
        }
        first.next = null;
        first = head;
        second = reverseList(second);
        while(second != null){
            if(first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
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
