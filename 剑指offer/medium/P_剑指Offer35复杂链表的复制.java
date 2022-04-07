package com.pan.leetcode.剑指offer.medium;

import com.pan.leetcode.linkedlist.Node;

public class P_剑指Offer35复杂链表的复制 {
    //拼接+拆分
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node cur = head, ret;
        //在链表中插入新节点
        while(cur != null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        //更行新节点的random域
        cur = head;
        while(cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分链表为两个链表，head.next就是返回的链表的第一个节点
        cur = head;
        ret = head.next;
        while(cur.next != null){
            Node temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return ret;
    }
}
