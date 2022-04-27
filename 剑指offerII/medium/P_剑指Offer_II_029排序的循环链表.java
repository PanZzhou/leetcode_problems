package com.pan.leetcode.剑指offerII.medium;

import com.pan.leetcode.linkedlist.Node;

public class P_剑指Offer_II_029排序的循环链表 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null){
            node.next = node;
            return node;
        }
        Node cur = head;
        while(cur.next != head){
            if(cur.next.val < cur.val){
                if(cur.next.val >= insertVal) break;//交界处
                else if(cur.val <= insertVal) break;//交界处
            }
            if(cur.val <= insertVal && cur.next.val >= insertVal) break;
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return head;
    }
}
