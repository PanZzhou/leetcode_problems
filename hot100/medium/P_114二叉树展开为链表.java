package com.pan.leetcode.hot100.medium;

import com.pan.leetcode.tree.TreeNode;

public class P_114二叉树展开为链表 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        //递归过程中会改变指针指向，所以先把左右指针指向的对象记下来
        TreeNode left = root.left, right = root.right;
        if(pre != null){
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        flatten(left);
        flatten(right);
    }
}
