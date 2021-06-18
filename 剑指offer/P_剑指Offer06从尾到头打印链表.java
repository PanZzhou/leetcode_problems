package com.pan.leetcode.剑指offer;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer06从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode index = head;
        while ((index!=null)){
            len++;
            index=index.next;
        }
        int[] res = new int[len];
        index=head;
        int cur = 0;
        while (index!=null){
            res[len-1-cur] = index.val;
            cur++;
            index=index.next;
        }
        return res;
    }
}
