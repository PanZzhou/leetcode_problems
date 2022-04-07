package com.pan.leetcode.剑指offer.medium;


import com.pan.leetcode.tree.Node;

import java.util.Stack;

public class P_剑指Offer36二叉搜索树与双向链表 {
    //实际上就是二叉树的线索化
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Stack<Node> stack = new Stack<>();
        Node cur = root, pre = null, head = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(head == null)
                head = cur;
            if(pre != null){
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        if(pre != null){
            head.left = pre;
            pre.right = head;
        }
        return head;
    }
}
