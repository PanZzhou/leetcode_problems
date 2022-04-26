package com.pan.leetcode.剑指offerII.medium;

import com.pan.leetcode.linkedlist.ListNode;

public class P_剑指Offer_II_025链表中的两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int m = cntList(l1), n = cntList(l2),flow = 0, all;
        ListNode cur1, cur2, pre = null;
        if(m<n){
            cur1 = l1;
            l1 = l2;
            l2 = cur1;
        }
        cur1 = l1;cur2 = l2;
        while(cur1 != null){
            all = cur1.val + flow;
            if(cur2 != null)
                all += cur2.val;
            cur1.val = all%10;
            flow = all/10;
            pre = cur1;
            cur1 = cur1.next;
            if(cur2 != null)
                cur2 = cur2.next;
        }
        if(flow!=0 && pre != null)
            pre.next = new ListNode(flow);
        return reverseList(l1);
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
    private int cntList(ListNode root){
        ListNode cur = root;
        int cnt = 0;
        while(cur!=null){
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }
}
