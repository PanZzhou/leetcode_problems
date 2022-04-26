package com.pan.leetcode.剑指offerII.medium;


import com.pan.leetcode.duallinkedlist.Node;

public class P_剑指Offer_II_028展平多级双向链表 {
    public Node flatten(Node head) {
        if(head == null || head.next == null && head.child == null) return head;
        Node cur = head,child,tail,post;
        while(cur != null){
            if(cur.child != null){
                child = flatten(cur.child);
                post = cur.next;
                cur.next = child;
                child.prev = cur;
                if(post != null){
                    tail = getTail(child);
                    tail.next = post;
                    post.prev = tail;
                }
                cur.child = null;
                cur = post;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
    private Node getTail(Node root){
        Node cur = root, pre = null;
        while(cur != null){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
}
