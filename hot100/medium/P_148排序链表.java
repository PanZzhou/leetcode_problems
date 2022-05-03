package com.pan.leetcode.hot100.medium;

import com.pan.leetcode.linkedlist.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class P_148排序链表 {
    public ListNode sortList(ListNode head) {
//        插入排序
//        if(head == null) return head;
//        ListNode root = new ListNode(), cur = head, next = null, sort, sortnext;
//        while(cur!=null){
//            next = cur.next;
//            sort = root;
//            while(sort.next != null && cur.val > sort.next.val) sort = sort.next;
//            sortnext = sort.next;
//            sort.next = cur;
//            cur.next = sortnext;
//            cur = next;
//        }
//        head = root.next;
//        return head;

//        自下而上归并排序
        if(head == null) return null;
        ListNode dummy = new ListNode(0,head),cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        for (int sublen = 1; sublen < len; sublen <<= 1) {
            ListNode prev = dummy;
            cur = dummy.next;
            while(cur != null){
                ListNode head1 = cur, next=null;
                for (int i = 1; i < sublen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < sublen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merged = mergeList(head1, head2);
                prev.next = merged;
                while(prev.next != null) prev = prev.next;
                cur = next;
            }
        }
        return dummy.next;
    }

    private ListNode mergeList(ListNode root1, ListNode root2){
        ListNode dummy = new ListNode(), cur = dummy;
        while(root1 != null || root2 != null){
            if(root2 == null || (root1 != null &&  root1.val < root2.val)){
                cur.next = root1;
                cur = cur.next;
                root1 = root1.next;
                cur.next = null;
            }else{
                cur.next = root2;
                cur = cur.next;
                root2 = root2.next;
                cur.next = null;
            }
        }
        return dummy.next;
    }
}
