package com.pan.leetcode.everyday;

import com.pan.leetcode.linkedlist.ListNode;

public class P_25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = length(head);
        if(len <= 1) return head;
        int epoch = len/k;
        ListNode root = new ListNode();
        ListNode pre, cur = head, ppre = root, next,start;
        while(cur != null){
            if(epoch < 1){
                ppre.next = cur;
                break;
            }
            start = cur;
            pre = null;
            for (int i = 0; i < k && cur != null; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ppre.next = pre;
            ppre = start;
            epoch --;
        }
        return root.next;
    }
    private int length(ListNode head){
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }
}
