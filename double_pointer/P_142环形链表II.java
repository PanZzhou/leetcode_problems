package com.pan.leetcode.double_pointer;

import com.pan.leetcode.linkedlist.ListNode;

public class P_142环形链表II {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == head) return head;
        if(head.next == null) return null;
        ListNode slow = head.next, fast = head.next;
        if(fast.next == null)
            return null;
        else
            fast = fast.next;
        while(slow != fast){
            slow = slow.next;
            if(fast.next == null || fast.next.next == null)
                return null;
            else
                fast = fast.next.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
