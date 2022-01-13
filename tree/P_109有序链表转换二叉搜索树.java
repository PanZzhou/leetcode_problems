package com.pan.leetcode.tree;

import com.pan.leetcode.linkedlist.ListNode;

public class P_109有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    private TreeNode build(ListNode left, ListNode right){
        if(left == right)
            return null;
        ListNode mid = getMidNode(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = build(left, mid);
        root.right = build(mid.next, right);
        return root;
    }

    private ListNode getMidNode(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while(fast!=right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
