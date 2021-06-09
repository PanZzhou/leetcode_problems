package com.pan.leetcode.linkedlist;

public class P_19删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int step = 0;
        ListNode preHead = new ListNode();
        preHead.next=head;
        ListNode tmp = preHead;
        while(step++<n && tmp.next!=null) tmp = tmp.next;
        if(step<n)
            return head;
        head = preHead;
        while(tmp.next!=null){
            tmp=tmp.next;
            head=head.next;
        }
        head.next = head.next.next;
        return preHead.next;
    }
}

